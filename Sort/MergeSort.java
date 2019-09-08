package Sort;

import java.util.Arrays;

//归并排序
public class MergeSort {
	public static void main(String[] args) {
		int[] arr=new int[] {55,97,54,14,7,0,9,99};

		System.out.println(Arrays.toString(arr));
		mergeSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int[] arr,int low,int high) {
		int mid=(low+high)/2;
		if (low<high) {
			mergeSort(arr,low,mid);
			mergeSort(arr, mid+1, high);
			merge(arr,low,mid,high);
		}
	}
	
	public static void merge(int[] arr,int low,int mid,int high) {
		int[] temp=new int[high-low+1];//存放归并后的临时数组
		int i=low;//前数组的遍历 下标
		int j=mid+1;//后数组的遍历下标
		//遍历两个数组，比较，放入临时数组
		int index=0;
		while(i<=mid && j<=high) {
			if (arr[i]<=arr[j]) {
				temp[index]=arr[i];
				i++;
			}else {
				temp[index]=arr[j];
				j++;
			}
			index++;
		}
		//多余数据直接存放
		while(j<=high) {
			temp[index]=arr[j];
			j++;
			index++;
		}
		while(i<=mid) {
			temp[index]=arr[i];
			i++;
			index++;
		}
		for (int k=0; k<temp.length; k++) {
			arr[k+low]=temp[k];
		}
	}
}
