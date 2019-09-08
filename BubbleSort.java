package Sort;

import java.util.Arrays;

//Ã°ÅİÅÅĞò
public class BubbleSort {

	public static void main(String[] args) {
		//´ıÅÅĞòÊı×é
		int[] arr=new int[] {55,97,54,14,7,0,9,99};
		
		System.out.println(Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	//ÅÅĞòÊµÏÖ
	public static void bubbleSort(int[] arr) {
		for (int i=0;i<arr.length-1;i++) {
			for (int j=0;j<arr.length-i-1;j++) {
				if (arr[j]>arr[j+1]) {
					int change=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=change;
				}
			}
		}
	}
	
}
