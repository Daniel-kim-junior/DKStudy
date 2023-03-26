package day6;

class SalaryExpr{
	int bonus;
	
	SalaryExpr() {
		this(0);
	}
	
	SalaryExpr(int bonus){
		this.bonus = bonus;
	}
	
	int getSalary(int grade){
		return  bonus + 100 + (10 - grade*10);
	}
}

public class SalaryExam {

	public static void main(String[] args) {
		int month = day5.MethodLab5.getRandom(12);
		int grade = day5.MethodLab5.getRandom(4);
		
		SalaryExpr expr = month%2==0 ? new SalaryExpr(100): new SalaryExpr();
		System.out.printf("%d월 %d등급의 월급은 %d입니다.", month, grade, expr.getSalary(grade));
	}

}
