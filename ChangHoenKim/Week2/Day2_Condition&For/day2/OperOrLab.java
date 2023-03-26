package day2;
import java.util.Random;

public class OperOrLab {

	public static void main(String[] args) {
		Random rd = new Random();
		int grade = rd.nextInt(6)+1;
		
		if(grade == 1 || grade == 2 || grade == 3) {
			System.out.printf("%d학년은 저학년입니다.", grade);
		}else {
			System.out.printf("%d학년은 고학년입니다.", grade);
		}
	}

}
