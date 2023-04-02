package day6;

class Member{
	String name;
	String account;
	String passwd;
	int birthyear;
	
	Member(String name, String account, String passwd, int birthyear){
		this.name = name;
		this.account = account;
		this.passwd = passwd;
		this.birthyear = birthyear;
	}
	
	void printMemberInfo(){
		System.out.printf("%s(%s, %s, %d) \n", name, account, passwd, birthyear);
	}
}

public class MemberTest {

	public static void main(String[] args) {
		Member m1 = new Member("둘리", "둘리123", "1234", 1640);
		Member m2 = new Member("도우너", "도우너123", "2345", 1980);
		Member m3 = new Member("또치", "또치123", "3456", 1990);
		
		System.out.print("회원1 : ");
		m1.printMemberInfo();
		
		System.out.print("회원2 : ");
		m2.printMemberInfo();
		
		System.out.print("회원3 : ");
		m3.printMemberInfo();
	}

}
