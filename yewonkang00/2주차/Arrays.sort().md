## 📚 Arrays.sort()

◾ 자바에서 java.util.Arrays 클래스의 sort()메소드를 이용하여 배열을 오름차순으로 정렬할 수 있다. <br>

◾ <b>java.util.Arrays import</b>하여 사용

```
ex)

// Array
int[] intArr = new int[] {1,3,5,2,4};
double[] doubleArr = new double[] {1.1, 3.3, 5.5, 2.2, 4.4};
String[] stringArr = new String[] {"A", "C", "F", "E", "D"};

// Sort
Arrays.sort(intArr);
Arrays.sort(doubleArr);
Arrays.sort(stringArr);


// Result
intArr : 1 2 3 4 5
doubleArr : 1.1 2.2 3.3 4.4 5.5
stringArr : A B C D E
```
<br/>

### 📔 정렬 알고리즘 (Java 8 기준)

1️⃣ <b>Primitive(기본형) type의 배열인 경우</b>

<b>DualPivotQuickSort</b>
```
public static void sort(int[] a) {
   DualPivotQuicksort.sort(a, 0, a.length-1, null, 0, 0);
}
```
▪️피벗 2개를 사용하여 정렬을 수행

▪️최악의 경우 시간 복잡도 O(NlogN)

<br/>

2️⃣ <b>Reference(참조) type의 배열인 경우</b>

<b>TimSort</b>
```
public static void sort(Object[] a) {
   if (LegacyMergeSort.userRequested)
       legacyMergeSort(a);
   else
       ComparableTimSort.sort(a, 0, a.length, null, 0, 0);
}

// 아래 코드는 제거될 예정. ComparableTimSort 클래스의 sort() 메서드를 사용한다고 생각하면됨
private static void legacyMergeSort(Object[] a) {
    Object[] aux = a.clone();
    mergeSort(aux, a, 0, a.length, 0);
}
```
▪️삽입 정렬과 병합 정렬을 섞어서 정렬을 수행

▪️최악의 경우 시간 복잡도 O(NlogN)

<br/>

### 🧮 Collections.sort()

▪️컬렉션(List, Set..)을 정렬할 땐 Collections.sort() 사용 <br/>

▪️<b>java.util.Collections</b> import하여 사용
```
int[] arr = {3,4,5,2,1};

// int 배열을 List로 변환
List<Integer> intList = Arrays.asList(arr);

// 오름차순 정렬
Collections.sort(intList);

// 내림차순 정렬
Collections.sort(intList, Collections.reverseOrder());
```

▪️Collections.sort()에서는 List 객체를 Object 배열로 변환하여 Arrays.sort()를 실행하여 정렬을 수행하고
Arrays.sort() 내부를 살펴보면 TimSort.sort()를 실행한다. 따라서 Arrays.sort()보다 빠르다.
