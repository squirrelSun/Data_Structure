package Search;

import java.util.Arrays;

//斐波那契查找
//数组需有序
public class FibonacciSearch {

	private static int maxSize = 20;

	public static void main(String[] args) {
		// 目标数组
		int[] arr = new int[] { 114, 252, 353, 454, 555, 866, 977 };
		// 查找元素
		int num = 114;

		int begin = 0;
		int end = arr.length - 1;
		int index = 0; // 表示斐波那契分割数值的下标
		int mid = 0; // 存放mid值
		int f[] = fib(); // 获取到斐波那契数列
		// 获取到斐波那契分割数值的下标
		while (end > f[index] - 1) {
			index++;
		}
		// 因为 f[k] 值 可能大于 a 的 长度，因此我们需要使用Arrays类，构造一个新的数组，并指向temp[]
		int[] temp = Arrays.copyOf(arr, f[index]);// 不足的部分会使用0填充
		// 用a数组最后的数填充 temp
		for (int i = end + 1; i < temp.length; i++) {
			temp[i] = arr[end];
		}
		// 循环查找
		while (begin <= end) {
			mid = begin + f[index - 1] - 1;
			if (num < temp[mid]) { // 向左查找
				end = mid - 1;
				index--;
			} else if (num > temp[mid]) { // 向右查找
				begin = mid + 1;
				index -= 2;
			} else { // 找到
				if (mid <= end)
					System.out.println("index=" + mid);
				else
					System.out.println("index=" + end);
				return;
			}
		}
		System.out.println("index=" + -1);
	}

	// 构建斐波那契数列(非递归)
	private static int[] fib() {
		int[] f = new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < f.length; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f;
	}
}
