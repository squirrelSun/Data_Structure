package DoubleNode;
//循环双向链表
public class DoubleNode {
	DoubleNode pre=this;//上一个节点
	DoubleNode next=this;//下一个节点
	int data;//当前节点数据
	
	public DoubleNode(int data) {
		this.data=data;
	}
	
	//增加节点
	public void after(DoubleNode node) {
		DoubleNode nextNode=next;//原来的下一个节点
		this.next=node;//当前节点的下一节点为新节点
		node.pre=this;//新节点的上一节点为当前节点
		node.next=nextNode;//原来下一个节点为新节点的下一个节点
		nextNode.pre=node;//原来下一个节点的上一个节点为新节点
	}
	
	//获取下一节点
	public DoubleNode next() {
		return this.next;
	}
	
	//获取上一节点
	public DoubleNode pre() {
		return this.pre;
	}
	
	//当前节点数据
	public int geyData() {
		return this.data;
	}
}
