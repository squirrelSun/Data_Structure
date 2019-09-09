package NodeBinaryTree;

public class TreeNode {

	int value;//节点值
	TreeNode leftNode;//左节点
	TreeNode rightNode;//右节点
	
	public TreeNode(int value) {
		this.value=value;
	}
	
	public void setleftNode(TreeNode leftNode) {
		this.leftNode=leftNode;
	}
	
	public void setrightNode(TreeNode rightNode) {
		this.rightNode=rightNode;
	}

	//前序遍历
	public void frontShow() {
		System.out.println(value);
		if (leftNode!=null) {
			leftNode.frontShow();
		}
		if (rightNode!=null) {
			rightNode.frontShow();
		}
	}

	//中序遍历
	public void midShow() {
		if (leftNode!=null) {
			leftNode.midShow();
		}
		System.out.println(value);
		if (rightNode!=null) {
			rightNode.midShow();
		}
		
	}

	//后序遍历
	public void afterShow() {
		if (leftNode!=null) {
			leftNode.afterShow();
		}
		if (rightNode!=null) {
			rightNode.afterShow();
		}
		System.out.println(value);
	}

	//前序查找
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

	//中序查找
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

	//后序查找
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

	//删除子树
	public void delete(int i) {
		TreeNode parent=this;
		//左树
		if (parent.leftNode!=null && parent.leftNode.value==i) {
			parent.leftNode=null;
			return;
		}
		//右树
		if (parent.rightNode!=null && parent.rightNode.value==i) {
			parent.rightNode=null;
			return;
		}
		//递归检查
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
