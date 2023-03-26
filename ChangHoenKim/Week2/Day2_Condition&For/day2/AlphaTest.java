package day2;
import java.util.Random;

public class AlphaTest {

	public static void main(String[] args) {
		Random rd = new Random();
		int num = rd.nextInt(26)+1;
		System.out.print((char)(num+64));
	}

}
