package AVLtree;

public class Node {

	int value;
	Node leftNode;
	Node rightNode;
	
	public Node(int value) {
		this.value=value;
	}

	//树的高度
	public int heigh() {
		return Math.max(leftNode==null ? 0 : leftNode.heigh(), rightNode==null ? 0 : rightNode.heigh())+1;
	}
	
	//获取左子树的高度
	public int leftHeight() {
		if (this.leftNode == null) {
			return 0;
		}
		return this.leftNode.heigh();
	}
	
	//获取右子树的高度
	public int rightHeight() {
		if (this.rightNode == null) {
			return 0;
		}
		return this.rightNode.heigh();
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
		//查询是否平衡
		if (this.leftHeight()-this.rightHeight()>=2) {		//右旋转
			if (this.leftNode!=null && this.leftNode.leftHeight()<this.leftNode.rightHeight()) {	//双旋转
				this.leftNode.leftRotate();
				this.rightRotate();
			}else {		//单旋转
				rightRotate();
			}
		}
		if (this.leftHeight()-this.rightHeight()<=-2) {		//左旋转
			if (this.rightNode!=null && this.rightNode.rightHeight()<this.rightNode.leftHeight()) {		//双旋转
				this.rightNode.rightRotate();
				this.leftRotate();
			}else {		//单旋转
				leftRotate();	
			}
		}
	}

	
	
	//左旋转
	private void leftRotate() {
		//创建新节点，值为当前节点的值
		Node newNode=new Node(value);
		//当前节点的左子树为新节点的左子树
		newNode.leftNode=this.leftNode;
		//新节点的右子树为当前节点的右子树的左子树
		newNode.rightNode=this.rightNode.leftNode;
		//当前节点的值换为右节点的值
		this.value=this.rightNode.value;
		//当前节点的右子树变为当前节点的右子树的右子树
		this.rightNode=this.rightNode.rightNode;
		//新节点设置为当前节点的左节点
		this.leftNode=newNode;
	}

	//右旋转
	private void rightRotate() {
		//创建新节点，值为当前节点的值
		Node newNode=new Node(value);
		//当前节点的右子树为新节点的右子树
		newNode.rightNode=this.rightNode;
		//新节点的左子树为当前节点的左子树的右子树
		newNode.leftNode=this.leftNode.rightNode;
		//当前节点的值换为左节点的值
		this.value=this.leftNode.value;
		//当前节点的左子树变为当前节点的左子树的左子树
		this.leftNode=this.leftNode.leftNode;
		//新节点设置为当前节点的右节点
		this.rightNode=newNode;
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
