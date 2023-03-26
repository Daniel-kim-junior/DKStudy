# 객체 지향 프로그래밍

## 인터페이스

인터페이스 내부에서 메소드를 지정할때 default 예약어를 준 상태에서 메소드를 선언하면 자식 클래스에서 오버라이딩을 하지 않아도 사용할 수 있습니다.

유연성있는 인터페이스 구현에 큰 도움을 주며 자식클래스에서 범용성있게 사용가능합니다. 다만 변수는 상수만이 가능하기에 추상클래스와의 차이를 가집니다.

```

package day10;

interface InterCalculator {

	int add(int x, int y);

	int sub(int x, int y);

	default int mul(int x, int y) {
		return x * y;
	}

	static void print() {
		System.out.println("사칙 연산 처리");
	}
}

class Calculator implements InterCalculator {

	@Override
	public int add(int x, int y) {
		return x + y;
	}

	@Override
	public int sub(int x, int y) {
		return x - y;
	}

	/*
	 * @Override 
	 * public int mul(int x, int y) { System.out.println(x + "와 " + y +
	 * "를 곱합니다."); return x * y; }
	 */

	public int div(int x, int y) {
		if (y != 0)
			return x / y;
		return 0;
	}
}

public interface InterfaceTest3 {
	public static void main(String[] args) {
		InterCalculator cal = new Calculator();
		System.out.println("5 * 3 = " + cal.mul(5, 3));
		System.out.println("5 + 3 = " + cal.add(5, 3));
		System.out.println("5 - 3 = " + cal.sub(5, 3));
		System.out.println("5 - 3 = " + ((Calculator) cal).div(5, 3));
		InterCalculator.print();
	}
}

``` 

- 파일의 이름이 builder 혹은 Factory가 붙어있는 경우 객체를 대신 생성해주는 파일임을 나타내는 것입니다.

```
public class TVFactory {
	public static TV getTV(String beanName){
		TV obj = null;
		if(beanName.equals("samsung")){
			obj = new SamsungTV();
		} else if(beanName.equals("lg")){
			obj = new LgTV();
		}
		return obj;
	}

}
```

## 자바 예외 처리

1. 컴파일 오류 : 구문에 위배된 구현을 했을때 발생합니다. (잘못된 상속, 잘못된 메소드 호출, 코드 형식 ...)

2. 실행 오류 : 에러(Error), 예외(Exeception)

에러(Error) : 자바프로그램이 실행되는 동안 JVM 영역에서 발생되는 오류로 심각한 오류입니다. 더이상 자바 코드를 실행시킬 수 없으며 대비 코드를 작성할 수 없습니다.

예외(Exeception) : 자바프로그램이 실행하는 동안 자바프로그램 영역에서 발생하는 오류이며 가벼운 오류입니다. 이를 예외 처리(Exception Handling)를 통해 해결할 수 있습니다.


자바에서는 예외를 **Checked Exception(일반 예외)**과 **Unchecked Exception(런타임 예외)**으로 구분합니다. 

Checked Exception은 일반 예외로 발생 원인이 프로그램 외부에 있는 것을 말합니다. 발생할 수도 있는 예외에 대한 처리코드 구현이 필수입니다. 컴파일러가 예외 처리를 요구하는 예외이며, 예를 들어 IOException과 SQLException이 이에 해당됩니다. 만약 어떠한 함수를 사용하는 예외처리를 하지 않았다는 에러가 뜬다면 이를 막기 위한 throws문을 작성해야만 합니다. 

Unchecked Exception은 **RuntimeException** 클래스를 상속한 예외로써 발생 원인이 프로그램 내부에 있는 것을 말합니다. 컴파일 시 예외 처리를 요구하지 않으며, NullPointerException과 ArrayIndexOutOfBoundsException 등이 이에 해당됩니다. 발생할 수도 있는 예외에 대한 처리코드 구현이 선택입니다. 하지 않을 시 JVM이 이를 대신 수행합니다.

- RuntimeExection의 경우는 사용하지 않아도 되며 다른 옵션을 줄 수 있습니다.

자바에 서는 예외를 처리하기 위해 try-catch문, throw, throws, finally 등의 예외 처리 메커니즘을 제공합니다.

1. try-catch 문 (적극적인 예외 처리)

try-catch 문은 예외를 처리하기 위해 가장 일반적으로 사용되는 메커니즘입니다. try 블록 내에서 예외가 발생할 가능성이 있는 코드를 작성하고, 예외가 발생하면 catch 블록에서 예외를 처리합니다.

```
try {
    // 예외가 발생할 가능성이 있는 코드
} catch (Exception e) {
    // 예외 처리 코드 catch는 여러 개가 가능합니다.
}
```
 
try 중에 에러가 발생하고 그 에러가 catch문에 있다면 바로 해당 구문으로 가서 코드를 실행합니다. catch문에서 return을 하더라도 finally의 코드는 무조건 실행됩니다.

 ```
public class ExceptionTest2 {
	public static void main(String[] args){
		System.out.println("수행시작");
		try {
			int num1 = Integer.parseInt(args[0]); // NumberFormatException e  둘 중 어느 하나가 정수 형식이 아니라면 그 곳에서 에러가 발생합니다.
			int num2 = Integer.parseInt(args[1]); // NumberFormatException e 

			int result = num1/num2; // ArithmeticException e e를 통해 ArithmeticException이 구현되고 이를 캐치하여 사용할 수 있습니다. 그 예가 바로 e.getMessage()입니다.
			
            System.out.println("연산 결과 : "+result);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("프로그램 아규먼트를 2 개 전달하세요!!");
		} catch (ArithmeticException e) {
		 System.out.println(e.getMessage());
			System.out.println("두번째 프로그램 아규먼트는 0이 아닌 값을 전달하세요!!");
			return;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("프로그램 아규먼트로 숫자를 전달하세요!!");
		}  finally {
			System.out.println("항상 수행!!");
		}
		System.out.println("수행종료");
	}
}

 ```
2. finally (적극적인 예외 처리)

finally 블록은 try-catch 문의 끝에 올 수 있으며, 예외 발생 여부에 상관없이 항상 실행됩니다. finally 블록은 예외가 발생하지 않아도 실행되기 때문에, 자원을 해제하는 등의 공통적인 작업을 처리할 때 유용합니다. 생략이 가능합니다.

```
try {
    // 예외가 발생할 가능성이 있는 코드
} catch (Exception e) {
    // 예외 처리 코드
} finally {
    // 예외 상관 없이 항상 실행되는 코드
}
```
#### 예외 발생
___________________________________________________________________________________________________________________________________________
3. throw

보통 예외는 자바에서 자동으로 발생할 수 있는데, 예를 들어 배열에서 범위를 벗어난 인덱스에 접근하거나, 파일을 찾을 수 없는 경우 등이 이에 해당합니다. 이러한 예외는 자동으로 예외 처리 메커니즘에 의해 처리됩니다. 하지만 때로는 개발자가 직접 예외를 발생시켜야 하는 경우가 있습니다. 이때 throw 키워드를 사용합니다.

throw 키워드는 다음과 같은 형식으로 사용됩니다.

```
throw new Exception("예외 메시지");
```
throw 키워드 뒤에는 new 키워드를 사용하여 발생시킬 예외 객체를 생성하고, 예외 메시지를 함께 전달할 수 있습니다. 이후 예외 객체는 호출자에게 전달되어 예외 처리 메커니즘에 의해 처리됩니다.

예를 들어, 다음과 같이 메서드 내부에서 예외를 발생시킬 수 있습니다.

```
public int divide(int a, int b) throws Exception {
    if (b == 0) {
        throw new Exception("0으로 나눌 수 없습니다.");
    }
    return a / b;
}
```

위 코드에서는 b가 0인 경우 예외를 발생시키고, 호출자에게 예외 객체와 함께 예외 메시지를 전달합니다. 이후 호출자는 예외 처리 메커니즘에 의해 예외를 처리할 수 있습니다.

4. throws (소극적인 예외 처리)

throws 문은 예외를 호출한 메서드나 함수에게 전달하여 예외 처리를 위임하는 메커니즘입니다. throws 문을 사용하면 예외를 발생시키는 메서드에서 예외를 처리하지 않고, 호출한 메서드나 함수에서 처리할 수 있습니다.

```
public void myMethod() throws Exception {
    // 예외가 발생할 가능성이 있는 코드
}
```

__________________________________________________________________________________________________________________________________________
5. try-with-resources 문

try-with-resources 문은 Java 7부터 추가된 기능으로, 자동으로 자원을 해제하는 기능을 제공합니다. try 블록 내에서 사용하는 자원이나 객체를 try-with-resources 문에 선언하면, try 블록이 종료될 때 자원이 자동으로 해제됩니다.

```
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    // 파일 읽기 코드
} catch (IOException e) {
    // 예외 처리 코드
}
```

이렇게 자바에서는 예외 처리를 위한 다양한 메커니즘을 제공하여 예외를 적절하게 처리할 수 있도록 돕습니다.

- System.exit 강제 종료