package Sort;

import java.util.Arrays;

//希尔排序
public class ShellSort {

	public static void main(String[] args) {
		int[] arr=new int[] {55,97,54,14,7,0,9,99};
		
		System.out.println(Arrays.toString(arr));
		shellSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void shellSort(int[] arr) {
		//步长
		for (int h=arr.length/2 ;h>0 ;h=h/2) {
			//遍历元素
			for (int i=h ;i<arr.length ;i++) {
				//遍历本组元素
				for (int j=i-h ;j>=0 ;j-=h) {
					if (arr[j]>arr[j+h]) {
						int change=arr[j];
						arr[j]=arr[j+h];
						arr[j+h]=change;
					}
				}
			}
		}
	}
}
