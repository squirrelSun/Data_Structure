package ArrayBinaryTree;

public class Demo {
	public static void main(String[] args) {
		int[] data=new int[] {1,2,3,4,5,6,7};
		BinaryTree tree=new BinaryTree(data);
		
		tree.frontShow();//ǰ�����
		System.out.println("*******");
		tree.midShow();//�������
		System.out.println("*******");
		tree.afterShow();//�������
	}
}
