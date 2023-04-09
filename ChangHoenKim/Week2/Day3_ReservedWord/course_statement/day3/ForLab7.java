package day3;
public class ForLab7 {

	public static void main(String[] args) {
		final char STAR = '*';
	
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < Math.abs(i-7); j++) {
				System.out.print(STAR);
			}
			System.out.println();
		}
	}

}
