package day6;

// 하나의 패키지 안에 동일한 클래스가 존재할 수 없기에 클래스 이름을 변경하지 않으면 에러가 뜹니다. 패키지가 다를 경우 문제가 되지 않습니다.
class Student3{
	String name;
	int age;
	String subject;
//	멤버 변수들은 자동 초기화 됩니다. 문자열은 기본적으로 null입니다.
	
	Student3() {
		name = "듀크";
		age = 27;
		subject = "스프링";
//		this를 쓰지 않아도 구분이 될 경우에는 this를 쓰지 않는 것이 좋습니다. 생략 가능한 것은 생략하는 것입니다.
	}
	
	Student3(String name, int age, String subject) {
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

public class StudentTest3 {
	public static void main(String[] args) {
		Student3 st1 = new Student3("둘리", 10, "HTML5"); 
		Student3 st2 = new Student3("또치", 10, "CSS3"); 
		Student3 st3 = new Student3();
		
		System.out.println("st1이 참조하는 객체 정보: " + st1);
		System.out.println("st2가 참조하는 객체 정보: " + st2);
		System.out.println("st2가 참조하는 객체 정보: " + st3);

		System.out.println();
		st1.printStudentInfo();
		st1.study();
		
		System.out.println();
		st2.printStudentInfo();
		st2.study();
		
		System.out.println();
		st3.printStudentInfo();
		st3.study();

	}

}
