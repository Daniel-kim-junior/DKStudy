package day6;

// 하나의 패키지 안에 동일한 클래스가 존재할 수 없기에 클래스 이름을 변경하지 않으면 에러가 뜹니다. 패키지가 다를 경우 문제가 되지 않습니다.
class Student2{
	String name;
	int age;
	String subject;
//	멤버 변수들은 자동 초기화 됩니다. 문자열은 기본적으로 null입니다.
	
	Student2(String name, int age, String subject) {
		this.name = name;
		this.age = age;
		this.subject = subject;
	}
//	생성자 메소드
	
	void printStudentInfo() {
		System.out.printf("%s학생의 나이는 %d입니다. \n", name, age);
	}
	
	void study() {
		System.out.printf("%s학생은 %s과목을 학습합니다. \n", name, subject);
	}
}

public class StudentTest2 {
	public static void main(String[] args) {
		Student2 st1 = new Student2("둘리", 10, "HTML5"); 
		Student2 st2 = new Student2("또치", 10, "CSS3"); 
		
		System.out.println("st1이 참조하는 객체 정보: " + st1);
		System.out.println("st2가 참조하는 객체 정보: " + st2);
		

		System.out.println();
		st1.printStudentInfo();
		st1.study();
		
		System.out.println();
		st2.printStudentInfo();
		st2.study();
		
		System.out.println();
		st2 = st1;
//		st2가 둘리 객체를 참조하게 됩니다.
		st2.printStudentInfo();
		st2.study();
		
		System.out.println();
		System.out.println("st1이 참조하는 객체 정보: " + st1);
//		2번째 객체는 가비지가 되며 참조할 수 없게 됩니다.
		System.out.println("st2가 참조하는 객체 정보: " + st2);
	}

}
