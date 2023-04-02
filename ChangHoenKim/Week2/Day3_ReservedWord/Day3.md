# 자바 언어 기초

## final 정리

final은 예약어 중 하나로 final이 들어간 변수 값안 한 번 초기화된 값이 불변하는 상수로 선언되며 상수는 관례적으로 대문자를 사용하는 것을 권장합니다.

1. **Immutable 변수**

final 변수 선언 시 추후에 수정이 불가합니다.

final int COOKIE_SIZE = 3;

추후에 수정할 수 없기 때문에 초기화가 필수입니다. 

2. **final 함수**

메소드 오버라이트를 제한합니다.

3. **final 클래스**

상속이 불가능한 클래스가 됩니다. Wrapper Class 도 final 클래스에 해당됩니다.
 

### Static과의 차이점

static은 모든 인스턴스에 공통된 값을 유지합니다. 또한, 메모리에 한번 할당되어 프로그램이 종료될 때 해제됩니다.

static 또한 메소드, 클래스, 변수에 사용될 수 있습니다.

static 변수는 정적 필드, static 메소드는 정적 메소드라고도 합니다. 이 둘을 합쳐 정적 멤버 또는 클래스 멤버라고 합니다.

단점은 정적멤버는 가비지 콜렉터에 의해 관리되지 않는 영역에서 프로그램 종료시까지 메모리가 할당된 채로 존재하게 됨에 따라 남용시에 시스템 성능에 악영향을 줄 수있다는 점입니다.

 

### 결론

한 번 선언 후 변경 불가능해야하는 경우 -> final

여러 인스턴스에서 공통으로 사용 -> static

여러 인스턴스에서 공통으로 사용하면서, 변경 불가능 -> static final

## 자바 예약어란?

1. **예약어란**
자바 예약어란 프로그래밍 언어인 자바(Java)에서 미리 정해둔 명령어를 말합니다.

프로그래밍에 있어 불필요한 시행착오를 줄이기 위해서 자바에서는 예약어를 사용하며 자바에 이미 예약어로 등록된 명령어는 속성의 변수명, 메소드명으로 사용할 수 없습니다. 

프로그래밍 과정에서 특정 의미가 있는 단어를 프로그래머가 식별자로 사용하게 되면 에러나 버그가 발생할 수 있습니다.

2. **종류**
자바는 모든 표현식과 변수 등의 형식을 컴파일러에 알려야 하는 자료 형식에 엄격한 언어입니다. 자료 형식을 엄격하게 함으로써 컴파일 시간에 자료형과 관련된 에러를 검출할 수 있어 실행 시간에 에러를 검출하는 시간을 줄일 수 있습니다.

자바의 자료 유형에는 Primitive types, User-defined typed, array가 있숩니다. primitive types은 언어에 의해 정의되어 있고, 객체가 아닌 값을 가지는 자료형을 말합니다. 

자바는 논리형, 문자, 바이트 정수, 단정수, 정수, 배정수, 부동 소수점 및 배정밀도 부동 소수점 등의 원시 자료형이 있습니다.

**user-defined typers**은 개발자가 클래스, 인터페이스, 열거형 및 어노테이션을 사용하여 작성한 후 생성하며, 값은 개체가 됩니다. 

예를 들어, 자바의 String 클래스는 문자열을 표현하는 사용자 정의형으로, 문자열을 값으로 가지며 두 개의 문자열을 합치는 것과 같은 문자열에 관한 메소드들로 구성되어 있습니다. 사용자 정의형은 변수가 객체를 저장하는 메모리 영역에 대한 메모리의 주소 또는 다른 식별자의 값을 가지기 때문에 참조형이라고도 합니다. 이와 반대로 원시 자료형의 변수들은 값을 직접 저장합니다.

**array**는 참조된 엘리먼트를 메모리에 같은 크기로 연속적인 슬롯에 값을 저장하는 특별한 참조형입니다. 이 자료형은 차원의 개수를 나타내는 하나 이상의 대괄호 쌍과 엘리먼트형으로 구성되며, 대괄호가 한 쌍이면 일차원, 두 쌍이면 이차원, 세 쌍 이상이면 이차원 배열의 일차원 배열이 됩니다.

**표 정리**

|타입|	예약어|
|-----------|--------------------------|
|기본 데이터 타입|	boolean, byte, char, short, int, long, float, double|
|접근 지정자|	private, protected, public|
|클래스 관련|	class, abstract, interface, extends, implements, enum|
|메서드 관련|	void, return|
|제어문 관련|	if, else, swich, case, default, for, do, while, break, continue|
|논리 리터널|	true, false|
|예외 처리 관련|	try, catch, finally, throw, throws|
|기타|	transient, volatile, package, import, synchronized, native, final, static, strictfp, assert|

## Java 5에서 for문
```
for(변수선언 : 배열 또는 컬렉션 객체)
    배열이나 컬렉션 객체가 가지고 있는 데이터 값들에 대해 반복수행문장
```

## while 문
```

		while(조건식: 연산결과가 boolean인 식)
		    반복수행문장

		while(true){
		    if(조건식)
			반복수행문장
			break;
		}
		수행문장
		// 조건식과 break문이 없는 경우 닿을 수 없는 명령이라는 에러가 뜹니다.

```

## break문

다중 반복문 속 break는 가장 가까운 반복문 하나만의 종료시킵니다.

다중 반복문을 break하려면 **라벨**(lable)을 이용하면 됩니다.

반복문에 변수명을 정하듯 이름을 설정하고 조건을 만족했을 경우 해당 라벨을 종료시키게 설정하는 것입니다.

```
		unico: for(int dan = 1; dan <= 9; dan++) {
			for(int num=1; num <= 9; num++) {
				result = dan*num;
				if (result >= 30)
					break unico;
				System.out.print(dan + "x" + num + "=" + result + "\t");
			}
			System.out.println();
		}	
```

그 외에도 반복문이 중첩 관계일때, break 뒤에 정수를 넣어 몇 개의 반복문을 종료시킬 것인지 설정할 수 있습니다. 
- default는 1입니다.

```
    		for(int dan = 1; dan <= 9; dan++) {
			for(int num=1; num <= 9; num++) {
				result = dan*num;
				if (result >= 30)
					break 2;
				System.out.print(dan + "x" + num + "=" + result + "\t");
			}
			System.out.println();
		}		
```

## continue문 

반복문 내부에서 continue문을 만나면 아래에 남아있는 명령들을 실행하지 않고 반복(증감식)을 수행합니다.

```
		int num;
		while(true) {
			num = (int)(Math.random()*31);
			if (num == 0) {
				System.out.println("\n종료");
				break;
			} 
			if (num > 26) {
				System.out.println('@');
				continue; 
			}
			System.out.printf("%d(%c)", num, (char)(96+num));				
		}
```

## 자바 출력문 정리

자바에서 화면 출력시 print( ), println( ), printf( )문을 사용합니다. 

이중 내가 원하는 데이터 형식으로 화면에 출력하기 위해서는 printf( )문이 주로 사용됩니다. 

1. print( ) - 한줄로 이어서 출력 (줄바꿈 포함 X)
 
2. println( ) - 한 줄씩 줄바꿈하여 출력 (줄바꿈 포함 O)
 
3. printf( ) - 내가 원하는 데이터 형식으로 출력 (줄바꿈 포함 X)
 
### printf
1) printf( ) - 지시자 

%b  : 불리언(boolean) 형식으로 출력 (true or false)
%d  : 10진수(decimal) 형식으로 출력
%o  : 8진수(octal) 형식으로 출력
%x, %X  : 16진수(hexa-decimal) 형식으로 출력 (%x는 소문자로, %X는 대문자로 출력)
%f  : 부동 소수점(floating point) 형식으로 출력
%e, %E  : 지수(exponent) 형식으로 출력
%c  : 문자(character) 형식으로 출력 (Unicode)
%s  : 문자열(string) 형식으로 출력
 

2) printf( ) - 플래그

위 지시자와 함께 아래 플래그를 추가하여 사용하면 더욱 다양한 형식으로 출력할 수 있습니다.

" - "  : 왼쪽으로 정렬
" + "  : 부호출력
" 0 "  : 남는 자리를 0으로 채움
" , "  : 일정 자리수마다 구분문자 표시
" # "  : 8진수, 16진수 표시시 접두사  포함 등 출력형태 보완
" n$ " : n번째 인자의 값을 가져와서 출력

```
		int number = 10;
		double score = 12.345;
		String text = Integer.toBinaryString(number);
		 
		System.out.printf("%b %n", 3<1);         // boolean
		System.out.printf("%d %n", number);      // 10진수
		System.out.printf("%o %n", number);      //  8진수
		System.out.printf("%x %n%n", number);    // 16진수
		System.out.printf("%,d %n", 1000000);    // 10진수 (3자리수마다 ',' 표시)
		System.out.printf("%+d %n", 10);         // 10진수 (부호표시)
		System.out.printf("%+d %n", -10);        // 10진수 (부호표시)
		
		System.out.printf("%f %n", score);       // 부동소수점
		System.out.printf("%e %n%n", score);     // 지수
		
        System.out.printf("%e %$2n %$2n", score, sum);     // $사용 예제

		System.out.printf("%c %n", 65);          // 문자 (Unicode에서 65는 A)
		System.out.printf("%s %n%n", text);      // 문자열 
		
		System.out.printf("[%10d] %n", number);  // 전체 10자리 (우측정렬) 
		System.out.printf("[%-10d] %n", number); // 전체 10자리 (좌측정렬)
		System.out.printf("[%010d] %n", number); // 전체 10자리 (빈공간 0으로 채움)
		System.out.printf("[%10.5f] %n", score); // 전체 10자리, 소수점아래 5자리
```

* 주석

```
int exprSum(int... p) // java5
```
...은 함수에 들어가는 인자의 정수형 변수 개수를 생략도 가능하며 개수 제한없이 넣을 수 있습니다.

```
int exprSum(int[] p)
```
[] 배열 형식의 데이터를 인자로 받는다는 것을 의미하며 배열의 크기는 상관이 없습니다. 

## Scanner

System.in 표준입력장치에서 값을 받아올 수 있게 해주는 api입니다. 이때 표준입력장치는 대부분 키보드입니다.
System.out 표준출력장치로 표준출력할 수 있게 해주는 api입니다. 이때 표준출력장치는 대부분 모니터입니다.

1. ( 문자열 , 숫자열 ) 종류별 스캐너 사용법

스캐너-문자열 입력받기
숫자일 땐 nextInt(), 문자일 땐 두 번째 함수인 next()를 기억하면 됩니다.  
```
        Scanner scan  = new Scanner( System.in );
                
        System.out.print("숫자 입력하셔 ? ");
        int i숫자 = scan.nextInt();
        System.out.println("숫자= "+i숫자);
                
        System.out.print("문자 입력하셔 ? ");
        String s문자  = scan.next();
        System.out.println("문자= "+s문자);
        
        스캐너-한 글자만 입력받기
        문자를 입력받기 위해서는 next(). charAt(0) 매소드를 통해서 입력을 받을 수 있습니다.

        Scanner scan = new Scanner( System.in );
        System.out.print("한글자 입력하셔 ? ");
        char c글자 = scan.next().charAt(0);
        System.out.println("글자= "+c글자);
        
        //한글자 입력하셔 ? ㅁ
        //글자= ㅁ
```
2. 자바 스캐너 여러 번, 연속으로 여러 개 입력받기

for문이나 while문을 통해 여러 번 입력이 가능합니다.

Q. 스캐너를 통해 3개의 정수를 입력받아서 합계 및 평균을 구하시오.
```
        int iMax = 0;
        int iMin = 999999999;
        int iNnum = 0;
        int[] iArr = new int[3];
        int iTotal = 0;
                
        Scanner scan = new Scanner( System.in );
                
        for( int i=0; i < iArr.length; i++ ) {
            System.out.print( (i + 1) + " 번째 수를 입력하세요.");
            iNnum = scan.nextInt();
            iArr[i] = iNnum;
        }
                
        for(int i : iArr) {
            iTotal = iTotal + i;
            iMax = Math.max(i, iMax); 
            iMin = Math.min(i, iMin);
        }
                
        System.out.print( "  합계 = " + iTotal );
        System.out.print( ", 평균 = " + ( double ) iTotal / iArr.length );
        System.out.print( ", 최대값 = " + iMax);
        System.out.print( ", 최소값 = " + iMin);
        //1 번째 수를 입력하세요.3
        //2 번째 수를 입력하세요.1
        // 합계 = 6, 평균 = 2.0, 최대값 = 3, 최소값 = 1
```
3. 스캐너 닫기는 어떻게 하나요? 
```
    if( scan != null ) scan.close();
```
스캐너를 다 사용하신 뒤 제일 마지막에 close로 닫아 주시면 됩니다.

## 듀크, 턱시

듀크 : java의 마스코트입니다.
턱시 : 리눅스의 마스코트입니다.