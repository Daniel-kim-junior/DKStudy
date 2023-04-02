package day3;
import java.util.Random;

public class WhileLab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rd = new Random();
		int pairNum1 = 0;
		int pairNum2 = 0;
		while(true) {
			pairNum1 = rd.nextInt(6)+1;
			pairNum2 = rd.nextInt(6)+1;
			
			if(pairNum1 > pairNum2) {
				System.out.println("pairNum1이 pairNum2 보다 크다.");
			}else if(pairNum1 < pairNum2) {
				System.out.println("pairNum1이 pairNum2 보다 작다.");
			}else{
				System.out.print("게임 꿑");
				break;
			}
			
		}

	}

}
