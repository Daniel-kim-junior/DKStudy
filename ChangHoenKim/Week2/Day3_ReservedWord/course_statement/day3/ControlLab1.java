package day3;
import java.util.Random;

public class ControlLab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rd = new Random();
		int cnt = 0;
		int rand = 0;
		while1: while(true) {
			rand = rd.nextInt(11)+10;
			if(rand%3 == 0||rand%5 == 0) {
				int sumNum = 0;
				for(int i = 1; i <= rand; i++) {
					sumNum += i;
				}
				System.out.println(sumNum);
				cnt++;
				continue;
			}else if(rand == 11 || rand == 17 || rand == 19) {
				System.out.printf("%d회 반복함", cnt);
				break while1;
			} else {
				System.out.println("재수행");
//				continue; 데드코드
//				더 이상 수행할 코드가 없으니 결과는 같다는 것을 생각해야합니다.
			}
		}

	}

}
