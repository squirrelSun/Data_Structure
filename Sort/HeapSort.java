package Sort;

import java.util.Arrays;

//堆排序
public class HeapSort {

	public static void main(String[] args) {
		int[] arr=new int[] {59,8,48,15,26,0,8,9,5,154,485,982,489,22,15,1111};

		System.out.println(Arrays.toString(arr));
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void heapSort(int[] arr) {
		int start=(arr.length-1)/2;//开始
		//数组转换为大顶堆
		for (int i=start;i>=0;i--) {
			maxHeap(arr,arr.length,i);
		}
		//交换排序
		for (int i=arr.length-1;i>0;i--) {
			int change=arr[0];
			arr[0]=arr[i];
			arr[i]=change;
			maxHeap(arr,i,0);
		}
		
	}
	
	public static void maxHeap(int[] arr,int size,int index) {
		//左子节点
		int leftNode=2*index+1;
		//右子节点
		int rightNode=2*index+2;
		//找到最大节点
		int max=index;
		if (leftNode<size && arr[leftNode]>arr[max]) {
			max=leftNode;
		}
		if (rightNode<size && arr[rightNode]>arr[max]) {
			max=rightNode;
		}
		//交换
		if (max!=index) {
			int change=arr[index];
			arr[index]=arr[max];
			arr[max]=change;
			//重新调整堆
			maxHeap(arr,size,max);
		}
		
	}
	
}
