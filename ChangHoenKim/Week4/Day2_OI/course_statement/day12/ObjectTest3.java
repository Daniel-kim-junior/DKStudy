package day12;

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
