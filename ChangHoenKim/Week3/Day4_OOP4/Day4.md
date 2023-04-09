# 객체 지향 프로그래밍

## 생성자 메소드

```
public class TimeTest { 
      public static void main(String[] args) { 
            Time t = new Time(12, 35, 30); 
            System.out.println(t); 
            t.hour = 30;
            System.out.println(t); 
            t.minute = -10;
            System.out.println(t); 
      } 
}

class Time { 
      int hour; 
      int minute; 
      int second; 

      Time(int hour, int minute, int second) { 
            this.hour = hour; 
            this.minute = minute; 
            this.second =second; 
      } 

      public String toString() { 
    	  return String.format("%d시 %d분 %d초", hour, minute, second); // System.out.printf() - 화면으로 출력
      } 
} 
```
위 코드는 시, 분, 초를 선언할때 접근 제어자를 생략하여 같은 패키지의 클래스에서는 모두 Time 클래스의 멤버 변수에 접근할 수 있다는 문제점이 있습니다.

30시 혹은 -10분이라는 개념은 존재하지 않는데, 해당 코드는 이를 막거나 예외처리를 해줄 수 있는 함수가 존재하지 않기에 잘못된 값이 들어갈 수 있습니다.

그렇기에 우리가 클래스를 정의할 때는 적절한 접근 제어자를 이용하여 이를 방지하는 것이 중요합니다.

- String toString을 보면 printf의 속성은 화면으로 출력을 하는 것인데 이를 String.format을 이용하여 문자열로 리턴합니다.

```
public class TimeTest2 {
	public static void main(String[] args) {
		Time2 t = new Time2(12, 35, 30);
		System.out.println(t);
		t.setHour(30);
		System.out.println(t);
		t.setMinute(-10);
		System.out.println(t);
		t.setHour(t.getHour()+2);
		System.out.println(t);
	}
}

class Time2 {
	private int hour;
	private int minute;
	private int second;

	Time2(int hour, int minute, int second) {
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (hour < 0 || hour > 23)
			return;
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if (minute < 0 || minute > 59)
			return;
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if (second < 0 || second > 59)
			return;
		this.second = second;
	}

	public String toString() {
		return String.format("%d시 %d분 %d초", hour, minute, second);
	}
}
```

## 인터페이스

서로 상관없는 클래스끼리의 결합이 필요한 경우 자주 사용합니다. 공통되는 요소를 가진 서로 다른 클래스는 추상 클래스로 묶는 것이 가능하지만 서로 다른 요소를 가진 클래스를 묶어야할 경우는 수행하기 어려운 부분들과 수정해야할 양이 늘 수 있습니다.

그렇기에 인터페이스를 사용하여 클래스끼리 묶고 오브젝트 클래스에 상속됩니다. 추상 클래스와 마찬가지로 **객체 생성이 안되며 상속**만이 가능합니다.

추상 메소드가 0개 이상 있을 수 있고 implements를 사용하여 명시합니다.

인터페이스의 메소드 선언시 자동으로 public abstract이 추가되기 때문에 오버라이딩시 반드시 public해주어야 합니다.

인터페이스의 명시적 초기화시 public static final는 자동으로 붙습니다. 꼭 명시적 초기화를 해주어야지만 사용이 가능합니다.


- 클래스의 특별한 형태이며 추상 클래스와 많은 부분 비슷합니다. 
: 객체 생성불가, 상속만 가능 (implements)
 
- 다중상속이 가능합니다.
: 인터페이스 생성시 2개 이상의 인터페이스를 상속할 수 있습니다.
: 인터페이스를 상속하는 클래스 구현시 여러 인터페이스를 설정할 수 있습니다.

- 인터페이스 생성
```
interface 인터페이스명 [extends 부모인터페이스, ...]{
    명시적 초기화를 하고 있는 상수(public static final);
    abstract 메소드; 
________________________________________________________ Java8

    static 메소드;
    default 메소드;  
}

class 클래스명 implements 부모 인터페이스명, ... {
    abstract 메소드 오버라이딩;
}

```

```

interface Printable {
	public static final int PRINT_TYPE1 = 1;
	static final int PRINT_TYPE2 = 2;
	final int PRINT_TYPE3 = 3;
	int PRINT_TYPE4 = 4;

	public abstract void print(int type);
	abstract void setPage(int su);
	boolean isAvailable();
}

abstract class Shape3 {
	String color;

	abstract void draw();

	void setColor(String color) {
		this.color = color;
	}
}

class Circle3 extends Shape3 implements Printable {
	int page;

	void draw() {
		System.out.println(color + " 원을 그리는 기능");
	}

	public void print(int type) {
		System.out.println(type + "번 방식으로 " + page + "페이지를 프린팅한다.");
	}

	public void setPage(int page) {
		this.page = page;
	}

	public boolean isAvailable() {
		if (color.equals("흰색"))
			return false;
		else
			return true;
	}
}

((Shape3) prt).setColor("파란색");
((Circle3) prt).draw();

Circle3 cobj = (Circle3)prt;
cobj.setColor("파란색");
cobj.draw();

```
Printable 인터페이스이므로 setColor를 사용하지 못하기에 부모 클래스인 Shape3 혹은 Circle3로 형변환하여 함수를 사용합니다.

또한 Printable에는 존재하지 않는 Circle3의 draw 또한 사용할 수 없기에 형변환을 해주어야 사용이 가능합니다.

- 만약 클래스가 어느 클래스로 선언됐는지 확인하기 위해서는 **instanceof**를 씁시다. 다만, 같은 인터페이스에 포함된 클래스인데 오버라이딩된 각각의 메소드를 쓰기위해 instaceof를 쓰려는 경우 인터페이스로 형변환을 하면 비교연산자의 사용없이 사용가능합니다.

```
	for (Employee obj : emps) {
			((Bonus) obj).incentive(100);
		}

    for (Employee obj : emp)
				if (obj instanceof Sales) {
					System.out.printf("%s\t%s\t\t   %d\t\t%s\t   %s\n", obj.getName(), obj.getDepartment(),
							obj.getSalary(), obj.tax(), ((Sales) obj).getExtraPay());
				} else
					System.out.printf("%s\t%s\t   %d\t\t%s\n", obj.getName(), obj.getDepartment(), obj.getSalary(),
							obj.tax());
```

## 싱글톤 패턴

싱글톤 패턴은 객체를 한 번만 생성하고 그 객체를 어디서든지 공유하여 사용할 수 있도록 하는 디자인 패턴입니다.

싱글톤 패턴을 구현하는 방법은 다음과 같습니다.

```
public class Singleton {
    private static Singleton instance;
    // private static Singleton instance = null;
    // private static Singleton instance = new Singleton();
    private Singleton() {
        // private 생성자
    }
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

여기서는 Singleton 클래스를 선언하고, instance 변수를 private static으로 선언합니다. 생성자는 private으로 선언하여 외부에서 객체를 생성할 수 없도록 합니다. getInstance() 메서드를 호출하여 객체를 반환하도록 합니다. 이 때 instance 변수가 null이면 객체를 생성하고, 이미 생성된 객체가 있으면 그 객체를 반환하도록 합니다.

이렇게 구현된 싱글톤 패턴을 사용하여 객체를 생성하면, 다음과 같이 객체를 생성하고 사용할 수 있습니다.

```
Singleton singleton = Singleton.getInstance();
```

이를 사용하여 생성된 객체는 어디서든지 공유하여 사용할 수 있습니다. 예를 들어, 다른 클래스에서 Singleton 객체를 사용하려면 다음과 같이 사용할 수 있습니다.

```
Singleton singleton = Singleton.getInstance();
singleton.doSomething();
```