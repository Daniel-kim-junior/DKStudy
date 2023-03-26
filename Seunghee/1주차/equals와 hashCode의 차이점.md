## equals()와 hashCode()  
최상위 클래스인 Object의 메서드  
해당 인스턴스의 메모리 주소값을 이용

### equals()
- 두 객체의 내용이 동일한지 확인한다
- 동일한 메모리 주소를 가르키면 true 리턴

### hashCode()  
- 두 객체가 같은 객체인지 확인한다
- 객체의 해시코드 값을 반환
- 주소값을 해싱 알고리즘으로 Integer 타입 해시 값으로 만들어 리턴한다

### Hash에서 값을 비교하는 순서
- HashCode 값 비교
    - 값이 동일하다면
        - equals 값 비교
            - 같은 경우 true
            - 다른 경우 false
    - 값이 다르다면
        - false

HashCode값이 다르다면 equals값을 비교하지 않고 해시코드 값만을 이용하여 비교한다

## equals()와 hashCode()를 함께 오버라이딩 해야 하는 이유
1. 둘 다 오버라이딩 하지 않은 경우
```java
public class Product {
    private String productId;

    public Product(String productId) {
        this.productId = productId;
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Product product1 = new Product("id");
        Product product2 = new Product("id");
        System.out.println(product1.equals(product2)); // false

        Set<Product> product = new HashSet<>();
        product.add(product1);
        product.add(product2);
        System.out.println(product.size()); // 2
    }
}
```
product1와 product2는 동일한 productId를 가지고 있기 때문에 동일한 객체로 판단해야 한다.  
하지만 equals 메서드는 주소값 자체를 비교하기 때문에 오버라이딩 하지 않은 경우 서로 다른 객체로 판단한다.  


2. equals()만 오버라이드 한 경우

```java
public class Product {
    private String productId;

    public Product(String productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o != null && o instanceof Product) {
            Product p = (Product) o;
            if (productId == p.productId )
                return true;
        }
        return false;
    }
}
```
```java
public class ProductTest {
    public static void main(String[] args) {
        Product product1 = new Product("id");
        Product product2 = new Product("id");
        System.out.println(product1.equals(product2)); // true

        Set<Product> product = new HashSet<>();
        product.add(product1);
        product.add(product2);
        System.out.println(product.size()); // 2
    }
}
```
equals 메서드를 오버라이딩해 Product 객체를 비교하도록 추가하였다.  
따라서 같은 person1, person2 객체를 equals로 비교 시 true를 리턴한다.  

하지만 중복값을 허용하지 않는 HashSet에 추가 시 다른 객체로 인식하게 된다.   
이는 Hash에서는 equals()로 값을 비교하기 전에 hashCode() 메서드로 먼저 값을 비교해 서로 다른 객체로 인식하기 때문이다.  
따라서 Hash 구조를 사용하는 경우 두 객체의 값을 정확하게 구분할 수 없다.

3. equals와 HashCode 모두 오버라이드
```java
    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
```
```java
public class ProductTest {
    public static void main(String[] args) {
        Product product1 = new Product("id");
        Product product2 = new Product("id");
        System.out.println(product1.equals(product2)); // true

        Set<Product> product = new HashSet<>();
        product.add(product1);
        product.add(product2);
        System.out.println(product.size()); // 1
    }
}
```
이와 같이 equals와 HashCode 메서드를 둘 다 오버라이딩 하면   
equals, hashCode 모두 객체의 인스턴스 변수를 이용하여 값을 비교하기 때문에   
두 객체를 정확하게 구분할 수 있다.


[참고 자료](https://tjdtls690.github.io/studycontents/java/2022-07-27-equals_hashcode/)