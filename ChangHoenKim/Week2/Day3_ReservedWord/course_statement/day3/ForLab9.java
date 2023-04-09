package day3;
import java.util.Random;

public class ForLab9 {

	public static void main(String[] args) {
		Random rd = new Random();
		int rand = rd.nextInt(2)+1;
		
		switch(rand) {
		case 1:
			for(int i = 1; i <= 9; i ++) {
				if(i%2==1) {
					for(int j = 1; j <= 9; j++) {
						System.out.printf("%dx%d=%d ", i, j, i*j);
					}
				}
				System.out.println();
			}
			break;
		case 2:
			for(int i = 1; i <= 9; i ++) {
				if(i%2==0) {
					for(int j = 1; j <= 9; j++) {
						System.out.printf("%dx%d=%d	", i, j, i*j);
					}
				}
				System.out.println();
			}
			break;
		}
	}

}
