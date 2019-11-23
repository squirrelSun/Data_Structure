package HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTreeDemo {

	public static void main(String[] args) {
		int[] arr = {3,7,8,29,5,11,23,14};
		Node node=createHuffmanTree(arr);
		System.out.println(node);
	}
	
	//创建哈夫曼树 
	public static Node createHuffmanTree(int[] arr) {
		//用数组元素创建二叉树(只有一个节点)
		List<Node> nodes=new ArrayList<>();
		for (int i:arr) {
			nodes.add(new Node(i));
		}
		//循环处理
		while (nodes.size() > 1) {
			//二叉树按权值排序
			Collections.sort(nodes);
			//从二叉树集合取出两个权值最小的二叉树
			Node left=nodes.get(nodes.size()-1);//最小
			Node right=nodes.get(nodes.size()-2);//次小
			//将取出的树创建成新的二叉树
			Node newNode=new Node(left.value+right.value);
			newNode.leftNode=left;
			newNode.rightNode=right;
			//从二叉树集合中删除取出的树
			nodes.remove(left);
			nodes.remove(right);
			//放去原来的二叉树集合中
			nodes.add(newNode);
		}
		return nodes.get(0);
	} 
	
}
