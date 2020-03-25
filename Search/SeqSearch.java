package Search;

//线性查找
//数组可以是无序数组
public class SeqSearch {

	public static void main(String[] args) {
		// 目标数组（有序排列）
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		// 查找元素
		int num = 0;
		
		for (int i = 0 ; i < arr.length ; i++) {
			if (arr[i] == num) {
				System.out.println("index=" + i);
				return ;
			}
		}
		System.out.println("index=" + -1);
	}

}
