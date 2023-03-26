package day5;

public class MethodLab4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int randNum1;
		int randNum2;

		for (int i = 0; i < 5; i++) {
			randNum1 = (int) (Math.random() * 30) + 1;
			randNum2 = (int) (Math.random() * 30) + 1;
			System.out.printf("%d 와 %d 의 차는 %d입니다.\n", randNum1, randNum2, calcAbs(randNum1, randNum2));
		}
	} 

	static int calcAbs(int num1, int num2) {
		if (num1 > num2) {
			return num1 - num2;
		} else
			return num2 - num1;
	}
}
