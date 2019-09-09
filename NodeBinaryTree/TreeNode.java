package NodeBinaryTree;

public class TreeNode {

	int value;//�ڵ�ֵ
	TreeNode leftNode;//��ڵ�
	TreeNode rightNode;//�ҽڵ�
	
	public TreeNode(int value) {
		this.value=value;
	}
	
	public void setleftNode(TreeNode leftNode) {
		this.leftNode=leftNode;
	}
	
	public void setrightNode(TreeNode rightNode) {
		this.rightNode=rightNode;
	}

	//ǰ�����
	public void frontShow() {
		System.out.println(value);
		if (leftNode!=null) {
			leftNode.frontShow();
		}
		if (rightNode!=null) {
			rightNode.frontShow();
		}
	}

	//�������
	public void midShow() {
		if (leftNode!=null) {
			leftNode.midShow();
		}
		System.out.println(value);
		if (rightNode!=null) {
			rightNode.midShow();
		}
		
	}

	//�������
	public void afterShow() {
		if (leftNode!=null) {
			leftNode.afterShow();
		}
		if (rightNode!=null) {
			rightNode.afterShow();
		}
		System.out.println(value);
	}

	//ǰ�����
	public TreeNode frontSearch(int i) {
		TreeNode change=null;
		if (this.value==i) {
			return this;
		}else {
			if (leftNode!=null) {
				change=leftNode.frontSearch(i);
			}
			if (change!=null) {
				return change;
			}
			if (rightNode!=null) {
				change=rightNode.frontSearch(i);
			}
		}
		return change;
	}

	//�������
	public TreeNode midSearch(int i) {
		TreeNode change=null;
		if (leftNode!=null) {
			change=leftNode.midSearch(i);
		}
		if (change!=null) {
				return change;
		}
		if (this.value==i) {
			return this;
		}
		if (rightNode!=null) {
			change=rightNode.midSearch(i);
		}
		return change;
	}

	//�������
	public TreeNode afterSearch(int i) {
		TreeNode change=null;
		if (leftNode!=null) {
			change=leftNode.afterSearch(i);
		}
		if (change!=null) {
				return change;
		}
		if (rightNode!=null) {
			change=rightNode.afterSearch(i);
		}
		if (change!=null) {
			return change;
		}
		if (this.value==i) {
			return this;
		}
		return change;
	}

	//ɾ������
	public void delete(int i) {
		TreeNode parent=this;
		//����
		if (parent.leftNode!=null && parent.leftNode.value==i) {
			parent.leftNode=null;
			return;
		}
		//����
		if (parent.rightNode!=null && parent.rightNode.value==i) {
			parent.rightNode=null;
			return;
		}
		//�ݹ���
		parent=leftNode;
		if (parent!=null) {
			parent.delete(i);
		}
		parent=rightNode;
		if (parent!=null) {
			parent.delete(i);
		}
	}
}
