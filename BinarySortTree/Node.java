package BinarySortTree;

public class Node {

	int value;
	Node leftNode;
	Node rightNode;
	
	public Node(int value) {
		this.value=value;
	}

	//向子树添加节点
	public void add(Node node) {
		if (node == null) {
			return;
		}
		//判断传入节点值与当前节点子树的值的大小
		if (node.value < this.value) {	//添加值更小
			if (this.leftNode == null) {	//左节点为空
				this.leftNode=node;
			}else { 	// 非空
				this.leftNode.add(node);
			}
		}else {
			if (this.rightNode == null) {	//右节点为空
				this.rightNode=node;
			}else { 	// 非空
				this.rightNode.add(node);
			}
		}
	}

	//中序遍历二叉排序树
	public void midShow(Node node) {
		if (node == null) {
			return;
		}
		midShow(node.leftNode);
		System.out.println(node.value);
		midShow(node.rightNode);
	}

	//节点查找
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

	//查找父节点
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
