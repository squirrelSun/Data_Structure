package ArrayBinaryTree;

public class BinaryTree {
	
	int[] data;
	
	public BinaryTree(int[] data) {
		this.data=data;
	}
	
	//前序遍历
	public void frontShow() {
		frontShow(0);
	}
	public void frontShow(int index) {
		if (data==null || data.length==0) {
			return;
		}
		System.out.println(data[index]);//当前节点
		if (2*index+1<data.length) {	//左子树
			frontShow(2*index+1);
		}
		if (2*index+2<data.length) {	//右子树
			frontShow(2*index+2);
		}
	}

	//中序遍历
	public void midShow() {
		midShow(0);
	}
	public void midShow(int index) {
		if (data==null || data.length==0) {
			return;
		}
		if (2*index+1<data.length) {	//左子树
			midShow(2*index+1);
		}
		System.out.println(data[index]);//当前节点
		if (2*index+2<data.length) {	//右子树
			midShow(2*index+2);
		}
	}

	//后序遍历
	public void afterShow() {
		afterShow(0);
	}
	public void afterShow(int index) {
		if (data==null || data.length==0) {
			return;
		}
		if (2*index+1<data.length) {	//左子树
			afterShow(2*index+1);
		}
		if (2*index+2<data.length) {	//右子树
			afterShow(2*index+2);
		}
		System.out.println(data[index]);//当前节点
	}
}
