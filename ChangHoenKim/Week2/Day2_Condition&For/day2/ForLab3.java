package day2;
import java.util.Random;

public class ForLab3 {

	public static void main(String[] args) {
		Random rd = new Random();
		int rand2 = rd.nextInt(10)+30;
		int rand1 = rd.nextInt(10)+1;
		int sum = 0;
		
		for(int i = rd.nextInt(10)+1; i < rand2; i++) {
			if(i % 2 == 0) {
				sum += i;
			}
		}
		System.out.printf("%d 부터 %d 까지의 짝수의 합: %d", rand1, rand2, sum);
	}

}
