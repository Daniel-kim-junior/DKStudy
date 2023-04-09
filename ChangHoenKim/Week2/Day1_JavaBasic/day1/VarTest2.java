package day1;
public class VarTest2 {
	public static void main(String[] args) {
		System.out.println(100);
		
		int num;  
		num = 1000;
		System.out.println("연산 전 : "+num);
		num = 10+20;
		System.out.println("연산 후 : "+num);
		
		char munja = 'A';  
		System.out.print(munja); 
		munja++;
		System.out.print(munja); 
		munja += 1;
		System.out.print(munja); 
		munja = (char)(munja+1); 
//		연산자 3가지 = 대입 연산자 , (char) 강제 형변환 연산자, + 더하기 연산자, 괄호를 이용하여 (munja+1)을 먼저 실행 후 강제 형변환 
		
//		munja = munja+1;
//		munja = (char)munja+1;
//		Type mismatch: cannot convert from int to char
		
		
		System.out.println(munja);  
	}
}








