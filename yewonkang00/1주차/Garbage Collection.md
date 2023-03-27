## 🧹가비지 컬렉션

◾ 자바의 메모리 관리 방법 중 하나

◾ JVM의 Heap 영역에서 동적으로 할당했던 메모리 영역 중 필요없게 된 메모리 영역을 주기적으로 삭제하는 프로세스

◾ C나 C++과는 달리 Java는 JVM에 탑재되어 있는 가비지 컬렉터가 메모리 관리를 대행해 줌

<br/>

### 👍 장점

가비지 컬렉터가 메모리 관리를 대행해주기 때문에 개발자 입장에서 메모리 관리, 메모리 누수 문제에 대해 완벽하게 관리하지 않아도 되어 개발에만 집중할 수 있음

<br/>

### 👎 단점

◾ 개발자가 메모리가 언제 해제되는지 정확하게 알 수 없음

◾ 가비지 컬렉션이 동작하는 동안에는 다른 동작을 멈추기 때문에 오버헤드 발생

<br/>

### ✔ 가비지 컬렉션의 대상이 되는 객체들

메서드가 끝나는 등의 특정 이벤트에 의하여 Heap Area 객체의 메모리 주소를 가지고 있는 참조변수가 삭제되고 <b>Heap 영역에서 어디서든 참조하고 있지 않은 객체(Unreachable)</b>

<br/>

### 🗑 가비지 컬렉션 청소 방식

### <b>Mark And Sweep</b>
<img src="https://user-images.githubusercontent.com/54140431/227819426-bac31bad-4dd4-47f2-aa3c-ec5ae3c64414.png" width="600" height="250">


가비지 컬렉션이 될 대상 객체를 식별(Mark)하고 제거(Sweep)하며 객체가 제거되어 파편화된 메모리 영역을 앞에서부터 채워나가는 작업(Compaction)을 수행


◾ <b>Mark 과정</b> <br/>
먼저 Root Space로부터 그래프 순회를 통해 연결된 객체들을 찾아내어 각각 어떤 객체를 참조하고 있는지 찾아서 마킹

◾ <b>Sweep 과정</b> <br/>
참조하고 있지 않은 객체(Unreachable)를 heap에서 제거

◾ <b>Compact 과정</b> <br/>
Sweep 후에 분산된 객체들을 Heap의 시작 주소로 모아 메모리가 할당된 부분과 그렇지 않은 부분으로 압축

<br/>

### 📃 가비지 컬렉터는 두 가지 가설(Weak Generational Hypothesis)로 설계됨

◾ 대부분의 객체는 금방 접근 불가능 상태(Unreachable)가 된다.

◾ 오래된 객체에서 젊은 객체로의 참조는 아주 적게 존재한다.

👉 객체는 대부분 일회성되며, 메모리에 오랫동안 남아있는 경우는 드물다

<br/>

#### <b>Young 영역</b>

◾ 새롭게 생성된 객체가 할당되는 영역

◾ 대부분의 객체가 금방 Unreachable 상태가 되기 때문에, 많은 객체가 Young 영역에 생성되었다가 사라짐

◾ Young 영역에 대한 가비지 컬렉션을 Minor GC라고 함

<br/>

#### <b>Old 영역</b>

◾ Young 영역에서 Reachable 상태를 유지하여 살아남은 객체가 복사되는 영역

◾ Young 영역보다 크게 할당되며, 영역의 크기가 큰 만큼 가비지는 적게 발생함

◾ Old 영역에 대한 가비지 컬렉션을 Major GC 또는 Full GC라고 함

<br/>

### ✏ 가비지 컬렉션 알고리즘 종류

1. <b>Serial GC</b>

	서버의 CPU 코어가 1개일 때 사용하기 위해 개발된 가장 단순한 GC
	
	GC를 처리하는 쓰레드가 1개여서 가장 stop-the-world 시간이 길다.

2. <b>Parallel GC</b>
	
	Young 영역의 Minor GC를 멀티 쓰레드로, Old 영역은 싱글 쓰레드로 수행
	
	Serial GC에 비해 stop-the-world 시간 감소

3. <b>Parallel Old GC</b>
	
	Young 영역과 Old 영역 모두 멀티 쓰레드로 GC 수행

4. <b>CMS GC</b>
	
	어플리케이션의 쓰레드와 GC 쓰레드가 동시에 실행되어 stop-the-world 시간 최대한 줄이기 위해 고안된 GC
	
	GC 대상을 파악하는 과정이 복잡한 여러 단계로 수행되기 때문에 다른 GC 대비 CPU 사용량 높다

	<img src="https://user-images.githubusercontent.com/54140431/227819927-daaf9374-51b4-429a-98f3-5648b31548d6.png" width="700" height="300">

5. <b>G1 GC (Garbage First)</b>
	
	전체 Heap 영역을 Region이라는 영역으로 체스같이 분할하여 상황에 따라 Eden, Survivor, Old 등 역할을 고정이 아닌 동적으로 부여

	  <img src="https://user-images.githubusercontent.com/54140431/227819937-6050803b-6cd3-40fe-808c-2becd774c9e5.png" width="250" height="250">

<br/>

[참고 URL]
- 심화내용
[https://d2.naver.com/helloworld/1329](https://d2.naver.com/helloworld/1329)
[https://coding-factory.tistory.com/828](https://coding-factory.tistory.com/828)

- 가비지 컬렉션 동작 과정 참고 : [https://coding-factory.tistory.com/829](https://coding-factory.tistory.com/829)

- 가비지 컬렉션 알고리즘 참고
 [https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EA%B0%80%EB%B9%84%EC%A7%80-%EC%BB%AC%EB%A0%89%EC%85%98GC-%EB%8F%99%EC%9E%91-%EC%9B%90%EB%A6%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%F0%9F%92%AF-%EC%B4%9D%EC%A0%95%EB%A6%AC](https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EA%B0%80%EB%B9%84%EC%A7%80-%EC%BB%AC%EB%A0%89%EC%85%98GC-%EB%8F%99%EC%9E%91-%EC%9B%90%EB%A6%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%F0%9F%92%AF-%EC%B4%9D%EC%A0%95%EB%A6%AC)
