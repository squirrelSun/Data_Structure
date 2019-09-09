package NodeBinaryTree;

public class BinaryTree {

	TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public void frontShow() {
		if (root!=null) {
			root.frontShow();
		}
	}

	public void midShow() {
		if (root!=null) {
			root.midShow();
		}
	}

	public void afterShow() {
		if (root!=null) {
			root.afterShow();
		}
	}

	public TreeNode frontSearch(int i) {
		TreeNode ads=root.frontSearch(i);
		return ads;
	}

	public TreeNode midSearch(int i) {
		TreeNode ads=root.midSearch(i);
		return ads;
	}

	public TreeNode afterSearch(int i) {
		TreeNode ads=root.afterSearch(i);
		return ads;
	}

	public void delete(int i) {
		if (root.value==i) {
			root=null;
		}else {
			root.delete(i);
		}
		
	}
	
}
