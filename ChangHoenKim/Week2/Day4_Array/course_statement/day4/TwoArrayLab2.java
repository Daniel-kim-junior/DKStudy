package day4;

public class TwoArrayLab2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] arrChar = {
				{'B', 'C', 'A', 'A'},
				{'C', 'C', 'B', 'B'},
				{'D', 'A', 'A', 'D'},
		};
		
		int[] arrInt = new int[4];
		
		for(int x = 0; x < arrChar.length; x++) {
			for(int y = 0; y < arrChar[x].length; y++) {
				arrInt[arrChar[x][y]-65] += 1;
			}
		}
		
		char idx = 'A';
		for(int e: arrInt) {
			System.out.printf("%c 는 %d개 입니다. \n", idx, e);
			idx++;
		}
	}

}
