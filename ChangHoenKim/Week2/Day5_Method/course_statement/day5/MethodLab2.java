package day5;

public class MethodLab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printSymbol('*', 3);
		printSymbol('&', 14);
		printSymbol('@', 10);
	}
	
	static void printSymbol(char symbol, int num) {
		for(int i = 0; i < num; i++) {
			for(int t = 1; t <= num-i-1; t++) {
				System.out.print(' ');
			}
			for(int j = 1; j <= i+1; j++) {
				System.out.printf("%c", symbol);
			}
			System.out.println();
		}
	}
}
