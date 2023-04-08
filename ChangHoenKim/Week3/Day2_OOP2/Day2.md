# 객체 지향 프로그래밍
## 변수와 메소드

```
class Variable{
    int iv;  // 인스턴스 변수
    static int cv; // 클래스 변수 (static 변수, 공유 변수)

    void method(){
        int lv = 0; // 지역 변수
    }
}
```

#### 클래스 변수 : 클래스 영역에 클래스가 메모리에 올라갈 때 생성됩니다.
- 같은 클래스의 모든 인스턴스들이 공유하는 변수
- 클래스가 로딩될 때 생성되고 프로그램이 종료될 때 소멸
- 한 번 변경시 모든 객체의 클래스 변수가 변경

#### 인스턴스 변수 : 클래스 영역에 인스턴스 생성 시 생성됩니다.
- 인스턴스를 생성할 때 생성되고, 참조변수가 없을 때 가비지컬렉터에 의해자동제거됨
- 각 인스턴스의 개별적인 저장공간이고 인스턴스마다 다른 값 저장가능

#### 지역 변수 : 메소드 영역에 변수 선언문 수행 시 생성됩니다.
- 메서드 내에 선언되며, 메서드의 종료와 함께 소멸
- 조건문, 반복문의 블럭{} 내에 선언된 지역변수는 블럭을 벗어나면 소멸
- 지역변수는 사용전에 꼭 초기화를 해주고 r-value로 사용해야함

#### 멤버 변수 : 클래스 내부의 변수입니다.
- 명시적 초기화 : 타입 변수 = 값;
- 생성자 : 클래스명(타입 변수){ 초기화 내용 }
- 초기화 블럭 : {}, static{}
 
 #### static 초기화 블럭
메인 메소드에서 객체의 다른 변수나 메소드보다 먼저 실행됩니다. 메인 메소드가 실행되기 전에 특정 값으로 변수를 초기화할 때 사용할 수 있습니다.

#### 인스턴스 초기화 블럭
인스턴스 초기화 블럭은 객체 생성되고 실행될때마다 실행되기에 항상 어떤 값을 추가하거나 설정할때 사용할 수 있습니다.

변수가 클래스영역에 선언되지 않았다면, 모두 지역변수라고 할 수 있습니다.
즉, 클래스변수와 인스턴스변수가 아니라면 모두 지역변수입니다. 그리고 지역변수에는 static을 붙일 수 없습니다.

클래스변수는 클래스가 메모리에 올라갈때 자동적으로 생성됩니다.
그렇기에 원하는 때면 언제든지 바로 사용가능합니다. 인스턴스를 생성하지 않고도 사용할 수 있습니다.

반면에 인스턴스변수는 인스턴스를 생성해야 만들어지므로 사용하기 전에 반드시 인스턴스를 생성해야합니다.

클래스 변수가 스코프가 가장 넓습니다. 클래스가 메모리에 올라갈 때부터 끝날 때까지 존재하며 이후 인스턴스 변수와 지역 변수가 있습니다.

## 상속

상속이란 기존의 클래스를 재사용해서 새로운 클래스를 작성하는 것으로 두 클래스를 부모과 자손으로 관계를 맺어주는 것이라고 할 수 있습니다.

자손은 부모의 모든 멤버를 상속받으며(생성자, 초기화블럭 제외) 자손의 멤버개수는 부모보다 적을 수 없습니다.(같거나 많다.)


자바는 기본으로 단일 상속을 지원합니다.

샐로운 클래스 생성시 부모 클래스를 1개 지정해야하나 생략하면 java.lang.object 클래스를 상속하게 되며 java.lang.object 클래스는 자바로 만들어지는 모든 클래스들의 최상위 클래스입니다.

어떤 클래스든 객체를 생성하게 되면 부모 클래스의 객체가 함께 생성됩니다.

굳이 상속할 필요가 없다면 할 필요가 없습니다.

객체 생성시 호출되는 **생성자 메소드는 호출되자마자 부모 클래스의 생성자를 호출하는 특징**을 가지고 있으며 호출되는 부모 클래스의 생성자는 **아규먼트 없는 생성자**입니다.
```
package day7;

class A {
	A() {
		System.out.println("A클래스의 객체 생성!");
	}
}

class B extends A {
	B() {
		System.out.println("B클래스의 객체 생성!");
	}
}

class C extends B {
	C() {
		System.out.println("C클래스의 객체 생성!");
	}
}

public class ABCTest {
	public static void main(String[] args) {
		new C();
	}
}

결과

A클래스의 객체 생성!
B클래스의 객체 생성!
C클래스의 객체 생성!

```

부모클래스에 아규먼트를 받지 않는 생성자가 없는 경우에는 자바 클래스에서 super() 메소드를 이용하여 부모가 가지고 있는 생성자를 직접 호출해주는 것이 필수입니다.

```
package day7;

class A {
	A() {
		System.out.println("A클래스의 객체 생성!");
	}
}

class B extends A {
	B(int num) {
		System.out.println("B클래스의 객체 생성!");
	}

}

class C extends B {
	C() {
		super(10);
		System.out.println("C클래스의 객체 생성!");
	}
}

public class ABCTest {
	public static void main(String[] args) {
		new C();
	}
}

```
컴파일될때 해당 호출 문장은 자동으로 생성되나 두 가지 경우 제외됩니다.
1. 이미 super가 호출된 경우
2. this 호출 문장이 부모 클래스가 들어가 있는 경우

부모의 메소드를 오버라이딩 했는데 부모의 것을 사용하고 싶을 때는 super.메소드를 사용하면 됩니다.

@Override는 어노테이션으로 오버라이딩함을 나타내며 가독성과 해당 메소드가 어떤 것을 나타내는지 알려줄 수 있습니다. 또한 어노테이션 아래의 메소드가 제대로된 오버라이딩이 일어나지 않은 경우 에러로 안내해줍니다.


- 부모 클래스에 대한 변경은 이미 다른 곳에 생성된 자식 클래스에게 영향을 줄 수 있기에 자식 클래스를 변경하는 것이 적절합니다.
______________________________________________________________________

## 다양한 Garbage Collection(가비지 컬렉션) 알고리즘
[블로그: 망나니 개발자](https://mangkyu.tistory.com/119)

JVM이 메모리를 자동으로 관리해주는 것은 개발자의 입장에서 상당한 메리트이다. 하지만 문제는 GC를 수행하기 위해 Stop The World에 의해 애플리케이션이 중지되는 것에 있다. Heap의 사이즈가 커지면서 애플리케이션의 지연(Suspend) 현상이 두드러지게 되었고, 이를 막기 위해 다양한 Garbage Collection(가비지 컬렉션) 알고리즘을 지원하고 있다. 

 
### [ Serial GC ]
Serial GC의 Young 영역은 앞서 설명한 알고리즘(Mark Sweep)대로 수행된다. 하지만 Old 영역에서는 Mark Sweep Compact 알고리즘이 사용되는데, 기존의 Mark Sweep에 Compact라는 작업이 추가되었다. Compact는 Heap 영역을 정리하기 위한 단계로 유요한 객체들이 연속되게 쌓이도록 힙의 가장 앞 부분부터 채워서 객체가 존재하는 부분과 객체가 존재하지 않는 부분으로 나누는 것이다.
```
java -XX:+UseSerialGC -jar Application.java
```
Serial GC는 서버의 CPU 코어가 1개일 때 사용하기 위해 개발되었으며, 모든 가비지 컬렉션 일을 처리하기 위해 1개의 쓰레드만을 이용한다. 그렇기 때문에 CPU의 코어가 여러 개인 운영 서버에서 Serial GC를 사용하는 것은 반드시 피해야 한다.

### [ Parallel GC ]
Parallel GC는 Throughput GC로도 알려져 있으며, 기본적인 처리 과정은 Serial GC와 동일하다. 하지만 Parallel GC는 여러 개의 쓰레드를 통해 Parallel하게 GC를 수행함으로써 GC의 오버헤드를 상당히 줄여준다. Parallel GC는 멀티 프로세서 또는 멀티 쓰레드 머신에서 중간 규모부터 대규모의 데이터를 처리하는 애플리케이션을 위해 고안되었으며, 옵션을 통해 애플리케이션의 최대 지연 시간 또는 GC를 수행할 쓰레드의 갯수 등을 설정해줄 수 있다.
```
java -XX:+UseParallelGC -jar Application.java

// 사용할 쓰레드의 갯수
-XX:ParallelGCThreads=<N>

// 최대 지연 시간
-XX:MaxGCPauseMillis=<N>
```
Parallel GC가 GC의 오버헤드를 상당히 줄여주었고, Java8까지 기본 가비지 컬렉터(Default Garbage Collector)로 사용되었다. 그럼에도 불구하고 Application이 멈추는 것은 피할 수 없었고, 이러한 부분을 개선하기 위해 다른 알고리즘이 더 등장하게 되었다.

### [ Parallel Old GC ]
Parallel Old GC는 JDK5 update6부터 제공한 GC이며, 앞서 설명한 Parallel GC와 Old 영역의 GC 알고리즘만 다르다. Parallel Old GC에서는 Mark Sweep Compact가 아닌 Mark Summary Compaction이 사용되는데, Summary 단계에서는 앞서 GC를 수행한 영역에 대해서 별도로 살아있는 객체를 색별한다는 점에서 다르며 조금 더 복잡하다.


### [ CMS(Concurrent Mark Sweep) GC ]
CMS(Concurrent Mark Sweep) GC는 Parallel GC와 마찬가지로 여러 개의 쓰레드를 이용한다. 하지만 기존의 Serial GC나 Parallel GC와는 다르게 Mark Sweep 알고리즘을 Concurrent하게 수행하게 된다.

이러한 CMS GC는 애플리케이션의 지연 시간을 최소화 하기 위해 고안되었으며, 애플리케이션이 구동중일 때 프로세서의 자원을 공유하여 이용가능해야 한다. CMS GC가 수행될 때에는 자원이 GC를 위해서도 사용되므로 응답이 느려질 순 있지만 응답이 멈추지는 않게 된다.

하지만 이러한 CMS GC는 다른 GC 방식보다 메모리와 CPU를 더 많이 필요로 하며, Compaction 단계를 수행하지 않는다는 단점이 있다. 이 때문에 시스템이 장기적으로 운영되다가 조각난 메모리들이 많아 Compaction 단계가 수행되면 오히려 Stop The World 시간이 길어지는 문제가 발생할 수 있다.
```
// deprecated in java9 and finally dropped in java14
java -XX:+UseConcMarkSweepGC -jar Application.java

```
만약 GC가 수행되면서 98% 이상의 시간이 CMS GC에 소요되고, 2% 이하의 시간이 Heap의 정리에 사영된다면 CMS GC에 의해 OutOfMemoryError가 던져질 것이다. 물론 이를 disable 하는 옵션이 있지만, CMS GC는 Java9 버젼부터 deprecated 되었고 결국 Java14에서는 사용이 중지되었기 때문에 굳이 알아볼 필요는 없을 것 같다.

### [ G1(Garbage First) GC ]
G1(Garbage First) GC는 장기적으로 많은 문제를 일으킬 수 있는 CMS GC를 대체하기 위해 개발되었고, Java7부터 지원되기 시작하였다.

기존의 GC 알고리즘에서는 Heap 영역을 물리적으로 Young 영역(Eden 영역과 2개의 Survivor 영역)과 Old 영역으로 나누어 사용하였다. G1 GC는 Eden 영역에 할당하고, Survivor로 카피하는 등의 과정을 사용하지만 물리적으로 메모리 공간을 나누지 않는다. 대신 Region(지역)이라는 개념을 새로 도입하여 Heap을 균등하게 여러 개의 지역으로 나누고, 각 지역을 역할과 함께 논리적으로 구분하여(Eden 지역인지, Survivor 지역인지, Old 지역인지) 객체를 할당한다.

G1 GC에서는 Eden, Survivor, Old 역할에 더해 Humongous와 Availabe/Unused라는 2가지 역할을 추가하였다. Humonguous는 Region 크기의 50%를 초과하는 객체를 저장하는 Region을 의미하며, Availabe/Unused는 사용되지 않은 Region을 의미한다. 

G1 GC의 핵심은 Heap을 동일한 크기의 Region으로 나누고, 가비지가 많은 Region에 대해 우선적으로 GC를 수행하는 것이다. 그리고 G1 GC도 다른 가비지 컬렉션과 마찬가지로 2가지 GC(Minor GC, Major GC)로 나누어 수행되는데, 각각에 대해 살펴보도록 하자.

1. Minor GC

한 지역에 객체를 할당하다가 해당 지역이 꽉 차면 다른 지역에 객체를 할당하고, Minor GC가 실행된다. G1 GC는 각 지역을 추적하고 있기 때문에, 가비지가 가장 많은(Garbage First) 지역을 찾아서 Mark and Sweep를 수행한다.

Eden 지역에서 GC가 수행되면 살아남은 객체를 식별(Mark)하고, 메모리를 회수(Sweep)한다. 그리고 살아남은 객체를 다른 지역으로 이동시키게 된다. 복제되는 지역이 Available/Unused 지역이면 해당 지역은 이제 Survivor 영역이 되고, Eden 영역은 Available/Unused 지역이 된다.

2. Major GC(Full GC)

시스템이 계속 운영되다가 객체가 너무 많아 빠르게 메모리를 회수 할 수 없을 때 Major GC(Full GC)가 실행된다. 그리고 여기서 G1 GC와 다른 GC의 차이점이 두각을 보인다.

기존의 다른 GC 알고리즘은 모든 Heap의 영역에서 GC가 수행되었으며, 그에 따라 처리 시간이 상당히 오래 걸렸다. 하지만 G1 GC는 어느 영역에 가비지가 많은지를 알고 있기 때문에 GC를 수행할 지역을 조합하여 해당 지역에 대해서만 GC를 수행한다. 그리고 이러한 작업은 Concurrent하게 수행되기 때문에 애플리케이션의 지연도 최소화할 수 있는 것이다.

(G1 GC의 내용을 세부적으로 파고 들면 설명해야 할 것들이 많지만, 해당 포스팅에서는 다양한 GC 알고리즘에 대해 알아보는 것이 핵심이므로 세부적인 설명은 다른 포스팅을 통해 진행하고자 한다.)

물론 G1 GC는 다른 GC 방식에 비해 잦게 호출될 것이다. 하지만 작은 규모의 메모리 정리 작업이고 Concurrent하게 수행되기 때문이 지연이 크지 않으며, 가비지가 많은 지역에 대해 정리를 하므로 훨씬 효율적이다.
```
java -XX:+UseG1GC -jar Application.java
 
```

이러한 구조의 G1 GC는 당연히 앞의 어떠한 GC 방식보다 처리 속도가 빠르며 큰 메모리 공간에서 멀티 프로레스 기반으로 운영되는 애플리케이션을 위해 고안되었다. 또한 G1 GC는 다른 GC 방식의 처리속도를 능가하기 때문에 **Java9부터 기본 가비지 컬렉터(Default Garbage Collector)**로 사용되게 되었다.

## 자바의 메모리 영역

[참고해야할 블로그: 인파_](https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EB%B3%B4%EB%8A%94-%EC%9E%90%EB%B0%94-%EC%BD%94%EB%93%9C%EC%9D%98-%EB%A9%94%EB%AA%A8%EB%A6%AC-%EC%98%81%EC%97%AD%EC%8A%A4%ED%83%9D-%ED%9E%99)

#### 1) Method Area

JVM이 실행되면서 생기는 공간입니다. Class 정보, 전역변수 정보, Static 변수 정보가 저장되며 Runtime Constant Pool 에는 말 그대로 '상수' 정보가 저장됩니다. 모든 스레드에서 정보가 공유됩니다.

#### 2) Heap

new 연산자로 생성된 객체, Array와 같은 동적으로 생성된 데이터가 저장되는 공간으로 Heap에 저장된 데이터는 Garbage Collector 가 처리하지 않는한 소멸되지 않습니다.

Reference Type의 데이터가 저장되며 모든 스레드에서 정보가 공유됩니다.

#### 3) Stack

지역변수, 메소드의 매개변수와 같이 잠시 사용되고 필요가 없어지는 데이터가 저장되는 공간입니다. Last In First Out, 나중에 들어온 데이터가 먼저 나갑니다. 만약, 지역변수 이지만 Reference Type일 경우에는 Heap에 저장된 데이터의 주소값을 Stack 에 저장해서 사용하게 되며 stack은 스레드마다 하나씩 존재합니다.

4) PC Register

스레드가 생성되면서 생기는 공간
스레드가 어느 명령어를 처리하고 있는지 그 주소를 등록한다.
JVM이 실행하고 있는 현재 위치를 저장하는 역할

5) Native Method Stack

Java 가 아닌 다른 언어 (C, C++) 로 구성된 메소드를 실행이 필요할 때 사용되는 공간

- static이 붙은 변수나 메소드는 바로 호출 가능한 상태로 메소드 영역에 들어갑니다. 그렇기에 static main이 최초 시작 class의 메소드라는 것을 의미합니다. 

- Thread.sleep()은 static 함수 중 하나입니다.

- vmargument 부분에 원하는 옵션을 주면 해당 옵션을 실행하며 작동합니다.
