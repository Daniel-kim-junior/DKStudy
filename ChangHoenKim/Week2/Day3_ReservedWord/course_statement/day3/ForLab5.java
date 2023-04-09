package day3;
import java.util.Random;

public class ForLab5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rd = new Random();
		int rand1 = rd.nextInt(8)+3;
		int rand2 = rd.nextInt(3)+1;
		switch(rand2) {
		case 1:
			for(int i = 0; i < rand1; i++) {
				System.out.print('*');
			}
			break;
		case 2:
			for(int i = 0; i < rand1; i++) {
				System.out.print('$');
			}
			break;
		case 3: 
			for(int i = 0; i < rand1; i++) {
				System.out.print('#');
			}
			
		}
	}

}
