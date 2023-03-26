package day6;

class Student{
	String name;
	int age;
	String subject;
//	멤버 변수들은 자동 초기화 됩니다. 문자열은 기본적으로 null입니다.
	
	void printStudentInfo() {
		System.out.printf("%s학생의 나이는 %d입니다. \n", name, age);
	}
	
	void study() {
		System.out.printf("%s학생은 %s과목을 학습합니다. \n", name, subject);
	}
}

public class StudentTest {
	public static void main(String[] args) {
		Student st1 = new Student(); 
		Student st2 = new Student(); 
		
		System.out.println("st1이 참조하는 객체 정보: " + st1);
		System.out.println("st2가 참조하는 객체 정보: " + st2);
		
		st1.name = "둘리";
		st1.age = 10;
		st1.subject = "HTML5";
		
		System.out.println();
		st1.printStudentInfo();
		st1.study();
		
		st2.name = "또치";
		st2.age = 10;
		st2.subject = "CSS3";
		
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
