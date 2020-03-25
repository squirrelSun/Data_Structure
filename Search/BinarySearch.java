package Search;

//二分法查找
//数组必须为有序数组
public class BinarySearch {
	
	public static void main(String[] args) {
		// 目标数组（有序排列）
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		// 查找元素
		int num = 0;

		// 记录位置
		int begin = 0;
		int end = arr.length - 1;
		int mid;
		// 循环查找
		while (true) {
			mid = begin + (end - begin) / 2;
			// 是否查找到
			if (arr[mid] == num) {
				System.out.println("index=" + mid);
				return ;
			} else {
				if (arr[mid] > num) {
					end = mid - 1;
				} else {
					begin = mid + 1;
				}
			}
			if (end < begin) {
				break;
			}
		}
		System.out.println("index=" + -1);
	}

}
