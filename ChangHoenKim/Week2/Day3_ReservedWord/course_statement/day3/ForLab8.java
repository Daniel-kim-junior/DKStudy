package day3;

public class ForLab8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String STAR = "**********";
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(' ');
			}
			System.out.println(STAR);
		}
	}

}
