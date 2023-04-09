# 자바 API

## 자바 참조 타입

### 참조 변수의 == , != 연산

기본 타입 변수의 ==, != 연산은 변수의 값이 같은지, 아닌지를 조사합니다.

참조 타입 변수의 ==, != 연산은 동일한 객체를 참조하는지 or 다른 객체를 참조하는지 알아볼 때 사용합니다.

(이 때 참조 타입 변수의 값 = Heap 영역의 객체 주소 이므로, 결국 주소값을 비교하는 것!)

### null과 NullPointerException

참조 타입 변수는 Heap 영역의 객체를 참조하지 않는다는 뜻으로 null값을 가질 수 있습니다.

null 값도 초기값으로 사용될 수 있기 때문에, null로 초기화된 참조 변수는 stack 영역에 생성됩니다.

참조 변수를 사용하면서 가장 많이 발생하는 예외 중 하나로 NullPointerException이 있습니다. 참조 타입 변수를 사용하는 것은 곧 객체를 사용하는 것을 의미하는데, 참조 타입 변수가 null을 가지고 있다면 곧 참조할 객체가 없다는 것이므로 사용할 수가 없습니다. 하지만 프로그래머의 실수로 null값을 가지고 있는 참조변수를 사용한다면 이 예외가 발생합니다.

### String

String은 클래스 타입이므로 참조 타입입니다.
자바는 문자열 리터럴이 동일하다면 String 객체를 공유하도록 되어있습니다.
아래의 경우 name1, name2은 동일한 String 객체를 참조합니다.

```
String name1 = "박세진";
String name2 = "박세진";
```

하지만 아래처럼 new 연산자를 사용해서 직접 String 객체를 생성하는 경우, name1과 name2는 서로 다른 String 객체를 참조합니다.

```
String name1 = new String("박세진");
String name2 = new String("박세진");
```

동일한 String 객체이든, 다른 String 객체이든 상관없이 문자열만을 비교할 때는 String 객체의 **equals 메소드**를 사용해야 합니다.

위에서 String 객체는 참조 타입이므로 초기값으로 null을 대입할 수 있다고 했습니다. 다음 코드처럼 name 변수가 String 객체를 참조하였으나, null을 대입함으로써 더이상 String 객체를 참조하지 않도록 할 수도 있습니다.

```
String name = "박세진";
name = null;
```
참조를 잃은 String 객체는 JVM은 참조되지 않은 객체를 쓰레기 객체로 취급하고, Garbage Collector를 구동시켜서 메모리에서 자동으로 제거합니다.

### 문자열 메소드 정리

```
char charAt(int index)
```

문자열의 Index번째 문자를 반환합니다.

```
String str = "abcde";
char c = str.charAt(1); // 'b'
```

```
int indexOf(int ch)
int indexOf(int ch, int fromIndex)
int indexOf(String str)
int indexOf(String str, int fromIndex)
```

문자열의 첫번째 인덱스를 기준으로 마지막 인덱스까지 검색하여 특정 문자가 위치한 인덱스를 반환합니다. 
fromIndex는 검색 범위를 지정합니다.

```
fromIndex가 2일 경우 2 ~ 마지막 문자 인덱스 조회
찾지 못하면 -1을 반환한다. 
String str = "abcdef";
System.out.println(str.indexOf("c")); // 2
System.out.println(str.indexOf("c", 2)); // 2
System.out.println(str.indexOf("c", 3)); // -1
```

```
String substring(int beginIndex) 
String substring(int beginIndex, int endIndex)
```

beginIndex부터 endIndex -1 사이에 위치한 String을 반환합니다.

```
String str = "abcdcef";
System.out.println(str.substring(3)); // dcef
System.out.println(str.substring(1, 3)); // bc
```

```
String replace(String target, String replacement) 
String replaceAll(String regex, String replacement)
String replaceFirst(String regex, String replacement)
```

특정 문자열을 검색해 특정 문자열로 변경합니다.
replace 메소드와 replaceAll 메소드의 차이는 정규표현식의 사용 가능 유무입니다.

```
String str = "abcdefbg";
System.out.println(str.replace("a", "apple")); // applebcdefbg
System.out.println(str.replaceAll("[b,a]", "X")); // XXcdefXg
System.out.println(str.replaceFirst("[b,a]", "X")); // Xbcdefbg
```

```
String concat(String str)
```

두개의 문자열을 합쳐서 반환합니다.

```
String str = "I am";
System.out.println(str.concat(" a boy"));//I am a boy
```

```
boolean isEmpty()
```

문자열이 비어있는지 확인합니다.

```
String str = null;
System.out.println(str.isEmpty()); // true
```

```
String[] split(String regex)
String[] split(String regex, int limit)
```

문자열을 특정 문자를 기준으로 나눕니다.

```
정규식을 사용하여 나눌 수 있다.
String str = "1 2 3 4 5 6 7";
str.split(" "); // [1, 2, 3, 4, 5, 6, 7]
str.split(" ", 2); //[1, 2 3 4 5 6 7]
```

```
boolean contains(CharSequence s) 
```

특정 문자가 포함되어있는지 검색합니다.

```
String str = "i am a boy !";
System.out.println(str.contains("bo")); //true
boolean startsWith(String prefix) 
boolean startsWith(String prefix, int toffset)
```

## 자바 파일 구조

패키지(package) : 클래스들을 묶는 단위, 실제로는 폴더가 됩니다. 자바소스의 제일 위에 존재하면 패키지의 선언은 필수가 아닙니다.
- 클래스의 정식 명칭 : 패키지명.클래스명, 패키지명.서브패키지명.클래스명 특정 패키지의 클래스나 인터페이스 사용시 import문으로 선언하여 사용하며 java.lang 패키지는 자동 import됩니다.

### Wrapper class(포장 클래스)

기본형 데이터를 객체로 만들때 사용합니다. Wrapper Class는 자바에서 사용되는 원시타입의 데이터를 서로 형 변환이 가능하도록 지원해주는 Class로써, 원시타입의 자료형들을 Class화 한 것입니다.

int      |   Integer
char     |   Character
double   |   Double
boolean  |   Boolean

2. Wrapper Class 를 사용하는 이유

Wrapper Class 를 사용하는 이유는 크게 두가지로 형변환과 비교연산을 하기 위해서 입니다.

먼저 형변환이라는 건 아래의 코드 예시처럼 데이터 타입을 변환하는 것을 의미합니다.
```
int value = 10; 
Integer wrapper_value = new Integer(value); 
byte byte_value = wrapper_value.byteValue(); 
short short_value = wrapper_value.shortValue();
```

다음은 비교연산을 위한 예제를 보겠습니다.
```
int value = 10; 
Integer wrapper_value = new Integer(value); 
Integer wrapper_value2 = new Integer(value); 
System.out.println(wrapper_value == wrapper_value2); 
System.out.println(wrapper_value.equals(wrapper_value));
```

둘다 true가 찍힐 것처럼 보이나 **false와 ture**가 나옵니다. 왜 안되는지 알기 위해서는 Auto Boxing 과 Auto unBoxing의 개념을 알고 있어야 합니다.


3. Auto Boxing 과 Auto UnBoxing

<img src="/Week4/Day1_API1/course_statement/image/img.png" width="40%" height="40%"></img>

먼저 Boxing이란 '상자에 넣는다'는 것을 의미합니다. 여기서 박스는 위 그림에서 Integer(Class) 객체를 의미하는데 Class내부에는 멤버변수, 메서드, 생성자등 다양한 요소가 존재하는데 거기서 int type의 변수를 포함시켜 Integer 객체로 만든다고 생각하면 될것 같습니다.

때문에 엄밀히 말하자면

```
int value = 10; 
Integer wrapper_value = new Integer(value);
```

두개는 모두 10이라는 같은 값을 갖지만 두개가 같다고는 할 수 없다고 이해할 수 있습니다.

unBoxing이란 반대로 '상자에서 꺼낸다'는 의미입니다. 즉, Integer 객체 내에서 int 형 타입의 변수값만 뽑아낸다는 걸로 이해할 수 있습니다.

그럼 Auto Boxing 과 Auto unBoxing은 Boxing과 unBoxing을 자동으로 해준다는 의미인데 예를 들자면
```
int value = 10; 
Integer wrapper_value = new Integer(value); 
System.out.println(wrapper_value == value);
```

두개의 값은 엄밀히 말하자면 아까는 다르다고 했으니까 결과값은 false가 나와야 하지만,
```
ture
```
여기서 등장하는 개념이 auto unBoxing입니다. 자바 내에서 자동으로 unBoxing 해줘서 값을 비교 하기 때문에 true값이 나오게 되는 겁니다.

하지만 Auto Boxing과 Auto unBoxing을 자주 사용하는것 은 좋지 않습니다. 객체와 변수의 의미를 명확히 하는것이 OOP적 관점에서 매우 중요하기도 하고 코드에 대한 이해도가 낮아질 수 있기 때문입니다.

마지막으로 하나만 더 짚고 넘어갈게 있습니다.

"Wrapper Class 는 Call by Value일가 Call by reference일까?"

결론 부터 말하자면 Wrapper Class 는 클래스 임에도 불구하고 Primitive type 처럼 Call by Value로 작동하는데 그 이유는 auto unBoxing 때문입니다.

Wrapper Class 는 Call by Value로 작동하기 때문에 주의하시면 될것 같습니다.



### String Buffer
```
        StringBuffer buffer = new StringBuffer();
		String str = "자바프로그래밍";
     	buffer.append(str);
//  버퍼를 선언하고 문자열을 추가합니다.

        System.out.printf("%s\n", buffer);
        buffer.reverse();
// 버퍼의 문자열 값을 뒤집습니다.

        System.out.printf("%s\n", buffer);
        System.out.printf("길이 : %d\n", buffer.length());
// 버퍼의 길이를 return합니다.

        buffer.append(str);
        buffer.append(str);
        buffer.append(str);
// 반복해서 넣을 수 있습니다.

        System.out.printf("%s\n", buffer);
        
        StringBuffer bf1 = new StringBuffer("가나다");
        StringBuffer bf2 = new StringBuffer();
        bf2.append("가나다");
// 두 가지 형식으로 선언 가능합니다.

        System.out.printf("%b\n", bf1.equals(bf2));
        System.out.printf("%b\n", bf1 == bf2);
// 버퍼는 두 가지의 형식 모두 false가 나옵니다.

        System.out.printf("%b\n", bf1.toString().equals(bf2.toString()));
// 버퍼를 모두 문자열로 변경하고 equals를 해주어야 값이 비교됩니다.

```

## 자바의 제너릭 구문

제네릭 프로그래밍 : 프로그램에서 처리할 데이터의 타입을 일반화 시킵니다. 재사용성을 높이는 결과가 됩니다. 클래스에서 처리할 데이터 타입을 클래스를 만들 때 결정하는게 아닌, 클래스를 객체 생성할 때 정하는 것입니다.

```
package day11;

public class CreateGenericTest {

	public static void main(String[] args) {
		Value2 v2 = new Value2();
		
//		<> 내부의 값을 타입 파라미터라고 하며 반드시 타입 클래스만이 올 수 있습니다.
		Value3<String> v3 = new Value3();
		Value3<Integer> v4 = new Value3();
		
	}

}

class Value1 {
	String obj;

	void put(String obj) {
		this.obj = obj;
	}

	String get() {
		return obj;
	}
}

// 오브젝트 형을 받아와 어떤 타입도 받을 수 있습니다.
class Value2 {
	Object obj;

	void put(Object obj) {
		this.obj = obj;
	}

	Object get() {
		return obj;
	}
}

// 제너릭을 이용하여 어떤 값이든 받아올 수 있습니다. 단 선언할때 특정 타입으로 선언하여 객체의 타입이 지정가능합니다. 즉 미리 클래스의 타입을 지정하는 것이 아닌 사용시점에서 타입을 지정할 수 있은 것입니다.
class Value3<T> {
	T obj;

	void put(T obj) {
		this.obj = obj;
	}

	T get() {
		return obj;
	}
}
```

제너릭 구문을 장점 중 하나는 값을 가져올때 오브젝트 형처럼 형변환을 할 필요가 없습니다.

```
//      형 변환이 필요합니다.
		Value2 v2 = new Value2();
		v2.put("가나다");
		String s2 = (String)v2.get();
		System.out.println(s2);
		
		v2.put(new Date());
		Date d1 = (Date)v2.get();
		System.out.println(d1);
		
//		형 변환이 필요없습니다.
		Value3<String> v3 = new Value3();
		v3.put("가나다");
		String s3 = v3.get();
		System.out.println(s3);
		
		Value3<Date> v4 = new Value3();
		v4.put(new Date());
		Date d2 = v4.get();
		System.out.println(d2);
```

Object형에서의 문제점은 타입을 명시하지 않고 값을 넣기에 어떤 값을 넣었는지 혼란이 생기고 가독성이 떨어질 수 있습니다. 
이 상황에서 제너릭을 이용하면 타입과 변수의 값을 명시적으로 사용할 수 있습니다.

#### 자료구조 클래스

ArrayList<E>, LinkedList<E>, HashSet<E>

데이터의 키와 값을 저장
HashMap<K,V>
 
extends 혹은 super같은 경우는 어떤 타입의 자식 혹은 부모 타입만이 와야함을 명시합니다.

제너릭 클래스일 경우 선언시 타입 파라미터를 E로 받아와야하는데, 이를 설정하지 않은 경우 Object로 자동 생성되며 warning error가 발생합니다.

리스트 : ArrayList, LinkedList, (Vector)
스택 :  LinkedList, (Stack)
큐 : LinkedList
해쉬 테이블 : HashMap, (HashTable)
집합 : HashSet

위 클래스들은 모두 java.util 패키지에 속합니다. 또한 Vector, Stack, Hashtable 클래스는 구버전부터 있던 클래스이기에 사용이 권장되지 않습니다. 

### 리스트
```
ArrayList<String> list = new ArrayList<String>();
LinkedList<String> list = new LinkedList<String>();
```
ArrayList는 내부에 있는 배열에 데이터를 저장하고 특정 공간이 가득차면 자동으로 늘어나 얼마든지 방을 늘려 데이터의 양을 늘릴 수 있습니다. **중복이 허용됩니다.**

- 주로 read 작업이 많은 경우와 순차적인 데이터의 처리에 유리하며 편집이 잦은 경우는 불리합니다. 그 이유는 특정 칸에 데이터를 삽입 혹은 삭제할 경우에 뒤에 있는 데이터의 이동이 불가피하기 때문입니다.

```
		ArrayList<String> list = new ArrayList<String>();
		list.add("포도");
		list.add("딸기");
		list.add("복숭아");
		int num = list.size();
		for (int cnt = 0; cnt < num; cnt++) {
			String str = list.get(cnt);
			System.out.println(str);
		}
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(Integer.valueOf(100));
		list2.add(1000);// JDK 1.5 부터 AUTO Boxing 이라는 구문이 지원
```

LinkedList는 인접 데이터가 서로 가리키는 식으로 데이터를 저장합니다. 
- 특정 데이터 위치에 바로 접근이 가능하며 연결된 객체만 변경해주면 되기 때문입니다. 다만 인덱스가 설정되어 있지 않기에 순서대로 값을 읽어야만 하기에 한계가 있습니다. 이럴때는 ForEach를 사용하거나 Iterator를 사용하면 빠르게 값을 조회할 수 있습니다.

```
for (String str: list){
    // code
}

forEach 문에서는 리스트로부터 iterator 객체가 자동으로 얻어지고 그 객체를 이용하여 얻은 데이터가 str 변수에 자동으로 대입됩니다.
```

### 해쉬 테이블(hash table) 

여러 개의 통(bucket)을 만들어 두고 키 값을 이용하여 데이터를 넣을 통 번호를 계산하는 자료구조입니다.

#### 해시맵(HashMap) 사용법,예제
```
HashMap 선언

import java.util.HashMap;

HashMap<Integer,Integer> map1 = new HashMap<Integer,Integer>();
// Key - Integer / Value - Integer 타입의 Entry를 갖는 HashMap 선언

HashMap<Integer,Integer> map2 = new HashMap<>();
// New에서 타입 파라미터 생략 가능

HashMap<Integer,Integer> map3 = new HashMap<>(10);
// 초기 용량(capacity) 지정

HashMap<String,String> map4 = new HashMap<String,String>();
// Key - String / Value - String 타입의 Entry를 갖는 HashMap 선언

HashMap<String,String> map5 = new HashMap<String,String>(){{
    put("Key1", "Value1");
    put("Key2", "Value2");
}};
// 초기값 지정
```
HashMap을 생성하려면 위와 같이 키 타입과 값 타입을 파라미터로 주고 기본생성자를 호출합니다. HashMap은 저장공간보다 값이 추가로 들어오면 List와 같이 저장공간을 추가로 늘리지만, List와 다르게 한 칸씩 늘리지 않고 약 두배로 늘리기 때문에 여기서 과부하가 많이 발생합니다. 그렇기에 초기에 저장할 데이터 개수를 알고 있다면 Map의 초기 용량을 지정해주는 것이 좋습니다.

#### HashMap 값 추가
```
HashMap<Integer,String> hm = new HashMap<Integer,String>();
// Key - Integer / Value - Integer 타입의 Entry를 갖는 HashMap 선언

//값 추가
hm.put(1, "One");
hm.put(2, "Two");
hm.put(3, "Three");
hm.put(4, "Four");

System.out.println(hm);
//출력결과 : {1=One, 2=Two, 3=Three, 4=Four}
```

HashMap에 값을 추가하려면 위와 같이 Key와 Value를 파라미터로 주는 Put 메소드를 사용합니다.
HashMap 선언 시에 설정한 타입과 같은 타입의 Key,Value를 넣어야 하며 입력하는 Key 값이 이미 내부에 존재한다면 기존의 Value는 새로 입력되는 Value로 변경됩니다.

#### HashMap 값 삭제
```
// HashMap 선언, 초기값 지정
HashMap<Integer,String> hm = new HashMap<Integer,String>(){{
    put(1, "One");
    put(2, "Two");
    put(3, "Three");
    put(4, "Four");
}};
hm.remove(1); // key값 1 제거
System.out.println(hm); // 출력결과 : {2=Two, 3=Three, 4=Four}
hm.clear(); // 모든 값 제거
System.out.println(hm); // 출력결과 : {}
```
HashMap에서 값을 제거하려면 key를 파라미터로 주는 remove(key) 메소드를 사용합니다.
모든 값을 제거하려면 clear() 메소드를 사용하면 됩니다.

#### HashMap 값 출력
```
// HashMap 선언, 초기값 지정
HashMap<Integer,String> hm = new HashMap<Integer,String>(){{
    put(1, "One");
    put(2, "Two");
    put(3, "Three");
    put(4, "Four");
}};
System.out.println(hm); // 전체 출력 : {2=Two, 3=Three, 4=Four}
System.out.println(hm.get(3)); // Key 값 3의 Value 가져오기 : Three

//entrySet() 활용
for(Map.Entry<Integer,String> entry : hm.entrySet()) {
    System.out.println("Key :" + entry.getKey() + " Value :" + entry.getValue());
}//출력결과
//Key :1 Value :One
//Key :2 Value :Two
//Key :3 Value :Three
//Key :4 Value :Four

//keySet() 활용
for (int i : hm.keySet()) {
    System.out.println("Key :" + i + " Value :" + hm.get(i));
}//출력결과
//Key :1 Value :One
//Key :2 Value :Two
//Key :3 Value :Three
//Key :4 Value :Four
```
특정 Key의 Value를 가져오고 싶다면 get(key)를 사용하고, 전체를 출력하려면 entrySet() 또는 keySet() 메소드를 활용하여 Map의 객체를 반환받은 후 출력할 수 있습니다.
entrySet()은 Key와 Value로 구성된 Entry의 Set을 받기 때문에 Key와 Value가 모두 필요할 경우 사용합니다.
keySet()은 Key의 Set을 반환받기 때문에 Key 값만 필요할 경우 사용하는데, 위의 코드와 같이 get(key) 메소드를 통해 Value까지 받아올 수도 있습니다.

keySet()을 활용하여 value까지 찾을 경우, key 값을 이용해서 value를 찾는 과정에서 시간이 많이 소모되기 때문에 **많은 양의 데이터를 가져와야 한다면 entrySet()이 좋습니다.**
HashMap의 put(key,value) 메소드와 get(key) 메소드를 이용해서 특정 key의 value를 순차적으로 증가시킬 수도 있습니다.

```
// HashMap 선언, 초기값 지정
HashMap<String, Integer> hm = new HashMap<String, Integer>() {{
    put("사과", 15);
    put("바나나", 12);
}};
```
위와 같이 key가 과일 이름이고 value가 과일의 개수인 HashMap이 있을 때, 과일 개수를 증가시키는 방법은 다음과 같습니다.
```
hm.put("사과", hm.get("사과")+1); // "사과" key의 value를 1 증가시킨다.
System.out.println(hm.get("사과")); // 사과 개수 : 16
```

원래 있던 key 값으로 put을 하면 value가 변경되는 것을 이용해서 (원래의 value값 + 1)을 value로 넣습니다.
그렇다면, 원래 없던 key 값을 위의 코드로 value를 증가시키면,

```
hm.put("파인애플", hm.get("파인애플")+1);
System.out.println(hm.get("파인애플"));
```

위와 같이 원래 없던 key 값인 파인애플의 value를 1 증가시키는 코드를 입력하면 NullPointerException이 발생합ㄴ지다. hm에는 파인애플이라는 key가 존재하지 않고, get("파인애플") 메소드를 사용하면 Null이 발생하기 때문입니다. 이를 방지하기 위해 우리는 getOrDefault(key, defaultValue) 메소드를 사용할 수 있습니다.

```
hm.put("파인애플", hm.getOrDefault("파인애플",0)+1);
System.out.println(hm.get("파인애플")); // 출력결과 : 1
```
getOrDefault는 key와 defaultValue를 파라미터로 받는 메소드로, 지정된 key에 매핑된 value가 없거나 null이면 defaultValue를 반환하는 메소드입니다. 만약 위의 파인애플처럼 HashMap에 존재하지(매핑돼있지) 않는 key의 value를 가져오려고 시도하면 defaultValue를 기본값으로 HashMap에 key를 새로 만듭니다.

#### HashMap 크기 구하기
```
HashMap<Integer,String> hm = new HashMap<Integer,String>(){{
    put(1, "One");
    put(2, "Two");
    put(3, "Three");
    put(4, "Four");
}};
System.out.println(hm.size()); // HashMap 크기 출력 : 4
```
HashMap의 크기는 size() 메소드를 사용해서 구합니다.

#### HashMap 특정 키 포함 여부
```
// HashMap 선언, 초기값 지정
HashMap<Integer,String> hm = new HashMap<Integer,String>(){{
    put(1, "One");
    put(2, "Two");
    put(3, "Three");
    put(4, "Four");
}};
System.out.println(hm.containsKey(4)); // Key 값 4 포함 여부 : true
System.out.println(hm.containsKey(5)); // Key 값 5 포함 여부 : false
```
특정 키가 존재하는지 존재하지 않는지 알고 싶을 때는 containsKey(key) 메소드를 사용합니다.
존재한다면 true, 존재하지 않는다면 false를 리턴합니다.
비슷한 메소드로, 특정 value가 존재하는지 확인할 수 있는 containsValue(value) 메소드가 있습니다.

#### HashMap.equals()
```
// HashMap 선언, 초기값 지정
HashMap<Integer,String> hm1 = new HashMap<Integer,String>(){{
    put(1, "One");
    put(2, "Two");
}};
HashMap<Integer,String> hm2 = new HashMap<Integer,String>(){{
    put(1, "One");
    put(2, "Two");
}};
HashMap<Integer,String> hm3 = new HashMap<Integer,String>(){{
    put(1, "One");
    put(3, "Three");
}};
System.out.println(hm1.equals(hm2)); // 출력결과 : true
System.out.println(hm1.equals(hm3)); // 출력결과 : false
```
두 Map이 같은지 비교하려면 두 Map의 매핑 상태가 같다면 true, 같지 않다면 false를 리턴하는 equals()메소드를 사용합니다.

### HashSet
```
package day11;

import java.util.HashSet;
import java.util.Iterator;

public class SetExample1 {
	public static void main(String args[]) {
		HashSet<String> set = new HashSet<String>();
		System.out.println(set.add("자바"));
		System.out.println(set.add("카푸치노"));
		System.out.println(set.add("에스프레소"));
		System.out.println(set.add("자바"));
		System.out.println("저장된 데이터의 수 = " + set.size());

		for (String s : set)
			System.out.println(s);

		Iterator<String> iterator = set.iterator();
//		값을 꺼내는 메소드가 없기에 forecah 문 혹은 이터레이터를 이용해야 합니다.
		while (iterator.hasNext()) {
			String str = iterator.next();
			System.out.println(str);
		}
		System.out.println(set);
	}
}

```