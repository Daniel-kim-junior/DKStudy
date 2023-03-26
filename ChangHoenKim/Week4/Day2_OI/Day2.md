# 자바 입출력

## Object 메소드 오버라이딩

### Collections 클래스

Collections : 컬렉션 API들을 얘기하며 데이터를 묶어서 다루는데 사용함에 있어서 여러 유용한 기능을 제공하는 클래스입니다.

```
	    String[] array = { "JAVA", "SERVLET", "JDBC", "JSP", "RMI" };
		List<String> list = new ArrayList<String>();

        Collections.addAll(list, array);
        // arraylist 객체에 해당 배열의 모든 값을 넣어주는 메소드입니다.

        System.out.println("list에 저장된 모든 데이터 : " + list);


		int index = Collections.binarySearch(list, "JDBC");
        // 주어진 Collections 객체 안에 어떤 데이터가 어느 인덱스에 위치하는 지를 바이너리 서치를 이용해서 리턴합니다.

		System.out.println("\"JDBC\" 가 저장된 위치 : " + index);

		String maxStr = Collections.max(list);
		String minStr = Collections.min(list);
        // Collections 객체 내의 가장 큰 값과 작은 값을 리턴합니다.

		System.out.println("최대값:" + maxStr);
		System.out.println("최소값:" + minStr);

		Collections.sort(list);
        // Collections 객체를 정렬합니다. 기본은 오름차순입니다. Arrays.sort(arr, Collections.reverseOrder());는 내림차 순입니다.

		System.out.println("list의 데이터들을 오름차순으로 소팅한 결과 : " + list);

		Collections.shuffle(list);
        // Collections 객체를 랜덤하게 섞습니다.

		System.out.println("list의 데이터들을 섞은 결과 : " + list);

		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);
		list2.add(20);
		list2.add(15);
		list2.add(5);

		int maxNum = Collections.max(list2);
		int minNum = Collections.min(list2);

        System.out.println("최대값:" + maxNum);
		System.out.println("최소값:" + minNum);
```

- Collections의 메소드는 대부분 static이기에 바로 사용이 가능합니다. Collection의 각각은 개인의 장점이 있지만 Collections에서 제공하지 않는 기능들이 있기에 이를 이용하여 효율적인 코드를 짤 수 있어야 합니다.

### Comparable

Comparable은 크고 작음의 기준이 규정되어 있지 않는 클래스 객체를 사용하는 경우에 이용하는 인터페이스입니다. 만약 클래스 객체에 sort와 같이 대소구분이 필요한 메소드를 이용할 경우 에러가 발생합니다.

```
class Person implements Comparable<Person> {
// Comparable에 제너릭 구문을 이용하여 비교할 객체를 타입 파라미터로 넣어서 사용할 수 있습니다.

	public String name;
	public int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		if(age<o.age) return -1;
		else if(age == o.age) return 0;
		else return 1;
	}
// 오름차 순으로 정렬 코드를 이용하고 싶은 경우에 들어온 아규먼트 클래스 객체보다 기준 클래스가 작은 경우 -1을 리턴하고 나머지를 처리해주면 됩니다. 내림차순인 경우는 reverse를 이용하거나 1을 리턴한 후 나머지를 조정하면 됩니다.

	@Override
	public String toString() {
		return name+"("+age+")";
	}
}

public class CollectionSort2 {
	public static void main(String[] args) {
		List<Person> list = new LinkedList<>();

		for(int i=1; i <= 10; i++) {
			list.add(new Person("duke"+i, new Random().nextInt(30)));
		}

		System.out.println(list);

		Collections.sort(list);
		System.out.println("\nlist의 데이터들을 오름차순으로 소팅한 결과 : " + list);
		Collections.reverse(list);
		System.out.println("\nlist의 데이터들을 내림차순으로 소팅한 결과 : " + list);
	}
}

결과 :

[duke1(9), duke2(3), duke3(3), duke4(17), duke5(29), duke6(11), duke7(6), duke8(8), duke9(26), duke10(25)]

list의 데이터들을 오름차순으로 소팅한 결과 : [duke2(3), duke3(3), duke7(6), duke8(8), duke1(9), duke6(11), duke4(17), duke10(25), duke9(26), duke5(29)]

list의 데이터들을 내림차순으로 소팅한 결과 : [duke5(29), duke9(26), duke10(25), duke4(17), duke6(11), duke1(9), duke8(8), duke7(6), duke3(3), duke2(3)]
```

### Comparator

만약 Comparable를 사용하기 제한되는 상황이라면 Comparator를 이용할 수 있습니다.

```
package day12;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Person2 {
	public String name;
	public int age;

	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return name+"("+age+")";
	}
}

class PersonComparator implements Comparator<Person2> {
	@Override
	public int compare(Person2 o1, Person2 o2) {
		if (o1.age < o2.age)
			return -1;
		else if (o1.age > o2.age)
			return 1;
		else
			return 0;
	}
}

public class CollectionSort3 {
	public static void main(String[] args) {
		List<Person2> list = new LinkedList<>();

		for(int i=1; i <= 10; i++) {
			list.add(new Person2("duke"+i, new Random().nextInt(30)));
		}

		System.out.println(list);

		list.sort(new PersonComparator());
		System.out.println("\nlist의 데이터들을 오름차순으로 소팅한 결과 : " + list);
	}
}
```

객체는 보통 값을 보관하거나 기능 위주로 사용하는 용도로 많이 사용합니다.

이때, **값을 보관하는 객체의 이름은 DTO 혹은 VO를 뒤에 붙입니다.**

### DTO(Data Transfer Object)

순수하게 데이터를 담아 계층 간으로 전달하는 객체입니다. 로직을 갖고 있지 않은 순수한 데이터 객체이며 메서드로는 getter/setter 만을 갖습니다.

여기서 getter/setter 이외에 다른 로직이 필요 없는 이유를 좀 더 자세히 살펴보자면, 만약 DTO가 데이터 전달 만을 위한 객체라고 한다면 완전히 데이터 '전달' 용도로만 사용하기 때문에 getter/setter로직만이 필요하지 다른 로직이 필요하지 않은 것입니다.

### VO(Value Object)

VO는 값 그 자체를 나태는 객체입니다.

DTO와 반대로 로직을 포함할 수 있으며, VO의 경우 특정 값 자체를 표현하기 때문에 불변성의 보장을 위해 생성자를 사용하여야 합니다.

VO는 서로 다른 이름을 갖는 VO 인스턴스라도 모든 속성 값이 같다면 두 인스턴스는 같은 객체인 것이 핵심입니다.

예를 들어 모두 똑같은 자동차가 색깔만 다르다고 하더라도 이를 별개의 객체로 보는 것이 아니라 하나의 객체(자동차)로 보는 것과 같습니다.

### 클래스 간의 동일성 확인

```

class Value {
	int value;

	Value(int value) {
		this.value = value;
	}
}

public class EqualsTest3 {
	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		Value v3 = new Value(20);

		System.out.println(v1.equals(null));
		System.out.println(v1.equals(v3));
		System.out.println(v1.equals(v2));
        //		Object에 있는 equals는 등가연산과 같기 때문에 같은 객체를 참조하는 것이 아니기에 false가 나옵니다.
    }
}

결과:
false
false
fasle

```

그렇기에 클래스가 가지는 값끼리 비교하는 방법은 equals를 오버라이딩하여 클래스에 알맞게 값을 비교해서 리턴 값을 결정해야합니다.

```
package day12;

import java.util.Date;

class Value {
	int value;

	Value(int value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Value)
			return this.value == ((Value)o).value;
		else
			return false;
	 }
}

public class EqualsTest3 {
	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		Value v3 = new Value(20);

		System.out.println(v1.equals(null));
		System.out.println(v1.equals(v3));
		System.out.println(v1.equals(v2));
//		Object에 있는 equals는 등가연산과 같기 때문에 같은 객체를 참조하는 것이 아니기에 false가 나옵니다.
		System.out.println(v1.equals(new Date()));

		if (v1.equals(v2))
			System.out.println("v1과 v2는 같습니다.");
		else
			System.out.println("v1과 v2는 다릅니다.");
		v2 = v1;
		if (v1.equals(v2))
			System.out.println("v1과 v2는 같습니다.");
		else
			System.out.println("v1과 v2는 다릅니다.");
	}
}
```

### HashSet

HashSet에서 객체를 add할 경우 객체의 참조값을 Hash하여 값의 중복을 체크하기에 같은 내부 값을 가지더라도 중복이 허용됩니다. 이를 해결하기 위해서는 hashCode() 메소드를 오버라이딩하여 이용해야 합니다.

```
import java.util.HashSet;
import java.util.Objects;

class Member3 {
	private int id;
	private String name;
	private String password;

	Member3(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o != null && o instanceof Member3) {
			Member3 m = (Member3) o;
			if (id == m.id && name.equals(m.name) && password.equals(m.password))
				return true;
		}
		return false;
	}

	public String toString() {
		return "(" + id + ":" + name + ":" + password + ")";
	}
// 오버라이딩을 통해 객체의 값을 10진수로 리턴
	public int hashCode() {
		return Objects.hash(id, name, password);
	}
}

public class ObjectTest3 {
	public static void main(String args[]) {
		Member3 obj1 = new Member3(10, "자바", "duke");
		Member3 obj2 = new Member3(10, "자바", "duke");
		Member3 obj3 = new Member3(20, "자바", "duke");
//		그냥 사용시 hashCode()를 이용하면 객체의 참조값을 10진수로 리턴
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());
		HashSet<Member3> set = new HashSet<>();
		System.out.println(set.add(obj1));
		System.out.println(set.add(obj2));
		System.out.println(set.add(obj3));
		System.out.println("저장된 데이터의 갯수 : " + set.size());
		System.out.println(set);
	}
}

```

- print 칸 맞춤 팁

```
		System.out.printf("%-10s%-12s%-10s\n---------------------------------------\n","제품 ID", "제품명", "가격");
		for (Product o : set) {
				System.out.printf("%-10s%-12s%-10s\n", o.getProductID(), o.getProductName(), o.getProductPrice());
		}

결과:

제품 ID     제품명         가격
---------------------------------------
p300      Audio       1000
p200      Computer    10000
p100      TV          20000

```

## Java I/O

### 스트림 입출력

Java에서 플랫폼 독립적인 데이터 입출력을 지원하기 위해 스트림이라는 추상적인 구조를 사용합니다. 스트림이란 순서가 있고 길이가 정해져 있지 않은 일련의 데이터 흐름을 의미하는 추상적인 개념으로서 프로그램과 입출력 장치 사이에서 입출력 자료들을 중계하는 역할을 담당합니다. 즉 데이터를 입력 받거나 출력하려면 먼저 스트림에 일련의 바이트 문자들을 기록한 다음 스트림으로부터 데이터를 읽거나 특정 장치에 데이터를 출력하는 것입니다.

스트림을 이용하여 실제 다양한 하드웨어와 입출력을 수행하는 일은 JVM에 의해 실행되며 데이터의 근원지나 목적지에 상관없이 항상 일관된 방법으로 프로그램을 작성할 수 있습니다.
스트림은 우선 데이터가 흘러가는 방향에 따라 구분이 되는데 스트림에서 데이터를 읽어서 프로그램으로 가져오는 경우는 입력 스트림(input stream)이 사용되고 사용하고 있는 프로그램에서 해당 장치와 관련된 스트림으로 출력하는 경우 출력 스트림(ooutput stream)이라 합니다. 또한 처리 방식(I/O하는 단위)에 따라 바이트 스트림(byte stream)과 문자 스트림(character stream)으로 나눌 수 있습니다.

#### 바이트 스트림

바이트 스트림은 byte타입, byte타입 배열, 기본형 데이터 그리고 이진 파일 형식의 객체형 데이터의 입출력을 처리할 수 있습니다. 1바이트 단위로 입출력을 처리합니다.

#### 문자 스트림

문자 스트림은 char 타입, char 타입 배열과 같은 문자형 데이터와 문자열 데이터의 입출력을 처리할 수 있습니다. 영어 이외의 문자에 대한 처리와 문자 인코딩을 내부에서 처리하며 유니코드를 지원하는 Java 특성에 맞게 2바이트 크기로 입출력을 수행합니다.

```
public static void main(String[] args) throws Exception {
    System.out.print("입력: ");
	InputStreamReader isr = new InputStreamReader(System.in);
	char munja = (char) isr.read();
	System.out.println("입력된 문자: " + munja);
}
```

### Scanner를 사용한 파일 내용 읽기

Java SE 5.0부터 추가된 Scanner클래스는 java.util패키지에서 제공되는 클래스로서 문자열의 내용을 원하는 패턴으로 분리하여 토큰형태로 읽는 기능 외에도, 표준 입력 스트림 또는 읽기 모드로 오픈된 파일로부터 원하는 토큰 단위로 데이터를 읽는 기능을 제공합니다.
Scanner객체를 통해서 데이터를 읽어들이는 것을 스캔한다고 합니다. 이 때는 기본 분리자(공백), 단순 분리자(하나의 문자 또는 워드) 그리고 정규 패턴(“\\.\\s\*”)을 적용하여 토큰이라고 불리는 단위로 읽게 됩니다.

```
Scanner scanner = new Scanner(System.in);
System.out.print("두 개의 숫자(정수)를 입력해 주세요 : ");
int number1 = scanner.nextInt();
int number2 = scanner.nextInt();
System.out.println("합 : " + (number1+number2));
System.out.print("두 개의 숫자(실수)를 입력해 주세요 : ");
double number3 = scanner.nextDouble();
double number4 = scanner.nextDouble();
System.out.println("합 : " + (number3+number4))

```

```
Scanner sc1 = new Scanner(new File("data.txt"));
int cnt = 0;
int totalSum = 0;
while (sc1.hasNextLine()) {
    String line = sc1.nextLine();
    Scanner sc2 = new Scanner(line).useDelimiter(",");
    int sum = 0;
    while(sc2.hasNextInt()) {
        sum += sc2.nextInt();
    }
    System.out.println(line + ", sum = "+ sum);
    totalSum += sum;
    cnt++;
}
System.out.println("Line: " + cnt + ", Total: " + totalSum);

```
- nextLine()은 행 단위이고 next() 워드 단위 즉 구분자를 기준으로 읽는 것입니다.

Scanner객체는 data.txt라는 파일로부터 스캔하기 위한 생성한 객체이고 sc2로 참조하는 Scanner객체는 data.txt 파일에서 행 단위로 읽어들인 문자열로부터 스캔하기 위해 생성한 객체입니다.
useDelimiter는 구분자를 공백이 아닌 다른 것으로 지정하고자 할때 사용합니다.

## File 클래스

File클래스는 파일 및 디렉터리를 관리할 수 있는 기능을 제공하는 클래스입니다. 이 클래스를 이용하면 특정 파일의 존재유무, 정보, 복사, 이름변경 그리고 생성 등 파일에 관련된 다양한 작업을 수행할 수 있다. 하지만 한 가지 유의할 점은 File 클래스 자체에서는 파일의 데이터를 입출력하기 위한 메서드는 제공하지 않는다는 것입니다.
Java에서는 모든 데이터의 입출력을 스트림 기반으로 수행하기 때문에 File 클래스 내에는 입출력을 위한 메소드는 제공하지 않고 있습니다. 주로 파일에 대한 정보를 점검하는 용도 그리고 파일을 제어하는 용도로 사용되는 클래스입니다.

```
import java.io.File;
import java.util.Scanner;

public class FileTest1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("생성하려는 디렉토리명을 작성하세요 : ");
		String dirName = scan.nextLine();
		File f = new File(dirName);
		if (f.exists()) {
			System.out.println(dirName + "명의 디렉토리가 존재합니다.");
		} else {
			if (f.mkdirs()) {
				System.out.println(dirName + "명의 디렉토리가 생성되었습니다.");
			} else {
				System.out.println(dirName + "명의 디렉토리 생성에 실패했습니다.");
			}
		}
		scan.close();
	}
}
```

```
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest2 {
	public static void main(String args[]) {
		try (FileWriter writer = new FileWriter("c:/iotest/output2.txt");) {
			// try catch문이 끝나면 자동으로 clos를 해줍니다. 다만 아무 객체나 오는 것이 아닌 Closeable이라는 인터페이스를 추가상속한 객체만이 가능합니다.
			char arr[] = { '객', '체', '지', '향', '언', '어', 'J', 'a', 'v', 'a' };
			for (int cnt = 0; cnt < arr.length; cnt++)
				writer.write(arr[cnt]);
			writer.write('\n');
			writer.write(arr);
			writer.write('\n');
			writer.write("OCJP 시험 대비!!");
			writer.write('\n');
			writer.write(100);
			writer.write('\n');
			System.out.println("파일에 출력 완료!!");
		} catch (IOException ioe) {
			System.out.println("파일로 출력할 수 없습니다.");
		}
	}
}

```

```
package day12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest4 {
	public static void main(String args[]) {
		try (FileReader reader = new FileReader("c:/iotest/output.txt");
				BufferedReader br = new BufferedReader(reader);) {
			String data;
			while (true) {
				data = br.readLine();
				if (data == null)
					break;
				System.out.println(data);
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException ioe) {
			System.out.println("파일을 읽을 수 없습니다.");
		}
	}
}

```
