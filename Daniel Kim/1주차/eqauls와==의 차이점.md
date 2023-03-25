
## == 은 데이터의 값을 비교한다.


Primitive Type은 Constant Pool에 있는 특정 상수를 같이 참조하기 때문에 특정 변수 두개는 같은 주소값을 가진다

== 은 데이터의 값을 비교하기 때문에 같은 주소값을 가진 primitive type 변수는 참으로 귀결 된다.
반면에 객체를 담고 있는 변수는 모두 다른 주소값을 가지기 때문에 == 으로 비교 할 수 없는 것이다.


### String은 객체 타입이지만 String Constant Pool을 가지고 있다.
![image](https://user-images.githubusercontent.com/67178562/227700156-a72c44ac-0784-4a63-a055-1cf0528e3312.png)


```
String str1 = "madplay";
String str2 = "madplay";

String str3 = new ("madplay");
String str4 = new ("madplay");

str1 == str2 // 참 (같은 Constant pool의 주소를 가르킨다.)
str3 == str4 // 거짓
str1 == str3 // 거짓

String Constant Pool에 이미 Value가 존재한다면 굳이 새로 주소를 할당하지 않는다.
Primitive Type도 마찬가지

```


## equals()

equals는 최상위 클래스인 Object에 포함되어 있기 때문에 모든 객체는 Override 가능하다

```
Object.equals()

public boolean equals(Object obj) {
	return (this == obj);
}
```

내부적으로 주소값을 비교하고 있다.

```
String.equals();

public boolean eqauls(Object o) {
	if(this == o) {
		return ture;
	}
	if(o instanceof String) {
		String anotherString = (String) o;
		int n = value.length;
		if(n == o.value.length()) {
			char v1[] = value;
			char v2[] = o.value;
			int i = 0;
			while(n-- != 0) {
				if(v1[i] != v2[i]) {
					return false;
				}
				i++;
			}
			return true;
		}
	}

	return false;
}
```

먼저 equals()변수로 들어온 객체가 자기 자신과 주소값이 같으면
`if (this == o)`(이부분) true를 리턴한다. 

주소 값이 다르다면 String 객체의 문자열을 Char 타입으로 하나씩 비교해 보면서 끝까지 같다면 true를 리턴 다르다면 false를 리턴한다.

String클래스에는 처음부터 equals()가 문자열을 비교하게 재정의 되어 만들어져있기 때문에 문자열 비교가 가능하다.

**만약 내가 객체를 새로 만들어 두 값을 비교한다거나 많은 값을 비교해야 한다면  equals나 필요에 따라서는 HashCode를 Override해서 정의해야만 한다.

