package BinarySearch;

public class BinarySearchDemo {
//���ַ�����
	public static void main(String[] args) {
		//Ŀ�����飨�������У�
		int[] arr=new int[] {1,2,3,4,5,6,7};
		//����Ԫ��
		int num=9;
		
		//��¼λ��
		int begin=0;
		int end=arr.length-1;
		int mid;
		//��¼λ��
		int index=-2;
		//ѭ������
		while(true) {
			mid=(begin+end)/2;
			//�Ƿ���ҵ�
			if(arr[mid]==num) {
				index=mid;
				break;
			}else {
				if(arr[mid]>num) {
					end=mid-1;
				}else {
					begin=mid+1;
				}
			}
			if (end<begin) {
				break;
			}
		}
		System.out.println("index="+(index+1));
		//��Ԫ�ش�ӡ����λ�ã���Ԫ�ط���-1
	}
	
}
