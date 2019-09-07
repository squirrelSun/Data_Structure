package BinarySearch;

public class BinarySearchDemo {
//二分法查找
	public static void main(String[] args) {
		//目标数组（有序排列）
		int[] arr=new int[] {1,2,3,4,5,6,7};
		//查找元素
		int num=9;
		
		//记录位置
		int begin=0;
		int end=arr.length-1;
		int mid;
		//记录位置
		int index=-2;
		//循环查找
		while(true) {
			mid=(begin+end)/2;
			//是否查找到
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
		//有元素打印具体位置，无元素返回-1
	}
	
}
