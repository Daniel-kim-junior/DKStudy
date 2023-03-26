package day8;

public class PolyTest {

	public static void main(String[] args) {
		printObjectInfo(new Object());
		printObjectInfo("가나다");
		printObjectInfo("ABC");
		printObjectInfo(new java.util.Date());
		printObjectInfo(new java.io.File("c:/Temp"));
		printObjectInfo(new int[10]);
		printObjectInfo(new double[10]);
		printObjectInfo(100); // java5 - autoboxing으로 넣은 인자의 값을 자동으로 파라미터에 맞게 객체로 변환해줍니다.
		printObjectInfo(10.0);

//		전달된 객체의 클래스명: java.lang.Object
//		전달된 객체의 클래스명: java.lang.String
//		전달된 객체의 클래스명: java.lang.String
//		전달된 객체의 클래스명: java.util.Date
//		전달된 객체의 클래스명: java.io.File
//		전달된 객체의 클래스명: [I
//		전달된 객체의 클래스명: [D
//		전달된 객체의 클래스명: java.lang.Integer
//		전달된 객체의 클래스명: java.lang.Double

//		오브젝트를 넣어도 에러가 나지않는 이유는 다형성으로 조상유형의 변수로 자손의 클래스까지 참조하여 사용할 수 있습니다. 현제 입력한 값들은 모두 Object의 자손입니다.
	}

	static void printObjectInfo(Object o) {
		if(o instanceof String) {
//			어떠한 객체도 올 수 있기에 타입을 확인하는 것이 중요합니다. 객체 타입은 자손에 대한 멤버변수에 접근은 불가하나 한 가지 방법으로 자식 객체로 형변환하는 것이 방법입니다.
//			.연산자가 가장 높은 우선순위를 가집니다.
			System.out.println("문자열 객체가 전달됨: " + o.toString() + "-" + ((String)o).length());
		} else
			System.out.println("전달된 객체의 클래스명: " + o.getClass().getName());
	}
}
