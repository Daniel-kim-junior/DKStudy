package day4;

public class TwoArrayLab1 {
	public static void main(String[] args) {
//		1. TwoArrayLab1 라는 클래스를 만든다.
//		2. 4개의 행과 4개의 열을 갖는 int 타입의 2차원 배열을 생성한다.
//		 
//		3. 다음과 같은 구성이 되도록 생성된 2차원 배열에 데이터를 대입한다.
//
//		    10, 12, 14, 16
//		    18, 20, 22, 24
//		    26, 28, 30, 32
//		    34, 36, 38, 40
//
//		4. 출력형식
//
//		    	1행 1열의 데이터 : 10
//		   	3행 4열의 데이터 : 32
//			행의 갯수 : 4
//			열의 갯수 : 4
//			3행의 데이터들 : 26 28 30 32
//			2열의 데이터들 : 12 20 28 36
//		             왼쪽 대각선 데이터들 : 10 20 30 40
//		             오른쪽 대각선 데이터들 : 16 22 28 34
//
//		   (*) 이 실습 문제를 해결할 때 제시된 배열은 4행 4열이지만 3행 3열 또는 5행 5열 등
//		       사이즈가 다른 정방행열인 경우에도 요구사항이 처리될 수 있게 구현한다.   
		
		int[][] arr = new int[4][4];
		arr[0] = new int[]{10, 12, 14, 16};
		arr[1] = new int[]{18, 20, 22, 24};
		arr[2] = new int[]{26, 28, 30, 32};
		arr[3] = new int[]{34, 36, 38, 40};
		
		System.out.printf("1행 1열의 데이터 : %d \n", arr[0][0]);
		System.out.printf("3행 4열의 데이터 : %d \n", arr[2][3]);
		System.out.printf("행의 갯수 : %d \n", arr.length);
		System.out.printf("열의 갯수 : %d \n", arr[0].length);
		
		System.out.print("3행의 데이터들 :");
		for(int e : arr[2])
			System.out.print(" "+e);
		System.out.println();
		
		System.out.print("2열의 데이터들 :");
		for(int i = 0; i < arr.length; i++)
			System.out.print(" "+arr[i][1]);
		System.out.println();
		
		System.out.print("왼쪽 대각선 데이터들 :");
		for(int i = 0; i < arr.length; i++) 
			System.out.print(" "+arr[i][i]);
		System.out.println();
		
		int idx = 0;
		System.out.print("오른쪽 대각선 데이터들 :");
		for(int i = arr.length-1; i >= 0; i--) {
			System.out.print(" "+arr[idx][i]);
			idx++;
		}
		System.out.println();
	}

}
