package BinarySortTree;

//顺序二叉树
public class BST_demo {
	
	public static void main(String[] args) {
		int[] arr=new int[] {7,3,10,12,5,1,9};
		//创建排序树
		binarySortTree bst=new binarySortTree();
		//循环添加
		for (int i:arr) {
			bst.add(new Node(i));
		}
		//遍历打印
		bst.midShow();
		//查找节点
		Node node1=bst.search(10);
		System.out.println(node1);
		Node node2=bst.search(20);
		System.out.println(node2);
		//查找父节点
		Node node3=bst.searchFather(1);
		System.out.println(node3);
		//删除节点
		bst.delete(12);//叶子节点
		bst.delete(10);//只有一个叶子节点
		bst.delete(3);//有两个子节点
		bst.midShow();
	}
	
}
