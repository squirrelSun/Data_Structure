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
	
	//������������ 
	public static Node createHuffmanTree(int[] arr) {
		//������Ԫ�ش���������(ֻ��һ���ڵ�)
		List<Node> nodes=new ArrayList<>();
		for (int i:arr) {
			nodes.add(new Node(i));
		}
		//ѭ������
		while (nodes.size() > 1) {
			//��������Ȩֵ����
			Collections.sort(nodes);
			//�Ӷ���������ȡ������Ȩֵ��С�Ķ�����
			Node left=nodes.get(nodes.size()-1);//��С
			Node right=nodes.get(nodes.size()-2);//��С
			//��ȡ�������������µĶ�����
			Node newNode=new Node(left.value+right.value);
			newNode.leftNode=left;
			newNode.rightNode=right;
			//�Ӷ�����������ɾ��ȡ������
			nodes.remove(left);
			nodes.remove(right);
			//��ȥԭ���Ķ�����������
			nodes.add(newNode);
		}
		return nodes.get(0);
	} 
	
}
