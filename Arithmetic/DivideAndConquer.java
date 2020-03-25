package Arithmetic;
//分治算法实现汉诺塔
public class DivideAndConquer {

	public static void main(String[] args) {
		Hanoitower(5 , "A" , "B" , "C");
	}
	/**
	 * 
	 * @param num	需要移动的盘
	 * @param a	所在位置
	 * @param b	过渡位置
	 * @param c	目标位置
	 */
	public static void Hanoitower(int num , String a , String b , String c) {
		if (num == 1)
			System.out.println("第1个盘从" + a +"移动到" + c);
		else {
			//将所有盘视为只有最底层的盘和其他盘
			Hanoitower(num - 1, a, c, b);	//将最上方的盘移动到b
			System.out.println("第" + num + "个盘从" + a +"移动到" + c);	//将最下方的盘移动到c
			Hanoitower(num - 1, b, a, c);	//将b上的剩余盘移动到c
		}
	}
	
}
