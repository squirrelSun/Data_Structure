package Noda;
//单链表
public class Noda {

	int data;//节点内容
	Noda next;//下一节点
	
	public Noda(int data) {
		this.data=data;
	}
	
		//追加节点	
	public Noda append(Noda noda) {
		Noda currentnode=this;
		while(true) {
			Noda nextnode=currentnode.next;
			if(nextnode==null)
				break;	
			currentnode=nextnode;
		}
		currentnode.next=noda;
		return this;
	}
	
	//下一节点
	public Noda next() {
		return this.next;
	}
	
	//当前节点的值
	public int GetNoda() {
		return this.data;
	} 
	
	//是否为最终节点
	public boolean isLast() {
		return next==null;
	}
	
	//删除下一节点
	public void removeNext() {
		Noda newNext=next.next;//获取下下节点
		this.next=newNext;//节点引用覆盖
	}
	
	//插入节点
	public void after(Noda noda) {
		Noda nextNode=next;//取出下一个节点
		this.next=noda;//新节点最为当前节点的下一个
		noda.next=nextNode;//新节点的下一个节点
	}
	
	//显示所有节点
	public void show() {
		Noda currentNode=this;
		while(true) {
			System.out.print(currentNode.data+"   ");
			currentNode=currentNode.next;
			if (currentNode==null)
				break;
		}
		
	}
}
