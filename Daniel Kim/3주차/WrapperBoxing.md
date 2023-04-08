# autoBoxing, unBoxing의 대한 이해

### autoBoxing이란?

원시 타입의 값을 해당하는 wrapper 클래스의 객체로 바꾸는 과정을 의미

\*\*\*자바 컴파일러는 원시 타입이 아래 두 가지 경우에 해당할 때 autoBoxing을 적용한다.

```
Passed as a parameter to a method that expects an object of the corresponding wrapper class

Assigned to a variable of the corresponding wrapper class
```

원시타입이 Wrapper 클래스의 타입의 파라미터를 받는 메서드를 통과할때
원시타입이 Wrapper 클래스의 변수로 할당 될 때

```
public class Test {
  private int text;

  public Integer getText() {
    return text;
  }
}

해당 결과를 실행해도 컴파일 오류가 발생하지 않는다

컴파일러가 자동으로 Integer 값으로 AutoBoxing 해주기 때문이다.
```

```
원래는 아래와 같은 과정을 거친다.
public class Test {
  private int text;

  public Integer getText() {
    return Integer.valueOf(text);
  }
}
```

### unBoxing이란?

Wrapper 클래스 타입을 원시 타입으로 변환하는 과정의 의미

ex) Integer -> int

자바 컴파일러는 원시타입이 아래 두 가지 경우에 해당할 때 unBoxing을 적용한다.

- Wrapper 클래스 타입이 원시 타입의 파라미터를 받는 메서드를 통과할 때
- Wrapper 클래스 타입이 원시 타입의 변수로 할당될 때

```
// Java program to illustrate the concept
// of Autoboxing and Unboxing
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
        // creating an Integer Object
        // with value 10.
        Integer i = new Integer(10);

        // unboxing the Object
        int i1 = i;

        System.out.println("Value of i: " + i);
        System.out.println("Value of i1: " + i1);

        //Autoboxing of char
        Character gfg = 'a';

        // Auto-unboxing of Character
        char ch = gfg;
        System.out.println("Value of ch: " + ch);
        System.out.println("Value of gfg: " + gfg);

    }
```

### Advantages of autoBoxing / unBoxing

- autoBoxing과 unBoxing은 개발자에게 가독성이 높고 깨끗한 코드를 작성하는데 도움을 준다.
- autoBoxing과 unBoxing을 사용한다면 Wrapper 클래스 타입과 원시 타입을 상호 교환 가능하게끔 사용할 수 있고
- 명시적으로 타입 캐스팅을 수행하지 않아도 된다.

### 하지만 박싱된 기본 타입보단 기본 타입을 사용하자

1. 기본 타입은 값만 가지고 있지만 박싱 된 타입은 값 + 식별성이라는 속성을 갖는다.

- 즉 박싱된 타입의 두 인스턴스는 값이 같아도 다르다고 식별 될수 있다.

2. 기본 타입은 null을 허용하지만 박싱된 타입은 허용하지 않는다.

3. 기본 타입이 박싱된 타입보다 시간과 메모리 효율면에서 효율적이다.

\*\*\*첫 번째 수가 두 번째 수보다 작으면 -1을 리턴하고 그렇지 않다면 같은지를 비교하는 프로그램

```
public class BrokenComparator {
    public static void main(String[] args) {

        Comparator<Integer> naturalOrder =
                (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

        Integer i1 = 42;
        Integer i2 = 42;

        int result1 = naturalOrder.compare(i1, i2);
        System.out.println(result1);

        int result2 = naturalOrder.compare(new Integer(42), new Integer(42));
        System.out.println(result2);
    }
}
```

== 비교는 주소 비교이다. 대충 보았을 땐 42 , 42 같으니 0을 리턴하는 것이라고 생각하지만

이전에 말했듯이 Integer(42) , Integer(42)는 서로 다른 주소를 참조하기 때문에 주소 비교 결과 틀리다는 -1을 리턴하게 된다.

아래와 같이 기본형으로 오토 박싱을 하면 정상적인 결과가 리턴된다.

Comparator<Integer> naturalOrder = (preNum, laNum) -> {
int i = preNum;
int j = laNum;

      return (i < j) ? -1 : (i == j ? 0 : 1);

};

### 아래의 코드는 신기하게도 NPE를 던진다

```
public class Unbelievable {
    static Integer i;

    public static void main(String[] args) {
        if (i == 42)
            System.out.println("what!!!");
    }
}
```

기본 타입과 박싱 된 기본 타입을 혼용한 연산에서는 박싱된 기본 타입의 박싱이 자동으로 풀린다.

그러므로 null 참조를 언박싱하면 NPE가 일어나는 것이다. (0으로 초기화 안됨)

### 굉장히 느린 코드

```
Long sum = 0L;

for(long i=0 ; i < Integer.MAX_VALUE ; i++) {
    sum +=i;
}
System.out.println(sum);
```

왜냐면 지역변수 sum을 박싱 타입으로 선언하였기 때문에 비교 연산을 할 때마다 박싱과 언박싱이 반복해서 일어나기 때문이다.

개선된 코드

```
  long sum = 0L;
  int max = Integer.MAX_VALUE;

  for(long i=0 ; i < max ; i++) {
    sum +=i;
  }
  System.out.println(sum);
```

박싱 된 기본 타입은 언제 사용될까?

컬렉션의 원소, 키, 값으로 쓴다. - 컬렉션은 기본 타입을 담을 수 없으므로

### 번외 JPA 필드 타입을 wrapper class를 쓰는 이유

1. Null 처리
   기본 타입을 사용할 경우 해당 필드가 null일 경우에 대한 처리가 어렵습니다. 예를 들어 int 타입의 필드에 null 값을 저장하고자 할 때, 해당 필드를 nullable로 선언해도 Java에서는 int 타입의 변수에 null 값을 저장할 수 없기 때문에 컴파일 오류가 발생합니다. 하지만 Integer(wrapper 클래스) 타입의 필드를 사용하면 해당 필드가 null일 경우에 대한 처리가 용이해집니다.

2. JPA의 특성
   JPA는 엔티티(Entity)를 객체로 다루기 때문에 객체 지향적인 설계를 지향합니다. 이에 따라, 기본 타입 대신 wrapper 클래스를 사용하면 JPA에서 객체를 다루는 데 더욱 용이합니다.

3. 기능 제공
   wrapper 클래스는 기본 타입을 감싸기 때문에, 해당 클래스가 제공하는 다양한 메서드를 활용할 수 있습니다. 예를 들어 Integer 클래스는 int 타입을 다루는 데 필요한 다양한 기능(예: 2진수, 16진수로 변환하는 기능 등)을 제공합니다.
