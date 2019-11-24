package BinarySortTree;

public class Node {

	int value;
	Node leftNode;
	Node rightNode;
	
	public Node(int value) {
		this.value=value;
	}

	//��������ӽڵ�
	public void add(Node node) {
		if (node == null) {
			return;
		}
		//�жϴ���ڵ�ֵ�뵱ǰ�ڵ�������ֵ�Ĵ�С
		if (node.value < this.value) {	//���ֵ��С
			if (this.leftNode == null) {	//��ڵ�Ϊ��
				this.leftNode=node;
			}else { 	// �ǿ�
				this.leftNode.add(node);
			}
		}else {
			if (this.rightNode == null) {	//�ҽڵ�Ϊ��
				this.rightNode=node;
			}else { 	// �ǿ�
				this.rightNode.add(node);
			}
		}
	}

	//�����������������
	public void midShow(Node node) {
		if (node == null) {
			return;
		}
		midShow(node.leftNode);
		System.out.println(node.value);
		midShow(node.rightNode);
	}

	//�ڵ����
	public Node search(int value) {
		if (this.value == value){
			return this;
		}else if (value < this.value) {
			if (leftNode == null) {
				return null;
			}
			return leftNode.search(value);
		}else {
			if (rightNode == null) {
				return null;
			}
			return rightNode.search(value);
		}
	}

	//���Ҹ��ڵ�
	public Node searchFather(int value) {
		if ((this.leftNode!=null && this.leftNode.value==value) || (this.rightNode!=null && this.rightNode.value==value)) {
			return this;
		}else {
			if (this.value>value && this.leftNode!=null) {
				return this.leftNode.searchFather(value);
			}else if (this.value<value && this.rightNode!=null){
				return this.rightNode.searchFather(value);
			}
			return null;
		}
	} 
	
}
