package day8;

public class RuntimeTest {

	public static void main(String[] args) throws Exception {
		Runtime r = Runtime.getRuntime(); // 팩토리 메소드
//		Runtime r1 = getRuntime();
//		The method getRuntime() is undefined for the type RuntimeTest
//		생성자가 private이기에 해당 에러가 생성됩니다. 그렇기에 클래스명을 넣고 메소드를 호출해주어야 사용가능합니다.
//		해당 클래스는 static이며 return 값이 runtime인 경우인데, 객체 생성하지않고 호출을 하면 되기에 위처럼 .연산자를 이용하여 클래스를 작성한 후 사용이 가능한 것입니다.
		
		Runtime r1 = Runtime.getRuntime();
		Runtime r2 = Runtime.getRuntime();
		
		System.out.println(r);
		System.out.println(r1);
		System.out.println(r2);
//		r.exec("c:/windows/notepad.exe");
	}

}
