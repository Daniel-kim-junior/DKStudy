# 세번쨰 스터디 과제
 : String, StringBuffer, StringBuilder의 차이점

## String
: 문자열을 나타내는 클래스이고 문자열을 조작하는 다양한 메서드를 제공하므로 문자열을 처리하는데 유용합니다.

- String의 한계
  - 불변성(Immutability) : String 객체는 한번 생성되면 할당된 메모리 공간이 변하지 않으므로 기존 문자열에 다른 문자열을 붙여만들면 기존 문자열에 추가할 문자열을 붙이는 게 아닌 새로운 String 객체를 생성해 연결된 문자열을 저장합니다.

## StringBuffer
 : String과 같이 문자열이지만 문자열 연산 등으로 기존 객체의 공간이 부족한 경우 문자열을 동적으로 변경할 수 있는 가변성을 제공합니다.

 - StringBuffer의 한계 
  - 동기화(synchronization)(O) : 멀티스레드 환경에서 안전하도록 동기화되지만 단일 스레드 환경에서는 동기화 관련 처리로 인해 성능이 저하될 수 있습니다.

## StringBuilder
 : StringBuffer처럼 문자열을 나타내는 클래스로 가변성을 제공하고, 동적으로 변경 가능합니다. 동기화된 메서드를 제공하지 않으므로 단일 스레드 환경에서 높은 성능을 제공합니다.
  
  - StringBuilder의 한계
    - 동기화(synchronization)(X) : 동기화된 메서드를 보장하지 않기 때문에 멀티스레드 환경에서의 사용이 한계가 있습니다.


## [정리]
 : String, StringBuffer, StringBuilder 모두 문자열을 관리하는 클래스이지만 String은 불변성 때문에 문자열을 조작하는 경우 유용하게 사용할 수 없어 이때는 StringBuffer와 StringBuilder의 사용을 권합니다. StringBuffer와 StringBuilder는 기존 버퍼 크기를 늘려 유연하게 동작할 수 있지만 StringBuffer는 동기화를 보장해 멀티스레드 환경에서 사용을 권장하고 StringBuilder는 동기화를 보장하지 않아 단일 스레드 환경에서의 사용을 권장합니다.