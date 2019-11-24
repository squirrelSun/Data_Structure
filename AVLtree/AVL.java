package AVLtree;

public class AVL {

	Node root;
	
	//���������������ӽڵ�
	public void add (Node node) {
		if (root == null) {		//�ǿ���
			root=node;
		}else { 	//�ǿ���
			root.add(node);
		}	
	}
	
	//�������������
	public void midShow() {
		if (root != null) {
			root.midShow(root);
		}
	}
	
	//���ҽڵ�
	public Node search(int value) {
		if (root == null) {
			return null;
		}else {
			return root.search(value);
		}
	}
	
	//ɾ���ڵ�
	public  void delete(int value) {
		if (root == null) {
			return;
		}else {
			//�ҵ��ýڵ�
			Node target=search(value);
			if (target == null) {
				return;
			}
			//�ҵ����ڵ�
			Node father=searchFather(value);
			if (target.leftNode==null && target.rightNode==null) {		//ɾ��Ҷ�ӽڵ�
				if (father.leftNode.value == value) {		//ɾ��������ڵ�
					father.leftNode=null;
				}else {		//ɾ�������ҽڵ�
					father.rightNode=null;
				}
			}else if (target.leftNode!=null && target.rightNode!=null) {	//ɾ���Ľڵ��������ӽڵ�
				//ɾ���ýڵ���������ֵ��С�Ľڵ㣬����ȡ���ýڵ��ֵ
				int min=deletMin(target.rightNode);
				//�滻Ŀ��ڵ��ֵ
				target.value=min;
			}else {		//ɾ���Ľڵ�ֻ��һ���ӽڵ�
				if (target.leftNode != null) {	//����ڵ�
					if (target.leftNode.value == value) {
						father.leftNode=target.leftNode;
					}else {
						father.rightNode=target.leftNode;
					}
				}else {		//�����ӽڵ�
					father.rightNode=target.rightNode;
				}
			}
		}
	}
	
	//ɾ��������С�Ľڵ�
	private int deletMin(Node node) {
		Node target=node;
		while (node.leftNode !=null) {
			target=node.leftNode;
		}
		//�������ڵ����ӽڵ�
		delete(target.value);
		return target.value;
	}

	//���Ҹ��ڵ�
	public Node searchFather(int value) {
		if (root == null) {
			return null;
		}else {
			return root.searchFather(value);
		}
	}
}
