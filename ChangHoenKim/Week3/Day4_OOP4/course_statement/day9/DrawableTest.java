package day9;

import java.util.Random;

interface Drawable {
	void draw();
// 자동으로 public이 추가되기 때문에 오버라이딩시 반드시 public해주어야 합니다.
}

class Rect implements Drawable {
	public void draw() {
		System.out.println("사각형을 그립니다.");
	}
}

class Circle implements Drawable {
	public void draw() {
		System.out.println("원을 그립니다.");
	}
}

class Diamond implements Drawable {
	public void draw() {
		System.out.println("마름모를 그립니다.");
	}
}

public class DrawableTest {
	public static void main(String[] args) {
		Random rand = new Random();
		int num = rand.nextInt(3);
		Drawable d = null;
//		참조형 변수 생성시는 null로 초기화해야 합니다.
		if (num == 0)
			d = new Rect();
		else if (num == 1)
			d = new Circle();
		else if (num == 2)
			d = new Diamond();
		output(d);
	}

	public static void output(Drawable d) {
		System.out.println("전달된 객체의 클래스명 : " + d.getClass().getName());
		d.draw();
	}
}
