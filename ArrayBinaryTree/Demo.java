package ArrayBinaryTree;

public class Demo {
	public static void main(String[] args) {
		int[] data=new int[] {1,2,3,4,5,6,7};
		BinaryTree tree=new BinaryTree(data);
		
		tree.frontShow();//前序遍历
		System.out.println("*******");
		tree.midShow();//中序遍历
		System.out.println("*******");
		tree.afterShow();//后序遍历
	}
}
