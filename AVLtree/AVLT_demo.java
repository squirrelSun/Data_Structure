package AVLtree;

//平衡二叉树
public class AVLT_demo {
	
	public static void main(String[] args) {
		int[] arr=new int[] {8,9,6,7,5,4};
		//创建平衡树
		AVL bst=new AVL();
		//循环添加
		for (int i:arr) {
			bst.add(new Node(i));
		}
		//遍历打印
//		bst.midShow();
		//查看高度
		System.out.println(bst.root.heigh());
		System.out.println(bst.root.value);
	
	}
	
}
