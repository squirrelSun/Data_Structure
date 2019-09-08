package Sort;

import java.util.Arrays;

//快速排序
public class QuickSort {

	public static void main(String[] args) {
		int[] arr=new int[] {55,97,54,14,7,0,9,99};
		
		System.out.println(Arrays.toString(arr));
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	
	public static void quickSort(int[] arr,int start ,int end) {
		if (start<end) {
			//定义比较数
			int num=arr[start];
			//待排序边界下标
			int low=start;
			int high=end;
			//循环与标准数比较分类
			while(low<high) {
				//右边比标准数大
				while (low<high && num<=arr[high]) {
					high--;
				}
				//右边的替换左边的
				arr[low]=arr[high];
				//左边的比标准数小
				while (low<high && arr[low]<=num) {
					low++;
				}
				//左边的替换右边的
				arr[high]=arr[low];
			}
			//插入标准数
			arr[high]=num;
			//标准数左边的递归
			quickSort(arr, start, low);
			//标准数右边的递归
			quickSort(arr, low+1, end);
		} 
	}	
}
