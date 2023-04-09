package day10;
public class ExceptionTest1 {
	public static void main(String[] args) throws InterruptedException{
		System.out.println("수행시작");
		Thread.sleep(5000);
//		throws InterruptedException를 지우면 Unhandled exception type InterruptedException 발생하며 이는 일반 예외에 속합니다.
		System.out.println("수행종료");
	}
}
