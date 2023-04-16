### 자바에서 싱글톤 패턴을 구현하는 방법
### 싱글톤 패턴  
어떤 클래스의 인스턴스가 오직 하나임을 보장하며  
프로그램 시작부터 종료시까지 어떤 클래스의 인스턴스가 메모리 상에 단 하나만 존재할 수 있게 하고   
이 인스턴스에 대해 어디에서나 접근할 수 있도록 하는 패턴  

### 싱글톤 구현 방법
1. Eager Initialization  
static을 통해 해당 클래스를 Class Loader가 로딩할 때 객체를 생성한다
```java
class Singeton {
    private static Singleton singleton = new Stingleton();

    private Singleton() {

    }

    public static Singleton getInstatnce() {
        return singleton;
    }
}
```
객체가 무조건 생성되기 때문에 자원 낭비가 일어날 수 있으며 Exception 처리를 하지 않는다.

2. Static Block Initialization  
Static Block을 통해 클래스가 로딩될때 한번만 수행하도록 하고, Exception 처리를 한다. 
```java
class Singleton {
    private static Singleton singleton;

    private Singleton() {

    }

    static {
        try {
            singleton = new Singleton();
        } catch(Exceptioin e) {
            throw new RuntimeException();
        }
    }

    public static Singleton getInstance() [
        return singleton;
    ]
}
```
클래스가 로딩될 때 객체를 생성하기 때문에 자원 낭비가 일어날 수 있다.

3. Lazy Initialization  
static으로 선언된 getInstance() 메서드를 통해 객체를 생성하는 방법
```java
class Singleton {
    priate static Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton == null) singleton = new Singleton();
        return singleton;
    }

}
```
getInstance() 메서드를 통해 객체가 존재하지 않으면 새로 생성하고 존재하면 기존 객체를 반환한다.  
이를 통해 자원 낭비 문제를 해결할 수 있다.  
하지만 멀티 스레드 환경에서 한번에 여러 곳에서 메서드를 호출할 경우 여러 개의 객체가 생성되어 동기화 문제가 발생할 수 있다.  

4. Thread Safe Singleton  
synchronized 사용
```java
class Singleton {
    private static Singleton singleton;

    private Singleton() {

    }

    public static synchronized Singleton getInstance() {
        if (singleton == null) 
            singleton = new Singleton();
        return singleton;
    }
}
```
synchronized를 통해 하나의 스레드만 실행하는 것이 보장되며 멀티스레드 환경에서도 안전하게 동작한다.  
하지만 이 방식은 싱글톤 객체 생성 시기 외에도 접근할 때마다 계속해서 synchronized를 호출하기 때문에 비용이 발생하고, 성능 저하가 일어날 수 있다.  

- Double Checked Locking 방식을 사용하여 성능 저하 문제 해결
    ```java
    class Singleton {
        private static Singleton singleton;

        private Singleton() {

        }

        public static Singleton getInstance() {
            if (singleton == null) {
                synchronized (Singleton.class) {
                    if(singleton == null) singleton = new Singleton();
                }
            }
            return singleton;
        }
    }
    ```
    객체 생성 시에만 synchronized가 실행되기 때문에 비용을 절약할 수 있다.

5. Bill Pugh Singleton Implementation  
Inner Static Helper Class 사용하는 방식, 가장 많이 사용되고 있는 구현 방법
```java
class Singleton {
    private Singleton {

    }

    private static class SingletonHelper {
        private static final Singleton SINGLETON = new Singleton();
    }

    private static Singleton getInstance() {
        return SingletonHelper.SINGELTOM;
    }
}
```
Inner Class를 사용하기 때문에 getInstance() 메서드가 호출될 때 JVM 메모리에 로드되고 객체를 생성한다.  
또한 클래스가 로드될 때 객체가 생성되기 때문에 멀티스레드 환경에서도 안전하게 사용할 수 있다.

6. Enum Singleton  
Enum을 사용한 구현
```java
enum EnumSingleton {
    INSTANCE;

    pubilc static void doSomething() {
        
    }
}
```
구현이 간단하며 동기화 문제가 발생하지 않는다.  
하지만 Lazy Loading이 아니기 때문에 자원 문제를 해결하지 못한다.


[참고 자료](https://sorjfkrh5078.tistory.com/108)