package Graph;


import Queue.MyQueue;
import Stack.MyStack;

//图结构类
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
	
	//向图中加入顶点
	public void addVertex(vertex v) {
		vertex[currentSize++]=v;
	}
	
	//向图中增加边
	public void addEage(String v1,String v2) {
		//找到两个顶点的下标
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
	
	//图的深度优先遍历
	public void dfs() {
		//从第0个顶点开始
		vertex[0].visited=true;
		stack.push(0);//初始顶点入栈
		System.out.println(vertex[0].getValue());//打印
		//开始遍历
		out:while(!stack.isEmpty()) {
			for (int i=currentIndex+1 ; i<vertex.length ; i++) {	
				if (adjMat[currentIndex][i] == 1) {		//和下一个便利的元素存在通路
					if (vertex[i].visited == false) {		//是否已经遍历
						//遍历元素入栈
						stack.push(i);
						vertex[i].visited=true;
						System.out.println(vertex[i].getValue());
						continue out;
					}
				}
			}
			stack.pop();	//栈顶弹出
			if (!stack.isEmpty()) {
				currentIndex=(int)stack.peek();		//当前位置换为栈顶元素
			}
		}
	}

	//图的广度优先遍历
	public void bfs() {
		//从第0个顶点开始
		vertex[0].visited=true;
		queue.add(0);//初始顶点入队
		System.out.println(vertex[0].getValue());//打印
		//开始遍历
		out:while(!queue.isEmpty()) {
			for (int i=currentIndex+1 ; i<vertex.length ; i++) {	
				if (adjMat[currentIndex][i] == 1) {		//和下一个便利的元素存在通路
					if (vertex[i].visited == false) {		//是否已经遍历
						//遍历元素入队
						queue.add(i);
						vertex[i].visited=true;
						System.out.println(vertex[i].getValue());
						continue out;
					}
				}
			}
			queue.poll();	//出队
			if (!queue.isEmpty()) {
				currentIndex=(int) queue.peek();		//当前位置换为栈顶元素
			}
		}
	}
	
}
