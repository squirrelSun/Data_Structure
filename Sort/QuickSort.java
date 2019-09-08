package Sort;

import java.util.Arrays;

//��������
public class QuickSort {

	public static void main(String[] args) {
		int[] arr=new int[] {55,97,54,14,7,0,9,99};
		
		System.out.println(Arrays.toString(arr));
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	
	public static void quickSort(int[] arr,int start ,int end) {
		if (start<end) {
			//����Ƚ���
			int num=arr[start];
			//������߽��±�
			int low=start;
			int high=end;
			//ѭ�����׼���ȽϷ���
			while(low<high) {
				//�ұ߱ȱ�׼����
				while (low<high && num<=arr[high]) {
					high--;
				}
				//�ұߵ��滻��ߵ�
				arr[low]=arr[high];
				//��ߵıȱ�׼��С
				while (low<high && arr[low]<=num) {
					low++;
				}
				//��ߵ��滻�ұߵ�
				arr[high]=arr[low];
			}
			//�����׼��
			arr[high]=num;
			//��׼����ߵĵݹ�
			quickSort(arr, start, low);
			//��׼���ұߵĵݹ�
			quickSort(arr, low+1, end);
		} 
	}	
}
