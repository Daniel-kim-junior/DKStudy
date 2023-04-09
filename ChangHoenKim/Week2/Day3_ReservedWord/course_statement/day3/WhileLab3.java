package day3;
import java.util.Random;

public class WhileLab3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rd = new Random();
		int cnt = 0;
		int rand = 0;
		while(true) {
			rand = rd.nextInt(31);
			if(rand == 0 || rand >= 27) {
				System.out.printf("출력횟수는 %d번 입니다.", cnt);
				break;
			}else {
				cnt++;
				System.out.printf("%d-%2$c, %2$d, 0x%2$x \n", rand, rand + 64);
			}
			
		}
		
	}

}
