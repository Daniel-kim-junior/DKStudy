
자바 api 정렬에서 Arrays.sort()는 어떤 정렬 알고리즘을 사용하나요? 최악의 경우 시간복잡도는? Arrays.sort()의 대안은?

## Arrays.sort()란?

자바에서 java.util.Arrays 클래스의 sort()메소드를 이용하여 배열을 오름차순으로 정렬할 수 있다.

- Primitive type을 정렬할 때
- int형 정렬
	public static void sort(int[] a, int fromIndex, int toIndex) {
		rangeCheck(a.length, fromIndex, toIndex);
		DualPivotQuicksort.sort(a, fromIndex, toIndex-1, null, 0, 0);
	}

- short 형
	public static void sort(short[] a) {
	 DualPivotQuicksort.sort(a, 0, a.length-1, null, 0, 0);
	}

static void sort(int[] a, int left, int right, int[] work, int workBase, int workLen) {
	if(right - left < QUICKSORT_THRESHOLD) {
		sort(a, left, right, true);
		return;
	}
	int[] run = new int[MAX_RUN_COUNT + 1];
	int count = 0;
	run[0] = left;
}

JAVA 11 버전 기준 DualPivotQuickSort 사용
Best Cases : O(nlog(n))  
Average Cases : O(nlog(n))  
Worst Cases :O(n^2)

컬렉션(List, Set..)을 정렬할 땐 Collections.sort() 사용
Collections.sort()는 삽입정렬과 합병정렬을 결합한 TimSort 방식을 사용하며 평균과 최악의 시간 복잡도는 O(nlog(n))으로 Arrays.sort()보다 빠르다.