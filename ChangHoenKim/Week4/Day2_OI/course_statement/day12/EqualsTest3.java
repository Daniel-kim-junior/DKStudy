package day12;

import java.util.Date;
import java.util.HashSet;

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
		
		
		HashSet<Value> val = new HashSet<>();
		val.add(v1);
		val.add(v2);
		val.add(v3);
		
		for (Value v : val)
			System.out.println(v.value);
		
//		if (v1.equals(v2))
//			System.out.println("v1과 v2는 같습니다.");
//		else
//			System.out.println("v1과 v2는 다릅니다.");
//		v2 = v1;
//		if (v1.equals(v2))
//			System.out.println("v1과 v2는 같습니다.");
//		else
//			System.out.println("v1과 v2는 다릅니다.");
	}
}
