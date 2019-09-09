package NodeBinaryTree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		//������
		BinaryTree binTree=new BinaryTree();
		TreeNode root=new TreeNode(1);//�������ڵ�
		binTree.setRoot(root);//���ڵ㸳ֵ����
		//�����ӽڵ�
		TreeNode rootL=new TreeNode(2);
		root.setleftNode(rootL);
		TreeNode rootR=new TreeNode(3);
		root.setrightNode(rootR);
		//����ڵ�
		rootL.setleftNode(new TreeNode(4));
		rootL.setrightNode(new TreeNode(5));
		rootR.setleftNode(new TreeNode(6));
		rootR.setrightNode(new TreeNode(7));
		
		binTree.frontShow();//ǰ�����
		System.out.println("*********");
		binTree.midShow();//�������
		System.out.println("*********");
		binTree.afterShow();//�������
		
		System.out.println("------------------");
		
		TreeNode result1=binTree.frontSearch(5);//ǰ�����
		System.out.println(result1);
		TreeNode result2=binTree.midSearch(7);//�������
		System.out.println(result2);
		TreeNode result3=binTree.afterSearch(9);//�������
		System.out.println(result3);
		
		//ɾ������
		System.out.println("------------------");
		binTree.delete(4);
		binTree.afterShow();
	}
	
}
