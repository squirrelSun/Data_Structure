package Recursive;
//递归实现斐波那契数列
public class TestFibonacci {
	//1 1 2 3 5 8 13 ...
	public static void main(String[] args) {
		int a=data(7);
		System.out.println(a);
	}
	
	public static int data(int index) {
		if (index==1 || index==2) {
			return 1;
		}else {
			int num = data(index-1)+data(index-2);
			return num;
		}
	}
}
