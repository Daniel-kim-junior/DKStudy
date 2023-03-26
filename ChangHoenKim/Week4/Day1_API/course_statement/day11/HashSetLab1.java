package day11;

import java.util.HashSet;
import java.util.Random;

public class HashSetLab1 {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		Random rd = new Random();

		while (set.size() != 10) {
			set.add(rd.nextInt(21) + 10);
		}

		System.out.print("오늘의 로또 번호 : ");

		int idx = 0;

		for (int num : set) {
			idx++;
			if (idx == set.size())
				System.out.print(num);
			else
				System.out.printf("%d, ", num);
		}
	}

}
