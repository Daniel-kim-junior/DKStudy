package day6;

import java.util.Date;

// java.lang을 제외한 클래스와 패키지는 import를 해줘야 합니다.
public class DateTest {
	public static void main(String[] args) {
//		java.util.Date today = new java.util.Date();
		Date today = new Date();
		System.out.println(today.toString());
		System.out.println(today.toLocaleString());
//		-은 가급적 사용하지 말라는 것을 의미하며 계속 사용할 수 없을 것으로 예상되는 기능을 의미합니다. The method toLocaleString() from the type Date is deprecated

	}
}
