package day4;

public class TwoArrayLab3 {

	public static void main(String[] args) {
		int[][] gameTime = new int[4][7];
		gameTime[0]	= new int[]{5,  2,  1,  0,  2,  3,  6};
		gameTime[1]	= new int[]{4,  3,  2,  1,  1,  0,  5};
		gameTime[2]	= new int[]{3,  1,  2,  1,  3,  1,  3};
		gameTime[3]	= new int[]{4,  3,  1,  0,  4,  2,  7};
		
		char week[] = {'일','월','화','수','목','금','토'};
		int[] monthTime = new int[7];
		int[] weekTime = new int[4];
		
		for(int i = 0; i < gameTime.length; i++) {
			for(int j = 0; j < gameTime[i].length; j++) {
				monthTime[j] += gameTime[i][j];
				weekTime[i] += gameTime[i][j];
			}
		}
		
		for(int i = 0; i < monthTime.length; i++) {
			System.out.printf("%c요일 : %d시간 \n", week[i], monthTime[i]);
		}

		System.out.println();
		for(int i = 0; i < weekTime.length; i++) {
			System.out.printf("%d주차 : %d시간 \n", i+1, weekTime[i]);
		}
		
	}

}
