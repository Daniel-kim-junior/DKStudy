package day2;
import java.util.Random;

public class SwitchLab2 {

	public static void main(String[] args) {
		Random rd = new Random();
		int rand = rd.nextInt(5)+1;
		switch(rand) {
		case 1:
			System.out.printf("결과값: %d", 300+50);
			break;
		case 2:
			System.out.printf("결과값: %d", 300-50);
			break;
		case 3:
			System.out.printf("결과값: %d", 300*50);
			break;
		case 4:
			System.out.printf("결과값: %d", 300/50);
			break;
		case 5:
			System.out.printf("결과값: %d", 300%50);
			break;
		}
	
	}

}
