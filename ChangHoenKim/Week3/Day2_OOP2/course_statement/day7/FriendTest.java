package day7;

class Friend extends Person{
	private String phoneNum;
	private String email;
	
	Friend(String name, String phoneNum, String email){
		super(name);
		this.phoneNum = phoneNum;
		this.email = email; 
	}
	
	public String getInfo() {
		return super.getInfo() + "\t" + this.phoneNum + "\t" + this.email;
	}
}

public class FriendTest {

	public static void main(String[] args) {
		Friend[] fr = new Friend[5];
		fr[0] = new Friend("둘리", "010-0000-0000", "둘리@naver.com");
		fr[1] = new Friend("또치", "010-1000-0000", "또치@naver.com");
		fr[2] = new Friend("도우너", "010-2000-0000", "도우너@naver.com");
		fr[3] = new Friend("기영", "010-3000-0000", "기영@naver.com");
		fr[4] = new Friend("철수", "010-4000-0000", "철수@naver.com");
		
		System.out.println("이름\t전화번호\t\t메일주소");
		System.out.println("----------------------------------------");
		for(Friend obj : fr)
			System.out.printf("%s\n", obj.getInfo());
	}

}
