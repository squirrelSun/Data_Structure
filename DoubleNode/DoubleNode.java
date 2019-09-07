package DoubleNode;
//ѭ��˫������
public class DoubleNode {
	DoubleNode pre=this;//��һ���ڵ�
	DoubleNode next=this;//��һ���ڵ�
	int data;//��ǰ�ڵ�����
	
	public DoubleNode(int data) {
		this.data=data;
	}
	
	//���ӽڵ�
	public void after(DoubleNode node) {
		DoubleNode nextNode=next;//ԭ������һ���ڵ�
		this.next=node;//��ǰ�ڵ����һ�ڵ�Ϊ�½ڵ�
		node.pre=this;//�½ڵ����һ�ڵ�Ϊ��ǰ�ڵ�
		node.next=nextNode;//ԭ����һ���ڵ�Ϊ�½ڵ����һ���ڵ�
		nextNode.pre=node;//ԭ����һ���ڵ����һ���ڵ�Ϊ�½ڵ�
	}
	
	//��ȡ��һ�ڵ�
	public DoubleNode next() {
		return this.next;
	}
	
	//��ȡ��һ�ڵ�
	public DoubleNode pre() {
		return this.pre;
	}
	
	//��ǰ�ڵ�����
	public int geyData() {
		return this.data;
	}
}
