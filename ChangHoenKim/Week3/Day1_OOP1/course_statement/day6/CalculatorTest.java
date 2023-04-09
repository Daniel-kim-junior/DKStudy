package day6;

import java.util.Scanner;

class CalculatorExpr {
	private int num1;
	private int num2;

	CalculatorExpr(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	int getAddition() {
		return num1 + num2;
	}

	int getSubtrtaction() {
		return num1 - num2;
	}

	int getMultiplication() {
		return num1 * num2;
	}

	double getDivision() {
		return num1 / num2;
	}

	void setNum1(int num1) {
		this.num1 = num1;
	}

	void setNum2(int num2) {
		this.num2 = num2;
	}
}

public class CalculatorTest {

	public static void main(String[] args) {
		int num1;
		int num2;
		char user;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			num1 = sc.nextInt();
			num2 = sc.nextInt();

			CalculatorExpr calc = new CalculatorExpr(num1, num2);
			System.out.printf("입력된 숫자 : %d, %d \n", num1, num2);
			System.out.printf("덧셈 : %d \n", calc.getAddition());
			System.out.printf("뺄셈 : %d \n", calc.getSubtrtaction());
			System.out.printf("곱셈 : %d \n", calc.getMultiplication());
			System.out.printf("나눗셈 : %s \n", calc.getDivision());
			
			System.out.println("계속 진행하시겠습니까? Y/N");
			sc.nextLine();
			user = sc.next().charAt(0);
			
			if(user == 'N') {
				System.out.println("종료");
				break;
			}
				
		}
		sc.close();
	}

}
