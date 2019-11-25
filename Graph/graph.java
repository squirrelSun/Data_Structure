package Graph;


import Queue.MyQueue;
import Stack.MyStack;

//ͼ�ṹ��
public class graph {

	private vertex[] vertex;
	private int currentSize;
	public int[][] adjMat;
	private MyStack stack=new MyStack();
	private MyQueue queue=new MyQueue();
	private int currentIndex;
	
	public graph(int size) {
		vertex=new vertex[size];
		adjMat=new int[size][size];
	}
	
	//��ͼ�м��붥��
	public void addVertex(vertex v) {
		vertex[currentSize++]=v;
	}
	
	//��ͼ�����ӱ�
	public void addEage(String v1,String v2) {
		//�ҵ�����������±�
		int index1=0;
		for (int i=0 ; i<vertex.length ; i++) {
			if (vertex[i].getValue().equals(v1)) {
				index1=i;
				break;
			}
		}
		int index2=0;
		for (int i=0 ; i<vertex.length ; i++) {
			if (vertex[i].getValue().equals(v2)) {
				index2=i;
				break;
			}
		}
		adjMat[index1][index2]=1;
		adjMat[index2][index1]=1;
		adjMat[index1][index1]=1;
		adjMat[index2][index2]=1;
	}
	
	//ͼ��������ȱ���
	public void dfs() {
		//�ӵ�0�����㿪ʼ
		vertex[0].visited=true;
		stack.push(0);//��ʼ������ջ
		System.out.println(vertex[0].getValue());//��ӡ
		//��ʼ����
		out:while(!stack.isEmpty()) {
			for (int i=currentIndex+1 ; i<vertex.length ; i++) {	
				if (adjMat[currentIndex][i] == 1) {		//����һ��������Ԫ�ش���ͨ·
					if (vertex[i].visited == false) {		//�Ƿ��Ѿ�����
						//����Ԫ����ջ
						stack.push(i);
						vertex[i].visited=true;
						System.out.println(vertex[i].getValue());
						continue out;
					}
				}
			}
			stack.pop();	//ջ������
			if (!stack.isEmpty()) {
				currentIndex=(int)stack.peek();		//��ǰλ�û�Ϊջ��Ԫ��
			}
		}
	}

	//ͼ�Ĺ�����ȱ���
	public void bfs() {
		//�ӵ�0�����㿪ʼ
		vertex[0].visited=true;
		queue.add(0);//��ʼ�������
		System.out.println(vertex[0].getValue());//��ӡ
		//��ʼ����
		out:while(!queue.isEmpty()) {
			for (int i=currentIndex+1 ; i<vertex.length ; i++) {	
				if (adjMat[currentIndex][i] == 1) {		//����һ��������Ԫ�ش���ͨ·
					if (vertex[i].visited == false) {		//�Ƿ��Ѿ�����
						//����Ԫ�����
						queue.add(i);
						vertex[i].visited=true;
						System.out.println(vertex[i].getValue());
						continue out;
					}
				}
			}
			queue.poll();	//����
			if (!queue.isEmpty()) {
				currentIndex=(int) queue.peek();		//��ǰλ�û�Ϊջ��Ԫ��
			}
		}
	}
	
}
