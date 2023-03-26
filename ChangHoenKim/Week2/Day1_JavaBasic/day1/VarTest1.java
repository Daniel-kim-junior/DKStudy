package day1;

public class VarTest1 {
	public static void main(String[] args) {
		int number1;
		//System.out.println(number1);
		//주석을 제거할 경우 초기화되지 않은 상태의 변수이기에 에러가 뜹니다.
		
		String test = "";
		System.out.println(test);
		
		int number2 = 123;
		System.out.println(number2);
		
		number1 = 10; // 초기화
		System.out.println(number1);		
		System.out.println(number2+number1);
		System.out.println(number2-number1);
		System.out.println(number2*number1);
		System.out.println(number2/number1);
		System.out.println("number1 : "+number1); // 문자열 결합
	}
}
