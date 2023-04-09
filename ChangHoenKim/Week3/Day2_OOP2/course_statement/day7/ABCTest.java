package day7;

class A {
	A() {
		System.out.println("A클래스의 객체 생성!");
	}
}

class B extends A {
//	B(int num) {
//		System.out.println("B클래스의 객체 생성!");
//	}
	B() {
		super(); // 컴파일될때 해당 호출 문장은 자동으로 생성되나 두 가지 경우 제외됩니다.
//		1. 이미 super가 호출된 경우
//		2. this 호출 문장이 부모 클래스가 들어가 있는 경우
		System.out.println("B클래스의 객체 생성!");
	}
}
// 부모 클래스에 대한 변경은 이미 다른 곳에 생성된 자식 클래스에게 영향을 줄 수 있기에 자식 클래스를 변경하는 것이 적절합니다.
class C extends B {
	C() {
//		super(10);
		System.out.println("C클래스의 객체 생성!");
	}
}

public class ABCTest {
	public static void main(String[] args) {
		new C();
	}
}
