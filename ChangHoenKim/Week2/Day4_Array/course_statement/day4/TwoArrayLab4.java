package day4;

public class TwoArrayLab4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {
				{10, 20, 30, 40, 50},
				{5, 10, 15},
				{11, 22, 33, 44},
				{9, 8, 7, 6, 5, 4, 3, 2, 1}
		};
		int sumRow = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				sumRow += arr[i][j];
			}
			System.out.printf("%d행의 합은 %d 입니다.\n", i+1, sumRow);
			sumRow = 0;
		}
		
	}

}
