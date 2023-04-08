# JVM deep dive

### Intro

JVM의 Runtime Data Area 영역에서
객체가 생성되는 과정을 깊게 파고 들어가 볼 것이다.
아래와 같은 Product 클래스가 있다고 가정해보자 이 클래스의 오브젝트를 생성 해보도록 하자

```
public class Product {
  public static final int PAYMENT_WINDOW_TITLE_MAX_BYTE = 4000;
  public static final String ERROR_MESSAGE = "ERROR";

  private GlobalProduct globalProduct = new GlobalProduct();
  private String productId;
  private ProductMeta productMeta;

  public String getProductName() {
    return globalProduct.getProductName();
  }

  public static String getTitleUsingPaymentWindow(Product product) {
    String title = product.getProductName();
    if(title.getBytes().length > PAYMENT_WINDOW_TITLE_MAX_BYTE) {
      System.out.println(ERROR_MESSAGE);
    }
    return title;
  }

  public class Main {
    public static void main(String args[]) {
      Product p = new Product();
    }
  }
}
```

위의 Product 클래스를 오브젝트화 하는 코드의 오브젝트 생성과정은 다음과 같다.

1. Product 클래스의 static 멤버(field/method)에 처음으로 접근하거나, 생성자를 처음으로 호출하는 경우 java interpreter는
   Product.class 파일을 class loader가 classpath 아래에서 Product.class를 찾아 JVM에 올리게 된다.

2. Product.class가 loaded된 후에(=Product.class에 대한 Class 오브젝트가 생성된 후), Product의 모든 static initialization(class varialbe, static initializer)이 수행 된다.(JVM이 기동된 후 단 한번만 실행됨)

3. new Product()를 수행할 때, JVM의 heap 영역에 Product 오브젝트를 위한 메모리를 할당한다.

4. 이 오브젝트의 메모리 영역은 primitive type은 0, reference type은 null로 초기화 세팅 된다.

5. 멤버 field의 선언문에 초기화를 같이 하고 있다면 이 초기화가 수행된다. (globalProduct)

6. 그 후에 생성자가 호출된다.




### JVM Start Up

위의 Product()를 호출하는 main 메소드를 수행하기 위해 JVM을 기동

***java -classpath target/classes org.example.Main

우선 JVM은 bootstrap class loader라는 최상위 클래스 로더가 먼저 맨 처음에 지정한 클래스(임의의 Init 클래스)를 로딩한다.
(여기서는 Main())

그 후에 JVM은 이 Main.class를 link/initialize하고, 메소드 access specifier가 public, return type void, main(String)인 메소드를 찾아 invoke하면서 JVM이 기동한다. (load/link/initialize의 3가지를 거친다.)


***여기서 public static void main() method를 가지는 initial class는 특정한 기능을 수행하는 class가 아닌, JVM 기동을 위한 entry point 역할이라고 보면 된다. 이 main을 실행하면서 코드의 흐름이 타고 타면서 프로그램이 진행 된다.

예시로 톰캣(7버전)의 서블릿 컨테이너인 catalina engine을 실행시킬때는 Tomcat에서 별도로 JVM 기동을 위한 entry class Bootstrap을 만들어 놓았다

```
# tomcat/bin/catalina.sh의 일부
...
    eval exec "\"$_RUNJAVA\"" "\"$LOGGING_CONFIG\"" $LOGGING_MANAGER $JAVA_OPTS $CATALINA_OPTS \
      -D$ENDORSED_PROP="\"$JAVA_ENDORSED_DIRS\"" \
      -classpath "\"$CLASSPATH\"" \
      -Djava.security.manager \
      -Djava.security.policy=="\"$CATALINA_BASE/conf/catalina.policy\"" \
      -Dcatalina.base="\"$CATALINA_BASE\"" \
      -Dcatalina.home="\"$CATALINA_HOME\"" \
      -Djava.io.tmpdir="\"$CATALINA_TMPDIR\"" \
      org.apache.catalina.startup.Bootstrap "$@" start
...
```

```
// tomcat의 Bootstrap 클래스의 main 메소드
// https://github.com/apache/tomcat70/blob/trunk/java/org/apache/catalina/startup/Bootstrap.java
/**
     * Main method and entry point when starting Tomcat via the provided
     * scripts.
     *
     * @param args Command line arguments to be processed
     */
    public static void main(String args[]) {

        if (daemon == null) {
            // Don't set daemon until init() has completed
            Bootstrap bootstrap = new Bootstrap();
            try {
                bootstrap.init();
            } catch (Throwable t) {
                handleThrowable(t);
                t.printStackTrace();
                return;
            }
            daemon = bootstrap;
        } else {
            // When running as a service the call to stop will be on a new
            // thread so make sure the correct class loader is used to prevent
            // a range of class not found exceptions.
            Thread.currentThread().setContextClassLoader(daemon.catalinaLoader);
        }

        try {
            String command = "start";
            if (args.length > 0) {
                command = args[args.length - 1];
            }

            if (command.equals("startd")) {
                args[args.length - 1] = "start";
                daemon.load(args);
                daemon.start();
            } else if (command.equals("stopd")) {
                args[args.length - 1] = "stop";
                daemon.stop();
            } else if (command.equals("start")) {
                daemon.setAwait(true);
                daemon.load(args);
                daemon.start();
                if (null == daemon.getServer()) {
                    System.exit(1);
                }
            } else if (command.equals("stop")) {
                daemon.stopServer(args);
            } else if (command.equals("configtest")) {
                daemon.load(args);
                if (null == daemon.getServer()) {
                    System.exit(1);
                }
                System.exit(0);
            } else {
                log.warn("Bootstrap: command \"" + command + "\" does not exist.");
            }
        } catch (Throwable t) {
            // Unwrap the Exception for clearer error reporting
            if (t instanceof InvocationTargetException &&
                    t.getCause() != null) {
                t = t.getCause();
            }
            handleThrowable(t);
            t.printStackTrace();
            System.exit(1);
        }

    }
```

![RunTime Data Area](/99CDA2445C10EEEE29.jpeg)


### RunTime Data Area in JVM

- RunTime Data Area는 Process로서의 JVM이 프로그램을 잘 수행하기 위해 OS로부터 할당받은 메모리 영역이다.
  - JVM이 기동되면서 initial Class의 메인 메소드가 실행되고 그에 따라 애플리케이션이 연계적으로 수행될 때 이 실행을 위한,
    Runtime에서 일어나는 모든 정보를 저장하는 곳이다. 특정 메소드를 수행하려면 그 메소드가 속한 클래스에 대한 metadata(클래스 및 필드와 메서드에 대한 정보, method code 등)도 필요하고, 이 metadata를 활용해서 class에 대한 object를 만들면
    그 오브젝트를 가리키는 reference 변수들도 저장이 되어야 하기 때문



### 데이터 생성 소멸 영역에 따라 구분한 Runtime Data Area

    1. PC(program counter) register (per JVM Thread)
    thread에서 지금 실행중인 메서드(즉 JVM Stack의 top에 있는 stack frame)내에서 현재 실행중인 instruction(= bytecode)의 address를 포함함.(method가 native가 아닌 경우.)

    멀티스레드 환경에서 특정 JVM Thread가 RUNNABLE 상태에서 밀려났을 때, 다시 RUNNABLE 상태가 되었을 때 이전까지 수행하던 작업을 기억해야함.

    2. JVM Stack (per JVM Thread)
        stack frame을 저장하는 jvm thread의 스택.

        - Stack Frame

            - stack frame은 method 실행시마다 생김. 실행중인 메서드의 상태를 저장하는 단위이다.
            - JVM stack의 top에 위치하는 frame이 현재 실행중인 메서드의 frame.
            - stack frame을 구성하는 영역

                1. Local Variable(이하 lv라고 칭하겠음.):

                    - 메소드의 파라미터 및 지역변수가 저장되는 영역.(method invocation시에 파라미터들이 lv에 먼저 세팅되고, 지역변수는 그 뒤의 index에 저장된다.)
                        - instance method의 invocation의 경우, 해당 instance의 reference(this)가 lv의 0번째에 저장되고, 그뒤에 paramter들이 뒤를 따름.
                        - class(static) method의 invocation의 경우, invocation시의 parameter들(오브젝트의 경우 reference가)이 lv의 0번째 위치부터 저장됨.
                            - method를 invoke하는 instruction들 중에서 static method를 invoke하는 invoke static instruction는 다른 instruction들(invokevirtual/invokespecial/invokeinterface)와는 달리 호출당시 operand stack에 object의 reference를 필요로 하지 않음

                2. Operand Stack: JVM이 해당 메서드내에서 연산을 할 때 쓰는 스택 영역

                    - Execution engine이 instruction을 수행할 때 필요한 데이터를 operand Stack에 push와 pop을 지속해서 연산한다.
                    - Primitive type과 Reference type의 값만 들어갈 수 있다.
                    - 메소드 호출, 산술 연산, 비교 연산 등은 모두 operand stack에서 처리된다.
                    - 해당 값을 한번에 불러와서 stack에 저장해놓고 덧셈 연산을 수행할때 상수시간으로 데이터를 처리할 수 있는 장점이 있다. 캐시와 비슷한 역할을 하며 빠른 메모리 접근을 통해 성능 향상을 도모한다.
                    - JVM은 operand stack의 크기를 미리 정할 수 있어서 메모리 효율적이다.

                3. Method가 속한 클래스의 run-time constant pool에 대한 reference 포인터

                    메서드가 실행 될때 메서드의 상수값을 참조하는데 사용되고 메서드에서 상수값을 사용하는 경우, 해당 상수값이 클래스 파일 run time constant pool에 저장되어 있기 때문에, 메서드 실행 중에 해당 상수값을 참조하기 위해서는 해당 pool을 참조해야한다.

    3. Native Method Stack (per JVM Thread)
    JVM에서 Java 이외의(C와 같은) 언어로 작성된 method를 수행할 때 필요한 stack (JNI, Native Heap, etc...)


    4. Heap (shared b/t Threads, JVM 종료 시 종료)
    class의 instance와 array를 위한 메모리가 할당되는 영역
    object reference의 scope이 method던, instance던, class던 간에 상관없이 new 혹은 newarray와 같은 instruction에 의해 수행되면 heap(java heap)에 저장됨.

    5. Method Area (shared b/t Threads)
    각 클래스별 데이터들(run-time constant pool, class fields/methods, method code, 그외 class metadata가 저장되는 곳.

    6. Runtime constant pool(각 클래스마다 별도의 constant pool이 존재)
    - 이 구조는 클래스의 이름, 상위 클래스의 이름, 인터페이스의 이름, 필드와 메서드의 이름, 타입, 그리고
    값과 같은 상수 데이터를 저장하는 pool 또한 실행중에 동적으로 로딩되는 클래스나 메소드를 참조하는데에도 사용된다
    ```


### Object Creation

```
javap -v -p -s target.classes.example.Main
```

```
Constant pool:

#1 = Methodref #5.#21 // java/lang/Object."<init>":()V
#2 = Class #22 // org/eminentstar/model/simple/Product
#3 = Methodref #2.#21 // org/eminentstar/model/simple/Product."<init>":()V
#4 = Class #23 // org/eminentstar/Main
#5 = Class #24 // java/lang/Object
#6 = Utf8 <init>
#7 = Utf8 ()V
#8 = Utf8 Code
#9 = Utf8 LineNumberTable
#10 = Utf8 LocalVariableTable
#11 = Utf8 this
#12 = Utf8 Lorg/eminentstar/Main;
#13 = Utf8 main
#14 = Utf8 ([Ljava/lang/String;)V
#15 = Utf8 args
#16 = Utf8 [Ljava/lang/String;
#17 = Utf8 product
#18 = Utf8 Lorg/eminentstar/model/simple/Product;
#19 = Utf8 SourceFile
#20 = Utf8 Main.java
#21 = NameAndType #6:#7 // "<init>":()V
#22 = Utf8 org/eminentstar/model/simple/Product
#23 = Utf8 org/eminentstar/Main
#24 = Utf8 java/lang/Object
{
public org.eminentstar.Main();
descriptor: ()V
flags: ACC_PUBLIC
Code:
stack=1, locals=1, args_size=1
0: aload_0
1: invokespecial #1 // Method java/lang/Object."<init>":()V
4: return
LineNumberTable:
line 5: 0
LocalVariableTable:
Start Length Slot Name Signature
0 5 0 this Lorg/eminentstar/Main;

public static void main(java.lang.String[]);
descriptor: ([Ljava/lang/String;)V
flags: ACC_PUBLIC, ACC_STATIC
Code:
stack=2, locals=2, args_size=1
0: new #2 // class org/eminentstar/model/simple/Product
3: dup
4: invokespecial #3 // Method org/eminentstar/model/simple/Product."<init>":()V
7: astore_1
8: return
LineNumberTable:
line 8: 0
line 9: 8
LocalVariableTable:
Start Length Slot Name Signature
0 9 0 args [Ljava/lang/String;
8 1 1 product Lorg/eminentstar/model/simple/Product;
}
SourceFile: "Main.java"

```

    java 코드로 1줄로 표현된 아래 코드는 Product object에 대한 reference 변수 p에 new 키워드 및 생성자를 호출해서 생성된 Product object를 참조하는 참조값을 p에 할당한다.

    Product p = new Product();

    ```
    instruction은 아래와 같이 변환된다.
    0: new           #2                  // class org/eminentstar/model/simple/Product
    3: dup
    4: invokespecial #3                  // Method org/eminentstar/model/simple/Product."<init>":()V
    7: astore_1
    ```

### new instruction

    - new는 Object를 생성하는 instruction

    - 3byte로 구성되고, 첫번째 1byte는 new에 대한 opcode, 나머지 2byte는 오브젝트를 생성할 클래스에 대한 Main클래스내의
    Constant pool entry의 Index를 구성한다.

    - Main Runtime Constant Pool내에서 Product 클래스에 대한 entry가 resolved된 상태라면 entry에 참조한 Product 클래스 정보를 통해 Product 오브젝트를 위한 메모리 영역을 heap(java heap)에 할당한다. 이때는 오브젝트가 초기화 되지 않은 상태이다.
    (해당 클래스에 대한 첫번째 접근이라면 단순히 symbolic reference로서의 클래스의 이름을 가지는 utf8 entry의 index를 가리킬 것이고, 이 symbolic reference로부터 Product의 Class오브젝트의 reference를 얻는 resolution 과정을 거쳐야함.)

    ```
    symbolic 상태의 constant pool entries
    #2 = Class              #22            // org/eminentstar/model/simple/Product
    #22 = Utf8               org/eminentstar/model/simple/Product
    ```

    ![Resolution 후](/99CDA2445C10EEEE29.jpeg)

  
  
  
### dup instruction

        - dup은 operand stack의 top을 duplicate해서 operand stack에 push하는 instruction
        Java에서 dup(duplicate) 명령어는 operand stack에서 값을 복사하여 새로운 값으로 스택에 추가한다. 따라서 dup 명령어를 사용하여 reference를 복제할 경우, reference가 가리키는 객체의 주소가 새로운 reference로 복제되며, 이를 활용하여 여러 개의 reference가 동일한 객체를 가리킬 수 있다.

        예를 들어, 메서드 내에서 객체를 생성하고, 이를 여러 개의 참조 변수에 할당하는 경우가 있을 수 있습니다. 이때, dup 명령어를 사용하여 참조 변수에 동일한 객체를 할당할 수 있습니다. 이렇게 하면, 객체의 생성 비용을 줄이고 메모리 사용량을 절약할 수 있습니다.

        또한, 객체를 복사하는 경우가 아니라 객체의 reference를 복사하는 경우에도 dup 명령어를 사용할 수 있다. 이 경우에는 reference를 복사하기 때문에, 참조 변수가 가리키는 객체는 동일한 객체이며, 객체 자체가 복사되는 것은 아니다.

        따라서, dup 명령어를 사용하여 reference를 복제하는 이유는, 객체의 생성 비용을 줄이고 메모리 사용량을 절약하기 위해서다. 또한, 여러 개의 참조 변수가 동일한 객체를 가리킬 수 있도록 하여, 객체의 다양한 활용이 가능해지도록 한다.


  ### invokespecial instruction
    
  invokespecial은 instance method를 inovke하는 instruction이긴 한데, <init>(생성자)나 superclass/private 메소드를 호출할 때 사용한다.
    <init>(instance intialization method)
    JVM 레벨에서의 생성자는 <init>이란 이름을 가짐.
    - Product -> Object까지 intitialization 된다.
    init 수행 후 드디어 초기화가 된다.


      
### astore instruction

마지막으로 astore instruction을 통해서 operand stack의 top(objectref)를 pop해서 local variable에 저장한다.

Class Loader의 클래스 배치 과정

1.  loading : 클래스패스상에서 binary 형태의 .class 파일을 찾아 JVM에 올리고, 이 .class 파일을 이용해서 Class를 생성하는 과정
    load하고자하는 클래스의 superclass가 없다면 이 superclass부터 먼저 load한다.

2.  linking : (책 내용 인용) loading된 생성된 Class 타입을 Runtime 상태의 Binrary Type Data로 구성하는 과정
    linking은 verification, preparation, resolution 단계를 거친다.(JVM 구현체에 따라 resolution은 optional할 수도 있음.)
    2-1. verification : .class 파일의 구조가 제대로 됬는지 검증하는 단계.
    이미 Java Compiler가 class파일을 생성할 때 제대로 생성하겠지만서도, JVM입장에서는 어떤 class파일이 들어올지를 모르기 때문에 verification단계를 거침.

        2-2. preparation : 클래스의 static fields를 위한 메모리를 할당하는 단계

        2-3. resolution : runtime constant pool의 entry들(클래스/메소드/필드에 대한) symbolic reference를 실제 메모리상의 address로 변환하는 과정

3.  initialization : <clinit>(class intialization method)를 수행하는 과정
    클래스의 모든 static initializers 및 static fields의 초기화를 수행한다.
    <clinit> 호출은 superclass, superinterfaces의 initialization을 진행한 후에 일어난다.

    클래스 initialization은 동시에 여러 스레드에서 시도를 할 수 있기 때문에 어떤 클래스에 대해 initialization 진행 시 lock을 잡고 진행함.
    

### 클래스의 Initialization이 일어나는 시점:
  
   - 다음의 JVM instruction을 수행할 때(new, getstatic, putstatic, invokestatic)
   - 위 instruction들은 직간접적으로 해당 class를 참조함. 
   - 클래스의 instance를 생성한다던가 
   - static method를 호출한다거나 
   - static field를 참조한다거나 
   - java.lang.reflect 패키지에서 해당 클래스에 대한 접근 시도를 할 때 (예를 들면 Class.forName("org.eminentstar.model.simple.Product")와 같이)
   - subclass의 initialization시
   - default method를 가지는 인터페이스인 경우, 이 인터페이스를 구현한(같은 hierarchy안에 있는) 클래스의 initialization시에 인터페이스가 initialization이 일어남.
   - JVM 기동시의 initial class인 경우

