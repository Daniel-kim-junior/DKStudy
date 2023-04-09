package day2;

public class TimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int time = 32150;
		
		int min = time / 60;
		int hour = min / 60;
		int sec = time % 60;
		min = min % 60;
		
		System.out.printf("%02d시간 %02d분 %02d초", hour, min, sec);
	}

}
