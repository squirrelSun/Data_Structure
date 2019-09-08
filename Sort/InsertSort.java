package Sort;

import java.util.Arrays;

//≤Â»Î≈≈–Ú
public class InsertSort {

	public static void main(String[] args) {
		int[] arr=new int[] {55,97,54,14,7,0,9,99};
		
		System.out.println(Arrays.toString(arr));
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void insertSort(int[] arr) {
		for (int i=1 ;i<arr.length ;i++) {
			for (int j=0 ;j<i ;j++) {
				if (arr[j]>arr[i]) {
					int change=arr[j];
					arr[j]=arr[i];
					arr[i]=change;
				}
			}
		}
	}
}
