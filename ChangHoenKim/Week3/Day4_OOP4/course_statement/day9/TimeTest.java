package day9;

public class TimeTest { 
      public static void main(String[] args) { 
            Time t = new Time(12, 35, 30); 
            System.out.println(t); 
            t.hour = 30;
            System.out.println(t); 
            t.minute = -10;
            System.out.println(t); 
//            문제점?
//            String toString을 보면 printf의 속성은 화면으로 출력을 하는 것인데 이를 String.format을 이용하여 문자열로 리턴합니다.
//            시, 분, 초를 선언할때 접근 제어자를 생략하여 같은 패키지의 클래스에서는 모두  Time 클래스의 멤버 변수에 접근할 수 있다는 문제점이 있습니다.
//            30시 혹은 -10분이라는 개념은 존재하지 않는데, 해당 코드는 이를 막거나 예외처리를 해줄 수 있는 함수가 존재하지 않기에 잘못된 값이 들어갈 수 있습니다.
      } 
}

class Time { 
      int hour; 
      int minute; 
      int second; 

      Time(int hour, int minute, int second) { 
            this.hour = hour; 
            this.minute = minute; 
            this.second =second; 
      } 

      public String toString() { 
    	  return String.format("%d시 %d분 %d초", hour, minute, second); // System.out.printf() - 화면으로 출력
      } 
} 