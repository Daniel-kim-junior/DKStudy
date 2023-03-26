package day3;

public class ControlLab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		while(num < 10) {
			num++;
			if(num %3 == 0 || num%4 ==0) {
				continue;
			}
			System.out.println(num);
		}
	}

}
