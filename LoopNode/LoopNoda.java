package LoopNode;
//ѭ������
public class LoopNoda {

	int data;//�ڵ�����
	LoopNoda next=this;//��һ�ڵ�
	
	public LoopNoda(int data) {
		this.data=data;
	}
	
	//��һ�ڵ�
	public LoopNoda next() {
		return this.next;
	}
	
	//��ǰ�ڵ��ֵ
	public int GetNoda() {
		return this.data;
	} 
	
	
	//ɾ����һ�ڵ�
	public void removeNext() {
		LoopNoda newNext=next.next;//��ȡ���½ڵ�
		this.next=newNext;//�ڵ����ø���
	}
	
	//����ڵ�
	public void after(LoopNoda noda) {
		LoopNoda nextNode=next;//ȡ����һ���ڵ�
		this.next=noda;//�½ڵ���Ϊ��ǰ�ڵ����һ��
		noda.next=nextNode;//�½ڵ����һ���ڵ�
	}
	

}
