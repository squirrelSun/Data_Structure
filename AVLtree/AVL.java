package AVLtree;

public class AVL {

	Node root;
	
	//向二叉排序树中添加节点
	public void add (Node node) {
		if (root == null) {		//是空树
			root=node;
		}else { 	//非空树
			root.add(node);
		}	
	}
	
	//中序遍历二叉树
	public void midShow() {
		if (root != null) {
			root.midShow(root);
		}
	}
	
	//查找节点
	public Node search(int value) {
		if (root == null) {
			return null;
		}else {
			return root.search(value);
		}
	}
	
	//删除节点
	public  void delete(int value) {
		if (root == null) {
			return;
		}else {
			//找到该节点
			Node target=search(value);
			if (target == null) {
				return;
			}
			//找到父节点
			Node father=searchFather(value);
			if (target.leftNode==null && target.rightNode==null) {		//删除叶子节点
				if (father.leftNode.value == value) {		//删除的是左节点
					father.leftNode=null;
				}else {		//删除的是右节点
					father.rightNode=null;
				}
			}else if (target.leftNode!=null && target.rightNode!=null) {	//删除的节点有两个子节点
				//删除该节点右子树中值最小的节点，并获取到该节点的值
				int min=deletMin(target.rightNode);
				//替换目标节点的值
				target.value=min;
			}else {		//删除的节点只有一个子节点
				if (target.leftNode != null) {	//有左节点
					if (target.leftNode.value == value) {
						father.leftNode=target.leftNode;
					}else {
						father.rightNode=target.leftNode;
					}
				}else {		//有右子节点
					father.rightNode=target.rightNode;
				}
			}
		}
	}
	
	//删除树中最小的节点
	private int deletMin(Node node) {
		Node target=node;
		while (node.leftNode !=null) {
			target=node.leftNode;
		}
		//如果这个节点有子节点
		delete(target.value);
		return target.value;
	}

	//查找父节点
	public Node searchFather(int value) {
		if (root == null) {
			return null;
		}else {
			return root.searchFather(value);
		}
	}
}
