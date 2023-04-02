package day5;

public class MethodLab6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("가장 큰 값은 %d 입니다. \n", maxNumArray(new int[]{10, 20, 30}));
		System.out.printf("가장 큰 값은 %d 입니다. \n", maxNumArray(new int[]{100, 500, 300, 200, 400}));
		System.out.printf("가장 큰 값은 %d 입니다.", maxNumArray(new int[]{1, 10, 3, 4, 5, 8, 7, 6, 9, 2}));
	}
	static int maxNumArray(int[] arr) {
		int maxNum = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > maxNum) {
				maxNum = arr[i];
			}
		}
		return maxNum;
	}
}
