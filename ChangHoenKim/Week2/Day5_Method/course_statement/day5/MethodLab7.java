package day5;

public class MethodLab7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printArray(powerArray(2));
		printArray(powerArray(3));
		printArray(powerArray(4));
	}
	static int[] powerArray(int num) {
		int[] result = new int[10];
		for(int i = 0; i < result.length; i++) {
			result[i] = (i+1)*num;
		}
		return result;
	}
	
	static void printArray(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			System.out.printf("%d,", arr[i]);
		}
		System.out.printf("%d\n", arr[arr.length-1]);
	}
}
