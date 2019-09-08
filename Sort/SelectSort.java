package Sort;

import java.util.Arrays;

//—°‘Ò≈≈–Ú
public class SelectSort {

	public static void main(String[] args) {
		int[] arr=new int[] {55,97,54,14,7,0,9,99};
		
		System.out.println(Arrays.toString(arr));
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void selectSort(int[] arr) {
		for (int i=0; i<arr.length-1; i++) {
			int small=arr[i];
			int index=i;
			for (int j=i+1; j<arr.length; j++) {
				if (small>arr[j]) {
					small=arr[j];
					index=j;
				}
			}
			if (index!=i) {
				int change=arr[i];
				arr[i]=arr[index];
				arr[index]=change;
			}
		}
	}
}
