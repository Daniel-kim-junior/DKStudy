package day2;
import java.util.Random;

public class SwitchLab1 {

	public static void main(String[] args) {
		Random rd = new Random();
		int grade = rd.nextInt(6)+1;
		int sig = grade < 4 ? 1 : 2;
		
		switch(sig) {
		case 1: 
			System.out.printf("%d학년은 저학년입니다.", grade);
			break;
		case 2:
			System.out.printf("%d학년은 고학년입니다.", grade);
			break;
		}
	}

}
