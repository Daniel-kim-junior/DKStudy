# 객체 지향 프로그래밍

## 포함관계(composite)
포함(composite)이란 한 클래스의 멤버변수로 다른 클래스를 선언하는 것으로 작은 단위의 클래스를 먼저 만들고, 이 들을 조합해서 하나의 커다란 클래스를 만듭니다.

```
class Point{
    int x;
    int y;
}

class Circle{
    Point c = new Point();
    int r;
}
```
위의 경우 Circle은 Point를 포함한다고 얘기합니다.

## 클래스간의 관계결정하기 – 상속 vs. 포함

클래스간의 관계를 상속으로 할 것인지 포함으로 할 것인지 결정하는 가장 간단한 방법은 **‘is-a’**와 **‘has-a’**를 가지고 문장을 만들어보는 것입니다.

앞서 나온 Circle클래스와 Point클래스를 가지고 문장을 만들어보면, is-a를 가지고 문장을 만들면 "Circle is a Point." 즉, 원은 점이다. has-a를 가지고 문장을 만들면 "Circle has a Point." 원은 점을 가지고 있다. 가 됩니다.

여기서 점은 원의 중심을 의미하는 원점을 뜻한다고 했을 때, 원을 구성하는 것은 원점과 반지름이니까 Circle has a Point 즉, "원은 원점을 가지고 있다."가 더 자연스러운 문장이라고 할 수 있습니다.

그렇기에 Circle클래스가 Point클래스를 상속받도록 하는 것 보다 Point클래스를 포함시키도록 하는 것이 더 적절합니다.

___________________________________________________________________________________________

실제 프로그래밍을 하다 보면 이처럼 문장을 만들어도 판단하기 어려운 경우가 많습니다. 대부분의 경우 포함관계이나, 기존의 클래스에 새로운 기능이 추가된 새로운 클래스를 만들 때는 상속관계를 맺어주면 됩니다.

상속이나 포함의 공통적인 목적은 코드를 재사용함으로써 서로 유기적으로 연결되도록 하는 것이고 그렇게 함으로써 한 곳의 변경이 다른 곳에 자동적으로 영향을 미치도록 하여 작업의 양을 줄여주고 오류의 가능성을 낮춰주는 것입니다.

상속관계는 포함관계보다 객체지향개념적으로 좀더 중요한 의미를 갖습니다. 포함관계는 간단히 얘기해서 재사용성을 높인다는 정도지만 상속관계는 앞으로 배우게 될 다형성과도 깊은 관계가 있고, 상속계층도에 포함되므로 조상의 변화에 따라 모든 자손들이 영향을 받기 때문에 상속관계를 잘못 맺어주면 원하지 않는 영향을 줄 수도, 받을 수도 있습니다.

그렇기에 상속관계를 맺어줄 때는 좀 더 신중하게 결정해야 합니다.

___________________________________________________________________________________________

## 단일 상속 (single inheritance)

자바는 단 하나의 조상으로부터만 상속받을 수 있으며, 이를 단일 상속이라고 합니다. C++에서는 여러 조상으로부터 상속받을 수 있으나 여러 클래스로부터 상속받을 수 있기에 더 쉽게 클래스를 정의할 수 있지만 상속 계층도가 복잡해지고 충동의 문제가 발생할 수 있습니다. 

이러한 문제들 때문에 자바는 단일 상속만을 허용하며 단일 상속의 한계를 해결하고자 **비중이 높은 클래스 하나만을 상속관계로, 나머지는 포함관계로 사용합니다.**

## Object 클래스 
조상이 없는 클래스는 자동적으로 Object클래스를 상속받게 되며, 상속계층도의 최상위에는 Object클래스가 위치합니다.

모든 클래스는 Object클래스에 정의된 11개의 메서드를 상속받습니다. ex) toString(), equals(Object obj), hashCode(), ...

## 오버라이딩(overriding)

“조상클래스로부터 상속받은 메서드의 내용을 상속받는 클래스에 맞게 변경하는 것을 오버라이딩이라고 한다.”

상속 받을 때, 상속받고 싶은 멤버만 임의로 선택할 수 없기 때문에 조상의 모든 멤버를 무조건 받을 수 밖에 없습니다. 그래서 일단 상속은 받고 상속받은 메소드와 똑같은 메소드를 내용만 다르게 해서 자손클래스에 정의합니다.

이것을 오버라이딩이라고 합니다. 이 때는 똑같은 메소드를 중복해서 정의했다는 에러가 발생하지 않습니다.


### 오버라이딩의 조건

1. 선언부가 같아야 한다.(이름, 매개변수, 리턴타입)

2. 접근제어자를 좁은 범위로 변경할 수 없다.
- 조상의 메서드가 protected라면, 범위가 같거나 넓은 protected나 public으로만 변경할 수 있다.

3. 조상클래스의 메서드보다 많은 수의 예외를 선언할 수 없다.

### 오버로딩 vs 오버라이딩

오버로딩 : 기존에 없는 새로운 메소드를 정의하는 것 (new)

오버라이딩 : 상속받은 메소드의 내용을 변경하는 것 (change, modify)

```
class Parent(){
    void parentMethod(){}
}

class Child extends Parent {
    void parentMethod(){} // 오버라이딩
    void parentMethod(int i){} // 오버로딩

    void childMethod() {}
    void childMethod(int i) {} // 오버로딩
}
```

### super

this – 인스턴스 자신을 가리키는 참조변수로 인스턴스의 주소가 저장되어 있습니다. 모든 인스턴스 메서드에 지역변수로 숨겨진 채로 존재합니다.

super – this와 같으며 조상의 멤버와 자신의 멤버를 구별하는 데 사용합니다.

자손클래스의 인스턴스를 생성하면, 자손의 멤버와 조상의 멤버가 합쳐진 하나의 인스턴스가 생성됩니다.

조상의 멤버들도 초기화되어야 하기 때문에 자손의 생성자의 첫 문장에서 조상의 생성자를 호출해야 합니다.

- this와 super가 이미 존재하는 경우는 사용하지 않아도 됩니다.

## 다형성(polymorphism)

“여러 가지 형태를 가질 수 있는 능력”이자 “하나의 참조변수로 여러 타입의 객체를 참조할 수 있는 것” 입니다.

#### 즉, 조상타입의 참조변수로 자손타입의 객체를 다룰 수 있는 것이 다형성입니다.

```
class Tv {
    boolean power;
    int channel;

    void power() { power = !power;}
    void channelUp() { code }
    void channelDown() { code }
}

class CaptionTv extends Tv{
    String text;
    void caption() { code };
}

Tv t = new Tv();
CaptionTv c = new CaptionTv();

// 조상타입의 참조변수로 자손타입의 객체를 다룰 수 있는 것. 
// 다만 조상 즉 자신의 멤버 변수에만 접근이 가능, 자손에서 추가된 변수는 참조 불가. 
// 참조를 위해서는 자식으로 형변환이 필요함.
Tv t = new CaptionTv();

```

```
Date d1 = new Date(); 

// Date의 모든 멤버 변수에 접근 가능
Object d2 = new Date();  -- o
// 사용은 가능하나 Object의 멤버 변수에만 접근이 가능, 자손에서 추가된 변수는 참조 불가
String d3 = new Date();  -- x

```

### instanceof

비교연산자로 객체가 어떤 것인지를 판별해줍니다.

```
static void printObjectInfo(Object o) {
    if(o instanceof String) {
                System.out.println("문자열 객체가 전달됨: " + o.toString().length());
            } else
                System.out.println("전달된 객체의 클래스명: " + o.getClass().getName());
}

//	어떠한 객체도 올 수 있기에 타입을 확인하는 것이 중요합니다. 
// 객체 타입은 자손에 대한 멤버변수에 접근은 불가하나 한 가지 방법으로 자식 객체로 형변환하는 것이 방법입니다.

//	.연산자가 가장 높은 우선순위를 가집니다.
System.out.println("문자열 객체가 전달됨: " + o.toString() + "-" + ((String)o).length());
            
```

### 형변환

자손타입 -> 조상타입 (Up-casting)   : 형변환 생략가능
조상타입 -> 자손타입 (Down-casting) : 형변환 생략불가

- 조상은 다양한 자손이 존재할 수 있기에 꼭 변환할 자손의 타입을 명시하는 형변환이 필요합니다.

서로 상속관계에 있는 타입간의 형변환만 가능하며 자손 타입에서 조상타입으로 형변환하는 경우, 형변환 생략이 가능합니다. 다만 같은 조상을 가진 자손끼리는 형변환도 다형성도 허용되지 않습니다. 오로지 부모 자식간의 관계에서만 가능합니다.

```
Person p1 = new Dancer();
Dancer d1 = (Dancer)p1;

Dancer d1 = new Dancer();
Person p1 = d1;
```
______________________________________________________________________________________________

## 다형성의 사용 예

```
class Product {
    int price;
    int bonusPoint;
}

class Tv extends Product {}
class Computer extends Product {}
class Audio extends Product {}

class Buyer {
    int money = 1000;
    int bonusPoint = 0;
}

```

판매 관리 시스템을 작성한다고 가정하고 현재 판매하는 물품이 3가지로 가정했을때, product를 부모로 3가지 자식 클래스를 생성합니다. 이는 판매 객체 클래스이며 구매자 클래스 또한 Buyer로 정의합니다. 이때 Buyer 클래스에서 구매한다는 메소드를 제작한다는 가정 하에 작성해보겠습니다.

```
void buy(Tv t) {
    money -= t.price;
    bonusPoint += t.bonusPoint;
}

void buy(Computer ct) {
    money -= c.price;
    bonusPoint += c.bonusPoint;
}

void buy(Audio a) {
    money -= a.price;
    bonusPoint += a.bonusPoint;
}

Buyer b = new Buyer();

Tv tv = new Tv();
computer com = new Computer();

b.buy(tv);
b.buy(com);

```

이는 메소드에 특정 객체를 구매할 때만 호출이 가능한 메소드들입니다. 자바는 메소드 오버로딩이 가능하기에 티비, 오디오와 컴퓨터를 매개변수로 총 3개의 buy 메소드를 작성하면, Buyer는 서로 다른 종류의 기기 구입에 자유로워집니다.

그런데 만약 판매 물품이 30개 혹은 300개로 늘어나면 어떻게 될까요? 메소드 오버로딩으로 buy 함수가 판매 물품에 맞게 증가하게 됩니다. 

이를 해결하기 위해 우리는 **다형성**을 사용하는 것입니다.

```
void buy(Product p) {
    money -= p.price;
    bonusPoint += p.bonusPoint;
}

Product p1 = new Tv();
Product p2 =  new Computer();

buy(p1);
buy(p2);

```

이렇게 파라미터를 부모 클래스인 Product로 넣어주게 된다면 해당 클래스 하나로 모든 자식 클래스의 값을 조절할 수 있게 됩니다.
_____________________________________________________________________________________________

## 제어자(modifiers)

### 접근 제어자

접근 제어자 - public, protected, default(기본), private

클래스 : public, (default)
멤버변수, 메소드, 생성자 메소드 : public, protected, default, private

public : 접근 제한이 전혀 없다.

protected : 같은 패키지에 속하는 클래스에서 필드와 메소드를 사용할 수 있도록 한다. 차이점으로 다른 패키지에 속한 클래스가 해당 클래스의 자식 클래스라면 필드와 메소드를 사용할 수 있다.

default : 같은 패키지 내에서만 접근이 가능하다.

private : 같은 클래스 내에서만 접근이 가능하다.

- 하나의 대상에 여러 개의 제어자를 조합해서 사용할 수 있으나, 접근제어자는 단 하나만 사용할 수 있습니다.

클래스만 public이고 생성자 메소드가 public이 아니면 다른 패키지에서 사용할 수 없으며, 메소드 또한 public이어야지 사용이 가능합니다.

### 활용 제어자

활용 제어자 - static, final, abstract, native, transient, synchronized, volatile, strictfp

#### 1. static

'클래스의' 또는 '공통적인' 의미를 가지고 있습니다. static이 붙은 멤버변수와 메서드, 초기화 블럭은 인스턴스를 생성하지 않고도 사용할 수 있습니다.

static 멤버변수

- 모든 인스턴스에 공통적으로 사용되는 클래스 변수가 된다.

- 클래스변수는 인스턴스를 생성하지 않고도 사용가능하다.

- 클래스가 메모리에 로드될 때 생성된다.


static 메소드

- 인스턴스를 생성하지 않고도 호출이 가능한 static 메서드가 된다.

- static메서드 내에서는 인스턴스멤버들을 직접 사용할 수 없다.


#### 2. final

'마지막의' 또는 '변경될 수 없는' 의미를 가지고 있습니다.

final 클래스

- 변경 될 수 없는 클래스, 확장될 수 없는 클래스가 된다.

- 다른 클래스의 조상이 될 수 없다.

final 메서드

- 변경 될 수 없는 메서드, 오버라이딩을 통해 재정의 될 수 없다.

final 멤버변수, final 지역 변수

- 변경 할 수 없는 상수가 된다.

- final이 붙은 변수는 상수이므로 보통은 선언과 초기화를 동시에 하지만, 인스턴스변수의 경우 생성자에서 초기화 할 수 있다.

#### 3. abstract

'추상의' 또는 '미완성의' 의미를 가지고 있습니다. 메소드의 선언부만 작성하고 실제 수행 내용은 구현하지 않은 추상메서드를 선언하는데 사용합니다. 객체 생성은 안되고 상속만이 가능합니다.

abstract 클래스

- 미완성 클래스로 클래스 내에 0개 이상의 abstract 메소드가 선언되어 있음을 의미한다.

- 객체 생성이 불가하고 상속을 통해서만 사용가능한 클래스이다. 즉 자식 클래스와 상속 관계를 맺음으로 사용하는 클래스이다.

abstract 메소드

- 메소드의 헤더(선언부)만 작성하고 코드블럭(구현부)은 작성하지 않은 추상메서드임을 알린다. 그렇기에 미완성 메소드라고 한다.

- abstract 메소드를 한 개 이상 정의한 클래스는 반드시 abstract 클래스로 정의해야 한다.

- 필요한 메소드지만 자손에 따라 다르게 사용해야하는 메소드일때 사용하는 것으로, 자식이 오버라이딩을 해서 사용하는 메소드를 의미한다.

## 추상 클래스 (abstract class)

클래스가 설계도라면 추상클래스는 ‘미완성 설계도’로 추상메소드(미완성 메소드)를 포함하고 있는 클래스를 말합니다.

* 추상메소드 : 선언부만 있고 구현부(몸통, body)가 없는 메소드

```
abstract class Player{
    int currentPos;

    Player() {
        currentPos = 0;
    }

    abstract void play(int pos);
    abstract void stop();

// 추상 메소드는 구현부가 존재하지 않기에 해당하는 방법으로 선언이 가능합니다.
  
    void play() {
        play(currentPos);
    }
}
```

완성된 설계도가 아니므로 인스턴스를 생성할 수 없으며, 일반메소드가 추상메소드를 호출할 수 있습니다.(호출할 때 필요한 건 선언부) 

보통 다른 클래스를 작성하는 데 도움을 줄 목적으로 작성됩니다. 

즉 어떠한 객체가 상황에 따라 수행코드가 달라지는 객체를 구현할때 사용하는 것으로, 필요한 메소드를 추상 메소드로 작성하고 자식 클래스가 오버라이딩하여 시기적절하게 사용할때 쓰인다고 할 수 있습니다.

이때 자식 클래스가 하나라도 추상 메소드를 오버라이딩하지 않으면 추상 클래스가 되는 것에 주의해야 합니다.

- 여러 클래스에 공통적으로 사용될 수 있는 추상클래스를 바로 작성하거나, **기존클래스의 공통 부분을 뽑아서 추상클래스를 만듭니다.**

기존클래스의 공통 부분을 뽑아서 추상클래스를 만들때 해당하는 클래스의 부모 클래스를 하나 만들어 이들을 묶는 역할로만 만드는 것을 의미합니다.

<p>
<img src="/Week3/Day3_OOP3/course_statement/image/abstarct1.png" width="40%" height="40%"></img>
<img src="/Week3/Day3_OOP3/course_statement/image/abstract2.png" width="40%" height="40%"></img>
</p>
<p align="center">
<img src="/Week3/Day3_OOP3/course_statement/image/abstract3.png" width="50%" height="40%"></img>
</p>

## 자바 패키지 리스트 페이지

https://docs.oracle.com/en/java/javase/11/docs/api/index.html
https://docs.oracle.com/en/java/javase/11/docs/api/java.base/module-summary.html

```
// 해당 메소드의 경우 클래스와 포함 메소드가 static이자 public인데 생성자는 private입니다. 이는 싱글톤 패턴을 사용하기 위함입니다. 

		Runtime r = Runtime.getRuntime(); // 팩토리 메소드
//		Runtime r1 = getRuntime();
//		The method getRuntime() is undefined for the type RuntimeTest
//		생성자가 private이기에 해당 에러가 생성됩니다. 그렇기에 클래스명을 넣고 메소드를 호출해주어야 사용가능합니다.
//		해당 클래스는 static이며 return 값이 run

```

## 싱글톤 패턴

자바 프로그램이 실행되는 동안 객체가 무조건 한 번만 생성되게 만들어진 패턴입니다.
그렇기에 생성자로 객체 생성을 해도 막게 설계되었고 위의 Runtime 클래스는 JVM이기에 싱글톤 패턴을 사용하여 하나의 운영체제만을 유지하게 해주는 것입니다.

```

		Runtime r1 = Runtime.getRuntime();
		Runtime r2 = Runtime.getRuntime();

		System.out.println(r1);
		System.out.println(r2);

        > java.lang.Runtime@1e81f4dc
        > java.lang.Runtime@1e81f4dc
```
