package BinarySortTree;

//˳�������
public class BST_demo {
	
	public static void main(String[] args) {
		int[] arr=new int[] {7,3,10,12,5,1,9};
		//����������
		binarySortTree bst=new binarySortTree();
		//ѭ�����
		for (int i:arr) {
			bst.add(new Node(i));
		}
		//������ӡ
		bst.midShow();
		//���ҽڵ�
		Node node1=bst.search(10);
		System.out.println(node1);
		Node node2=bst.search(20);
		System.out.println(node2);
		//���Ҹ��ڵ�
		Node node3=bst.searchFather(1);
		System.out.println(node3);
		//ɾ���ڵ�
		bst.delete(12);//Ҷ�ӽڵ�
		bst.delete(10);//ֻ��һ��Ҷ�ӽڵ�
		bst.delete(3);//�������ӽڵ�
		bst.midShow();
	}
	
}
