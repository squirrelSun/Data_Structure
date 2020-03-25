package Search;

//差值查找
//数组必须是有序
public class InsertValueSearce {

	public static void main(String[] args) {
		// 目标数组
		int[] arr = new int[] { 114, 252, 353, 454, 555, 866, 977 };
		// 查找元素
		int num = 114;

		// 记录位置
		int begin = 0;
		int end = arr.length - 1;
		int mid;
		// 循环查找
		while (true) {
			
			mid = begin + (end - begin) * (num - arr[begin]) / (arr[end] - arr[begin]);
			
			// 是否查找到
			if (arr[mid] == num) {
				System.out.println("index=" + mid);
				return;
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
