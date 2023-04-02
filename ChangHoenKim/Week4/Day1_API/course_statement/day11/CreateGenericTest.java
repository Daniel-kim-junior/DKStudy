package day11;
import java.util.Date;
public class CreateGenericTest {

	public static void main(String[] args) {
		Value1 v1 = new Value1();
		v1.put("가나다");
		String s1 = v1.get();
		System.out.println(s1);
		
		Value2 v2 = new Value2();
		v2.put("가나다");
		String s2 = (String)v2.get();
		System.out.println(s2);
		
		v2.put(new Date());
		Date d1 = (Date)v2.get();
		System.out.println(d1);
		
//		<> 내부의 값을 타입 파라미터라고 하며 반드시 Wrapper class만이 올 수 있습니다.
//		형 변환이 필요없습니다.
		Value3<String> v3 = new Value3();
		v3.put("가나다");
		String s3 = v3.get();
		System.out.println(s3);
		
		Value3<Date> v4 = new Value3();
		v4.put(new Date());
		Date d2 = v4.get();
		System.out.println(d2);
		
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