package day3;
import java.util.Random;
public class ControllLab3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rd = new Random();
		int rand = 0;
		String sig = "";
		while(true) {
			sig = "";
			rand = rd.nextInt(120)+1;
			if(rand-(rand/10)*10 == 3 && rand <= 43 ) {
				sig += rand + ": 50 미만 \n";
				sig += rand + ": *듀크팀* \n";
			} else if(rand < 50) {
				sig += rand + ": 50 미만 \n";
			} else if(70<= rand && rand<=79) {
				sig += rand + ": 50 이상 80이하 \n";
				sig += rand + ": *턱시팀* \n";
			} else if (50<=rand && rand <=80) {
				sig += rand + ": 50 이상 80이하 \n";
			} else if(80<rand && rand <= 100) {
				continue;
			}
			else {
				break;
			}
			System.out.printf("%s", sig);
		}
		
		
		
	}

}
