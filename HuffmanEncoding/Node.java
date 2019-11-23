package HuffmanEncoding;

public class Node implements Comparable<Node>{
	
	Byte data;//��ŵ��ַ�
	int value;//Ȩֵ
	Node leftNode;//��ڵ�
	Node rightNode;//�ҽڵ�
	
	public Node(Byte data,int value) {
		this.data=data;
		this.value=value;
	}
	
	public void setleftNode(Node leftNode) {
		this.leftNode=leftNode;
	}
	
	public void setrightNode(Node rightNode) {
		this.rightNode=rightNode;
	}

	public int compareTo(Node o) {
		return o.value-this.value;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", value=" + value + "]";
	}
	
	
	
}
