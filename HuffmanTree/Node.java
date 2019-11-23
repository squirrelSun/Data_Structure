package HuffmanTree;

public class Node implements Comparable<Node>{

	int value;//权值
	Node leftNode;//左节点
	Node rightNode;//右节点
	
	public Node(int value) {
		this.value=value;
	}
	
	public void setleftNode(Node leftNode) {
		this.leftNode=leftNode;
	}
	
	public void setrightNode(Node rightNode) {
		this.rightNode=rightNode;
	}


	public int compareTo(Node o) {
		return -this.value-o.value;
	}

	public String toString() {
		return "Node [value=" + value + "]";
	}
	
	
	
}
