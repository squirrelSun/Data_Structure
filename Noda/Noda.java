package Noda;
//������
public class Noda {

	int data;//�ڵ�����
	Noda next;//��һ�ڵ�
	
	public Noda(int data) {
		this.data=data;
	}
	
		//׷�ӽڵ�	
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
	
	//��һ�ڵ�
	public Noda next() {
		return this.next;
	}
	
	//��ǰ�ڵ��ֵ
	public int GetNoda() {
		return this.data;
	} 
	
	//�Ƿ�Ϊ���սڵ�
	public boolean isLast() {
		return next==null;
	}
	
	//ɾ����һ�ڵ�
	public void removeNext() {
		Noda newNext=next.next;//��ȡ���½ڵ�
		this.next=newNext;//�ڵ����ø���
	}
	
	//����ڵ�
	public void after(Noda noda) {
		Noda nextNode=next;//ȡ����һ���ڵ�
		this.next=noda;//�½ڵ���Ϊ��ǰ�ڵ����һ��
		noda.next=nextNode;//�½ڵ����һ���ڵ�
	}
	
	//��ʾ���нڵ�
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
