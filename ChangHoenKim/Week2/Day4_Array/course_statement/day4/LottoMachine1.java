package day4;

public class LottoMachine1 {

	public static void main(String[] args) {
//		1. LottoMachine1 이라는 클래스를  생성한다.
//		2. 1부터 45 사이의 난수 6개를 추출하여 다음 형식으로 출력한다.
//		    단, 6개 숫자는 중복을 허용하지 않는다.
//
//		    [ 출력형식 ]
//
//		    오늘의 로또 번호 - x, x, x, x, x, x
		
		
		int[] lottoNumbers = new int[6];
//		int randNum;
//		int index;
//		boolean sig = false;
//		
//		for(int i = 0; i < lottoNumbers.length; i++) {
//			index = (int)(Math.random()*45)+1;
//			checkSame: while(true) {
//				if(sig) {
//					sig = false;
//					randNum = (int)(Math.random()*45)+1;
//					
//					for(int j = 0; j < i; j++) {
//						if(lottoNumbers[j] == randNum) {
//							sig = true;
//							break;
//						}
//					}
//					
//					if (index != randNum && !sig) {
//						lottoNumbers[i] = randNum;
//						break;
//					}
//					else {
//						continue checkSame;
//					}
//				}
//				
//				for(int j = 0; j < i; j++) {
//					if(lottoNumbers[j] == index) {
//						sig = true;
//						break;
//					}
//				}
//				
//				if(!sig) {
//					lottoNumbers[i] = index;
//					break;
//				}
//			}
//			sig = false;
//		}
		
		for(int i = 0; i < lottoNumbers.length; i++) {
			lottoNumbers[i] = (int)(Math.random()*45)+1;
			for(int j = 0; j < i; j++) {
				if(lottoNumbers[i] == lottoNumbers[j]) 
					i--;
			}
		}
		
		System.out.printf("오늘의 로또 번호 - %d", lottoNumbers[0]);
		for (int i = 1; i < lottoNumbers.length; i++)
			System.out.printf(", %d", lottoNumbers[i]);
		
	}

}
