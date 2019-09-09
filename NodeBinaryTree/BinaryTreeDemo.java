package NodeBinaryTree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		//创建树
		BinaryTree binTree=new BinaryTree();
		TreeNode root=new TreeNode(1);//创建根节点
		binTree.setRoot(root);//根节点赋值给树
		//创建子节点
		TreeNode rootL=new TreeNode(2);
		root.setleftNode(rootL);
		TreeNode rootR=new TreeNode(3);
		root.setrightNode(rootR);
		//二层节点
		rootL.setleftNode(new TreeNode(4));
		rootL.setrightNode(new TreeNode(5));
		rootR.setleftNode(new TreeNode(6));
		rootR.setrightNode(new TreeNode(7));
		
		binTree.frontShow();//前序遍历
		System.out.println("*********");
		binTree.midShow();//中序遍历
		System.out.println("*********");
		binTree.afterShow();//后序遍历
		
		System.out.println("------------------");
		
		TreeNode result1=binTree.frontSearch(5);//前序查找
		System.out.println(result1);
		TreeNode result2=binTree.midSearch(7);//中序查找
		System.out.println(result2);
		TreeNode result3=binTree.afterSearch(9);//后序查找
		System.out.println(result3);
		
		//删除子树
		System.out.println("------------------");
		binTree.delete(4);
		binTree.afterShow();
	}
	
}
