package Sort;

import java.util.Arrays;

//�鲢����
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
		int[] temp=new int[high-low+1];//��Ź鲢�����ʱ����
		int i=low;//ǰ����ı��� �±�
		int j=mid+1;//������ı����±�
		//�����������飬�Ƚϣ�������ʱ����
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
		//��������ֱ�Ӵ��
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
