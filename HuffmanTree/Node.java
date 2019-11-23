package HuffmanTree;

public class Node implements Comparable<Node>{

	int value;//Ȩֵ
	Node leftNode;//��ڵ�
	Node rightNode;//�ҽڵ�
	
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
