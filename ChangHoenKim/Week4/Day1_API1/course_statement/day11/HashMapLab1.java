package day11;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapLab1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String nation;
		int nationPeople;

		while (map.size() != 5) {
			System.out.print("나라 이름을 입력하세요 : ");
			nation = sc.next();
			sc.nextLine();
			System.out.print("인구 수를 입력하세요 : ");
			nationPeople = sc.nextInt();

			if (!map.containsKey(nation)) {
				map.put(nation, nationPeople);
				System.out.println("*저장되었습니다.*");
			} else
				System.out.printf("*나라명 %s는 이미 저장되었습니다.*", nation);
		}

		System.out.println("5개가 모두 입력되었습니다.");
		int idx = 0;
		for (String nat : map.keySet()) {
			idx++;
			if (map.size() == idx)
				System.out.printf("%s(%d)", nat, map.get(nat));
			else
				System.out.printf("%s(%d),", nat, map.get(nat));
		}
		sc.close();

	}

}
