package day2;

public class ForLab2 {

	public static void main(String[] args) {
		for(int i = 9; i > 3; i--) {
			String sig = i%2==1 ? "홀수" : "짝수";
			System.out.println(i + " : " + sig);
		}
	}

}
