package Sort;

import java.util.Arrays;

//��������
public class RadixSort {

	public static void main(String[] args) {
		int[] arr=new int[] {59,8,48,15,26,0,8,9,5,154,485,982,489,22,15,1111};

		System.out.println(Arrays.toString(arr));
		radixSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void radixSort(int[] arr) {
		//��������������
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if (arr[i]>max) {
				max=arr[i];
			}
		}
		//�����������λ��
		int maxLength=(max+"").length();
		//����λ����������
		for (int i=0,n=1; i<maxLength ;i++,n*=10) {
			//��ʼ����ά���飬Ĭ��ֵ��Ϊ-1
			int[][] num=new int[10][arr.length];
			//�����ά����
			int[] counts=new int[10];
			for (int j=0; j<arr.length; j++) {
				int ys=arr[j]/n%10;
				num[ys][counts[ys]]=arr[j];
				counts[ys]++;
			}
			//�Ӷ�ά����ȡ��
			int index=0;
			for (int k=0; k<counts.length; k++) {
				if (counts[k]!=0) {
					for (int m=0;m<counts[k];m++) {
						arr[index]=num[k][m];
						index++;
					}
				}
			}
		}
		
	}
	
}
