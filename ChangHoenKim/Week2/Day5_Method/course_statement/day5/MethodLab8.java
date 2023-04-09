package day5;

public class MethodLab8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("호출 1: %d\n", addEven(10, 2, 5, 13, 7));
		System.out.printf("호출 2: %d\n", addEven(11, 22, 33, 44, 55, 66));
		System.out.printf("호출 3: %d\n", addEven());
		System.out.printf("호출 4: %d", addEven(100, 101, 103));
	}

	static int addEven(int... nums) {
		if (nums.length == 0) {
			return -1;
		}
		int sumEven = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				sumEven += nums[i];
			}
		}
		return sumEven;
	}
}
