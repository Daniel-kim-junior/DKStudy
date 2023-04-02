package day7;

class GuGuDanExpr extends Multiplication{
	GuGuDanExpr(){
	}
	
	GuGuDanExpr(int dan){
		super(dan);
	}
	
	GuGuDanExpr(int dan, int number){
		super(dan, number);
	}
	
	static void printAll() {
		for(int i = 1; i <=9; i++) {
			for(int j = 1; j <=9; j++) {
				System.out.printf("%d*%d=%d\t", i,j,i*j);
			}
			System.out.println();
		}
	}
}
public class GuGuDanApp {

	public static void main(String[] args) {
		int dan = day5.MethodLab5.getRandom(20);
		int number = day5.MethodLab5.getRandom(20);
		
		if(dan<=9 && number <=9) {
			System.out.printf("%d * %d = ",dan, number);
			GuGuDanExpr gu = new GuGuDanExpr(dan, number);
			gu.printPart();
		}else if(dan<=9 && number>=10) {
			GuGuDanExpr gu = new GuGuDanExpr(dan);
			System.out.printf("%d단: ", dan);
			gu.printPart();
		}else {
			GuGuDanExpr.printAll();
		}
	}

}
