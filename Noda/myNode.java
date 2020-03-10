package Noda;

//单向链表
public class myNode {

	private int value;// 值
	private myNode next;// 下一节点
	private myNode head;// 头节点

	public myNode() {

	}

	public myNode(int value) {
		this.value = value;
	}

	public myNode(int value, myNode next) {
		this.value = value;
		this.next = next;
	}

	// 在链表尾部插入
	public void add(myNode newNode) {
		if (isSimple()) {
			head = this;
		} else {
			myNode node = this;
			while (node.next != null) {
				node = node.next;
			}
			node.next = newNode;
		}
	}

	// 在指定位置插入
	public void add(myNode newNode, myNode old) {
		myNode node = head;
		while (node.equals(old)) {
			node = node.next;
		}
		if (node.next != null) {
			myNode next = node.next;
			node.next = newNode;
			newNode.next = next;
		} else {
			System.out.println("无指定节点，默认插入尾部");
			node.next = newNode;
		}
	}

	// 删除节点
	public void del(myNode node) {
		myNode newHead = new myNode(-1, head);
		myNode before = newHead;
		while (!before.next.equals(node)) {
			before = before.next;
		}
		before.next = before.next.next;
		node.next = node;
	}

	// 修改指定节点的值
	public void update(myNode node, int val) {
		myNode currentNode = head;
		if (!currentNode.equals(node) && currentNode != null) {
			currentNode = currentNode.next;
		}
		if (currentNode == null)
			throw new RuntimeException("无此节点");
		else
			currentNode.value = val;
	}

	// 链表是否为单节点
	public boolean isSimple() {
		return head.next == null;
	}

	// 获取指定结点的值
	public int get(myNode node) {
		myNode currentNode = head;
		if (!currentNode.equals(node) && currentNode != null) {
			currentNode = currentNode.next;
		}
		if (currentNode == null)
			throw new RuntimeException("无此节点");
		else
			return currentNode.value;
	}

	// 获取下一节点的值
	public myNode getNext() {
		return this.next;
	}

	// 打印链表
	public void show() {
		myNode currentNode = head;
		while (true) {
			System.out.print(currentNode.value + "   ");
			currentNode = currentNode.next;
			if (currentNode == null)
				break;
		}
	}
}
