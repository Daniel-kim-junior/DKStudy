package day4;

public class TwoArrayLab5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arrInt = new int[5][3];
		
		for(int i = 0; i < arrInt.length; i++) {
			for(int j = 0; j < arrInt[i].length; j++) {
				System.out.printf("%d\t", arrInt[i][j]);
			}
			System.out.println();
		}
		
		int num = 1;
		int temp;
		int idx = 0;

		while(true) {
			temp = num;
			for(int i = idx; i < arrInt.length-idx; i++) {
				for(int j = idx; j < idx+1; j++) {
					arrInt[i][j] = num++;
				}
			}
			idx++;
			if (idx == arrInt[0].length || temp == num)
				break;
		}
		
		System.out.println();
		
		for(int i = 0; i < arrInt.length; i++) {
			for(int j = 0; j < arrInt[i].length; j++) {
				System.out.printf("%d\t", arrInt[i][j]);
			}
			System.out.println();
		}
	}

}
