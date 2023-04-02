package day5;

public class MethodLab3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("%d은 %s 입니다.\n", 10, isEven(10) ? "짝수" : "홀수");
		System.out.printf("%d은 %s 입니다.\n", 13, isEven(13) ? "짝수" : "홀수");
	}

	static boolean isEven(int num) {
		if (num % 2 == 0) {
			return true;
		}
		return false;
	}
}
