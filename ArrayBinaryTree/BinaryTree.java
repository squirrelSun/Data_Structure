package ArrayBinaryTree;

public class BinaryTree {
	
	int[] data;
	
	public BinaryTree(int[] data) {
		this.data=data;
	}
	
	//ǰ�����
	public void frontShow() {
		frontShow(0);
	}
	public void frontShow(int index) {
		if (data==null || data.length==0) {
			return;
		}
		System.out.println(data[index]);//��ǰ�ڵ�
		if (2*index+1<data.length) {	//������
			frontShow(2*index+1);
		}
		if (2*index+2<data.length) {	//������
			frontShow(2*index+2);
		}
	}

	//�������
	public void midShow() {
		midShow(0);
	}
	public void midShow(int index) {
		if (data==null || data.length==0) {
			return;
		}
		if (2*index+1<data.length) {	//������
			midShow(2*index+1);
		}
		System.out.println(data[index]);//��ǰ�ڵ�
		if (2*index+2<data.length) {	//������
			midShow(2*index+2);
		}
	}

	//�������
	public void afterShow() {
		afterShow(0);
	}
	public void afterShow(int index) {
		if (data==null || data.length==0) {
			return;
		}
		if (2*index+1<data.length) {	//������
			afterShow(2*index+1);
		}
		if (2*index+2<data.length) {	//������
			afterShow(2*index+2);
		}
		System.out.println(data[index]);//��ǰ�ڵ�
	}
}
