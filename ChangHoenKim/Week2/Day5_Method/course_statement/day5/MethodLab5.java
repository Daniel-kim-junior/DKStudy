package day5;

public class MethodLab5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			if (i == 4) {
				System.out.print(getRandom(10));
			} else
				System.out.printf("%d, ", getRandom(10));
		}

		System.out.println();
 
		for (int i = 0; i < 5; i++) {
			if (i == 4) {
				System.out.print(getRandom(10, 20));
			} else
				System.out.printf("%d, ", getRandom(10, 20));
		}
	}

	public static int getRandom(int rangeNum) {
		return (int) (Math.random() * rangeNum) + 1;
	}

	public static int getRandom(int rangeNumS, int rangeNumE) {
		return (int) (Math.random() * (rangeNumE - rangeNumS + 1)) + rangeNumS;
	}
}
