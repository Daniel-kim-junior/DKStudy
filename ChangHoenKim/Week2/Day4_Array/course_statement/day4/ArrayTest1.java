package day4;

public class ArrayTest1 {
	public static void main(String[] args) {
		int[] score = new int[5];
		System.out.println(score);
//		[I@1e81f4dc 골뱅이 마크 뒤의 값이 참조값이며 대괄호 I는 배열 int형을 의미합니다.
		
		System.out.println(score.length);
		
		for (int i=0; i < score.length; i++)
			System.out.println(score[i]);
		
		for(int i=0; i < score.length; i++)
            score[i] = (i+1)*100;
		
		for (int i=0; i < score.length; i++)
			System.out.println(score[i]);
	}
}
