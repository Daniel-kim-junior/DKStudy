package day11;

import java.util.LinkedList;

class Friend extends day7.Person{
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

public class LinkedListLab1 {

	public static void main(String[] args) {
		
		LinkedList<Friend> fr = new LinkedList<Friend>();
		fr.add(new Friend("둘리", "010-0000-0000", "둘리@naver.com"));
		fr.add(new Friend("또치", "010-1000-0000", "또치@naver.com"));
		fr.add(new Friend("도우너", "010-2000-0000", "도우너@naver.com"));
		fr.add(new Friend("기영", "010-3000-0000", "기영@naver.com"));
		fr.add(new Friend("철수", "010-4000-0000", "철수@naver.com"));
		
		System.out.println("이름\t전화번호\t\t메일주소");
		System.out.println("----------------------------------------");
		
		for(Friend obj : fr)
			System.out.printf("%s\n", obj.getInfo());
	}

}
