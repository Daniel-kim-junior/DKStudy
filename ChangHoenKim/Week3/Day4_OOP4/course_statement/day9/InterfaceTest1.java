package day9;

interface Printable {
	public static final int PRINT_TYPE1 = 1;
	static final int PRINT_TYPE2 = 2;
	final int PRINT_TYPE3 = 3;
	int PRINT_TYPE4 = 4;

	public abstract void print(int type);
	abstract void setPage(int su);
	boolean isAvailable();
}

abstract class Shape3 {
	String color;

	abstract void draw();

	void setColor(String color) {
		this.color = color;
	}
}

class Circle3 extends Shape3 implements Printable {
	int page;

	void draw() {
		System.out.println(color + " 원을 그리는 기능");
	}

	public void print(int type) {
		System.out.println(type + "번 방식으로 " + page + "페이지를 프린팅한다.");
	}

	public void setPage(int page) {
		this.page = page;
	}

	public boolean isAvailable() {
		if (color.equals("흰색"))
			return false;
		else
			return true;
	}
}

class Rectangle3 extends Shape3 {
	void draw() {
		System.out.println(color + " 사각형을 그리는 기능");
	}
}

class Triangle3 extends Shape3 {
	void draw() {
		System.out.println(color + " 삼각형을 그리는 기능");
	}
}

public class InterfaceTest1 {
	public static void main(String args[]) {
		printOut(new Circle3());
		//printOut(new Rectangle3()); // 컴파일 오류가 발생하는 행
	}

	static void printOut(Printable prt) {
		prt.setPage(100);
		((Shape3) prt).setColor("파란색");
		((Circle3) prt).draw();
//		Printable 인터페이스이므로 setColor를 사용하지 못하기에 부모 클래스인 Shape3 혹은 Circle3로 형변환하여 함수를 사용합니다.
//		또한 Printable에는 존재하지 않는 Circle3의 draw 또한 사용할 수 없기에 형변환을 해주어야 사용이 가능합니다.
		if (prt.isAvailable())
			prt.print(Printable.PRINT_TYPE2);
	}
}
