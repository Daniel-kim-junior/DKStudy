package day7;

class MyObject extends Object{
//	Object는 자바에서 기본으로 제공하고 있는 부모 클래스입니다. 그렇기에 이 부분을 삭제해도 이상이 없고 대부분 생략합니다.
	void printName() {
		System.out.println("자바듀크");
	}
//	오브젝트 조상의 메소드를 재정의하는 오버라이딩을 의미합니다.
//	public 클래스의 메소드를 오버라이딩할때는 public을 꼭 주어야 합니다.
	public String toString() {
		return  "Object의 자식클래스인 Myobject 객체";
	}
}

public class MyObjectTest {
	public static void main(String[] args) {
		MyObject my = new MyObject();
//		.이후에 나오는 리스트는 해당 객체가 사용 가능한 함수나 변수를 의미합니다. 부모 객체가 없는 경우 오브젝트의 기본 메소드를 제공합니다.
		System.out.println(my.toString());
		System.out.println(my);
		System.out.println("출력 "+ my);
		my.printName();
	}
}
