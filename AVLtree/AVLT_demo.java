package AVLtree;

//ƽ�������
public class AVLT_demo {
	
	public static void main(String[] args) {
		int[] arr=new int[] {8,9,6,7,5,4};
		//����ƽ����
		AVL bst=new AVL();
		//ѭ�����
		for (int i:arr) {
			bst.add(new Node(i));
		}
		//������ӡ
//		bst.midShow();
		//�鿴�߶�
		System.out.println(bst.root.heigh());
		System.out.println(bst.root.value);
	
	}
	
}
