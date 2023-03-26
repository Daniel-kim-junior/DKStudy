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
