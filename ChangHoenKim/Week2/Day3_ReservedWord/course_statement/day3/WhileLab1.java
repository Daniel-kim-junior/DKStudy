package day3;
import java.util.Random;

public class WhileLab1 {

	public static void main(String[] args) {
		Random rd = new Random();
		int rand = rd.nextInt(6)+5;
		
		System.out.println("[ for 결과 ]");
		for(int i = 1; i <= rand; i++) {
			System.out.printf("%d -> %d \n", i, (int)Math.pow(i, 2));
		}
		
		System.out.println("[ while 결과 ]");
		int whileInt = 1;
		while(whileInt <= rand) {
			System.out.printf("%d -> %d \n", whileInt, (int)Math.pow(whileInt, 2));
			whileInt++;
		}
	}

}
