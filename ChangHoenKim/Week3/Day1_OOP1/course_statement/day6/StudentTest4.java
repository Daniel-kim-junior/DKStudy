package day6;

// 하나의 패키지 안에 동일한 클래스가 존재할 수 없기에 클래스 이름을 변경하지 않으면 에러가 뜹니다. 패키지가 다를 경우 문제가 되지 않습니다.
class Student4{
	String name;
	int age;
	String subject;
//	멤버 변수들은 자동 초기화 됩니다. 문자열은 기본적으로 null입니다.
	
	Student4(){
//		System.out.println("호출"); 순서가 위에 있으면 Constructor call must be the first statement in a constructor 에러가 발생합니다. (상속과 연관이 있습니다.)
		
		this("듀크", 28, "스프링");
//		아래의 생성자 메소드를 호출하는 것으로 같은 클래스 안에 있는 다른 생성자를 부르는 것입니다. 
		System.out.println("호출 \n"); 
//		this메소드로 소괄호가 쳐져있는 경우 무조건 메소드입니다.
//		생성자 메소드 안에서만 사용이 가능하며 **반드시** 첫 행에 위치해야합니다. 
	}
	
	Student4(String name, int age, String subject) {
		this.name = name;
		this.age = age;
		this.subject = subject;
//		this 변수는 객체생성시 자동으로 생성되는 변수이며 변경이 불가능합니다.
	}
	
//	생성자 메소드
	void printStudentInfo() {
		System.out.printf("%s학생의 나이는 %d입니다. \n", name, age);
	}
	
	void study() {
		System.out.printf("%s학생은 %s과목을 학습합니다. \n", name, subject);
	}
	
	void setSubject(String subject) {
		this.subject = subject;
	}

}

public class StudentTest4 {
	public static void main(String[] args) {
		Student4[] st = new Student4[4];
		
		st[0] = new Student4("둘리", 10, "HTML5"); 
		st[1] = new Student4("또치", 10, "CSS3"); 
		st[2] = new Student4("도우너", 10, "JavaScript"); 
		st[3] = new Student4();
		
		for(Student4 obj : st) { 
			System.out.println(obj);
			obj.printStudentInfo();
			obj.study();
			System.out.println();
		}
		
		st[3].setSubject("JPA");
		st[3].study();

	}

}
