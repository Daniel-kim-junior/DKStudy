package day6;
import java.util.Scanner;
class GradeExpr{
	private int[] jumsu;
	
	GradeExpr(int[] jumsu){
		this.jumsu = jumsu;
	}
	
	double getAverage() {
		double average = 0;
		for(double num : jumsu)
			average+=num;
		return average/jumsu.length; 
	}
	
	int getTotal() {
		int sum = 0;
		for(int num : jumsu)
			sum+=num;
		return sum;  
	}
	
	int getGoodScore() {
		int max = jumsu[0];
		for(int num : jumsu) {
			if(num>max)
				max = num;
		}
		return max;
	}
	
	int getBadScore() {
		int min = jumsu[0];
		for(int num : jumsu) {
			if(num<min)
				min = num;
		}
		return min;
	}
}
public class GradeTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int[] array = new int[cnt];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
		}
		
		System.out.print("점수들 : ");
		for(int i = 0; i < array.length; i++) {
			if(i==array.length-1) {
				System.out.printf("%d \n", array[i]);
			}else
				System.out.printf("%d, ", array[i]);
		}
		
		GradeExpr exam = new GradeExpr(array);
		System.out.printf("총점 : %d\n", exam.getTotal());
		System.out.printf("평균 : %s\n", exam.getAverage());
		System.out.printf("최고 점수 : %d\n", exam.getGoodScore());
		System.out.printf("최저 점수 : %d\n", exam.getBadScore());
		sc.close();
	}

}
