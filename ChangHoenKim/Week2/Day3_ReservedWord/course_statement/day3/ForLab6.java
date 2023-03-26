package day3;
import java.util.Random;
public class ForLab6 {

	public static void main(String[] args) {
		final char DECO = '&';
		Random rd = new Random();
		int rand = rd.nextInt(6) + 5;
		
		for(int i = 0; i < rand; i++) {
			for(int j = 0; j < i+1; j++) {
				System.out.print(DECO);
			}
			System.out.println();
		}
	}

}
