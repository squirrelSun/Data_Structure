package LoopNode;
//循环链表
public class LoopNoda {

	int data;//节点内容
	LoopNoda next=this;//下一节点
	
	public LoopNoda(int data) {
		this.data=data;
	}
	
	//下一节点
	public LoopNoda next() {
		return this.next;
	}
	
	//当前节点的值
	public int GetNoda() {
		return this.data;
	} 
	
	
	//删除下一节点
	public void removeNext() {
		LoopNoda newNext=next.next;//获取下下节点
		this.next=newNext;//节点引用覆盖
	}
	
	//插入节点
	public void after(LoopNoda noda) {
		LoopNoda nextNode=next;//取出下一个节点
		this.next=noda;//新节点最为当前节点的下一个
		noda.next=nextNode;//新节点的下一个节点
	}
	

}
