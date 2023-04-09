package day2;
import java.util.Random;

public class ConditionOperLab {

	public static void main(String[] args) {
		Random rd = new Random();
		int rand = rd.nextInt(5)+1;
		
		if(rand == 1) {
			System.out.printf("결과값: %d", 300+50);
		} else if (rand == 2) {
			System.out.printf("결과값: %d", 300-50);
		}else if (rand == 3) {
			System.out.printf("결과값: %d", 300*50);
		}else if (rand == 4) {
			System.out.printf("결과값: %d", 300/50);
		}else {
			System.out.printf("결과값: %d", 300%50);
		}
	}

}
