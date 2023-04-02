# Java Arrays.sort()

자바의 Primitive type 정렬은 Quick-sort를 내부적으로 사용하기 때문에
최악의 시간 복잡도가 O(N^2)이 나온다.

이 부분을 최적화할 필요가 있다.

Quick sort는 평균적으로 O(nlogn) 시간에 작동한다.

동작 원리
1. 원소가 1개 이하이면 정렬되어있다고 가정한다.
2. 배열의 리스트 중 pivot을 하나 설정한다.
3. pivot을 기준으로, 작은 값, 큰 값으로 나눈다.
4. pivot보다 작은 값, 큰 값으로 재귀적으로 정렬한다.
5. pivot보다 작은 정렬된 배열, pivot보다 큰 배열을 이어 붙인다.

이것이 Quick sort이며, 시간복잡도는 T(n) = T(k) + T(n - k - 1) + O(n)
    으로 계산된다.
pivot을 랜덤하게 설정할 경우에는 k는 0부터 n - 1까지의 값을 균일하게 가지고 있다면
T(n) = O(n log n)이라는 것을 알 수 있다.

### java에서 Pivot을 고르는 법

Java의 QuickSort는 DualPivotQuickSort이다. 이 DualPivotQuickSort는 
정렬을 할 때, pivot을 두개 잡는다. pivot을 두개 잡은 이후에, pivot1보다
작은 정렬된 배열, pivot1, pivot1과 2사이의 배열, pivot2, pivot2보다 큰 배열 순으로
이어 붙이는 정렬이다.
이 DualPivotQuicksort에서 Pivot을 잡는 방법은,원소 5개의 적당한 등간격의 원소를 잡는다.
이 이후에 5개를 삽입정렬한 후, 2번째와 4번째 원소를 Pivot으로 잡는다.


### 결론은...
Java로 큰 Primitive type 배열을 정렬해야 할 때는 Integer Type같은 Collections.sort()를
사용하자 (병합 정렬을 사용하기 때문에 최악의 경우를 상정하지 않아도 된다.)

