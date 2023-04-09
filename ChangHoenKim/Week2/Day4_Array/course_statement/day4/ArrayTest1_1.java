package day4;

public class ArrayTest1_1 {
	public static void main(String[] args) {
		int[] score = new int[5];
		System.out.println(score);
		System.out.println(score.length);

		for (int e : score)
			System.out.println(e);		
//		이터러블한 객체만이 해당 for 문을 사용활 수 있습니다.
		
		for(int i=0; i < score.length; i++)
            score[i] = (i+1)*100;
		
		for (int e : score)
			System.out.println(e);
	}
}
