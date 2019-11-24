package AVLtree;

public class Node {

	int value;
	Node leftNode;
	Node rightNode;
	
	public Node(int value) {
		this.value=value;
	}

	//���ĸ߶�
	public int heigh() {
		return Math.max(leftNode==null ? 0 : leftNode.heigh(), rightNode==null ? 0 : rightNode.heigh())+1;
	}
	
	//��ȡ�������ĸ߶�
	public int leftHeight() {
		if (this.leftNode == null) {
			return 0;
		}
		return this.leftNode.heigh();
	}
	
	//��ȡ�������ĸ߶�
	public int rightHeight() {
		if (this.rightNode == null) {
			return 0;
		}
		return this.rightNode.heigh();
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
		//��ѯ�Ƿ�ƽ��
		if (this.leftHeight()-this.rightHeight()>=2) {		//����ת
			if (this.leftNode!=null && this.leftNode.leftHeight()<this.leftNode.rightHeight()) {	//˫��ת
				this.leftNode.leftRotate();
				this.rightRotate();
			}else {		//����ת
				rightRotate();
			}
		}
		if (this.leftHeight()-this.rightHeight()<=-2) {		//����ת
			if (this.rightNode!=null && this.rightNode.rightHeight()<this.rightNode.leftHeight()) {		//˫��ת
				this.rightNode.rightRotate();
				this.leftRotate();
			}else {		//����ת
				leftRotate();	
			}
		}
	}

	
	
	//����ת
	private void leftRotate() {
		//�����½ڵ㣬ֵΪ��ǰ�ڵ��ֵ
		Node newNode=new Node(value);
		//��ǰ�ڵ��������Ϊ�½ڵ��������
		newNode.leftNode=this.leftNode;
		//�½ڵ��������Ϊ��ǰ�ڵ����������������
		newNode.rightNode=this.rightNode.leftNode;
		//��ǰ�ڵ��ֵ��Ϊ�ҽڵ��ֵ
		this.value=this.rightNode.value;
		//��ǰ�ڵ����������Ϊ��ǰ�ڵ����������������
		this.rightNode=this.rightNode.rightNode;
		//�½ڵ�����Ϊ��ǰ�ڵ����ڵ�
		this.leftNode=newNode;
	}

	//����ת
	private void rightRotate() {
		//�����½ڵ㣬ֵΪ��ǰ�ڵ��ֵ
		Node newNode=new Node(value);
		//��ǰ�ڵ��������Ϊ�½ڵ��������
		newNode.rightNode=this.rightNode;
		//�½ڵ��������Ϊ��ǰ�ڵ����������������
		newNode.leftNode=this.leftNode.rightNode;
		//��ǰ�ڵ��ֵ��Ϊ��ڵ��ֵ
		this.value=this.leftNode.value;
		//��ǰ�ڵ����������Ϊ��ǰ�ڵ����������������
		this.leftNode=this.leftNode.leftNode;
		//�½ڵ�����Ϊ��ǰ�ڵ���ҽڵ�
		this.rightNode=newNode;
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
