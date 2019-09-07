package Recursive;
//递归实现汉诺塔问题
public class TestHanoi {

	public static void main(String[] args) {
		hanoi(5,'a','b','c');
	}
	/**
	 * @param i	环总数
	 * @param from	起始位置
	 * @param in	过渡位置
	 * @param to	目标位置
	 * 无论有多少个盘子，均可视为只有两个(最下面，其他)
	 */
	public static void hanoi(int i,char from,char in,char to) {
		if (i==1) {
			System.out.println("第"+i+"个盘子从"+from+"移到"+to);
		}else {
			hanoi(i-1,from,to,in);//除最后一个外均移动到过渡位置
			System.out.println("第"+i+"个盘子从"+from+"移到"+to);
			hanoi(i-1,in,from,to);//过渡位置所有元素移动至目标位置
		}
	}
	
}
