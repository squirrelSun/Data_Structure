package HuffmanEncoding;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HuffmanDemo {

	public static void main(String[] args) {
		String mis="can you can a can as a can canner can a can.";
		byte[] bytes=mis.getBytes();
		//���й���������ѹ��
		byte[] b=huffmanZip(bytes);
//		System.out.println(bytes.length);
//		System.out.println(b.length);
		//���й���������
		byte[] newByte=decode(huffCodes,b);
		System.out.println(new String(newByte));
		
//		String src="";//����ǰ�ļ���
//		String path="";//�������ļ���
//		//ѹ���ļ�
//		try {
//			zipFile(src, path);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		//��ѹ�ļ�
//		try {
//			unZip(src,path);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	//������ѹ���ļ�
	public static void zipFile(String src,String path) throws IOException {
		//����������
		InputStream is=new FileInputStream(src);
		//�����������ļ�����
		byte[] b=new byte[is.available()];
		//��ȡ�ļ�
		is.read(b);
		is.close();
		//���й���������
		byte[] byteZip=huffmanZip(b);
		//���������
		OutputStream os=new FileOutputStream(path);
		ObjectOutputStream os2=new ObjectOutputStream(os);
		//��ѹ���ļ��͹����������д���ļ�
		os2.write(byteZip);
		os2.writeObject(huffCodes);
		os2.close();
		os.close();
	}
	
	//��������ѹ�ļ�
	public static void unZip(String src,String path) throws Exception {
		//����������
		InputStream is=new FileInputStream(src);
		ObjectInputStream ois=new ObjectInputStream(is);
		//��ȡ�ֽ�����
		byte[] b=(byte[])ois.readObject();
		//��ȡ�����
		@SuppressWarnings("unchecked")
		Map<Byte,String> huffCodes=(Map<Byte, String>) ois.readObject();
		ois.close();
		is.close();
		//����
		byte[] bytes=decode(huffCodes, b);
		//���������
		OutputStream os=new FileOutputStream(path);
		//д����
		os.write(bytes);
		os.close();
	}
	

	//������ѹ��
	private static byte[] huffmanZip(byte[] bytes) {
		//��ͳ��ÿһ��byte���ֵĴ��������뼯��
		List<Node> nodes=getNodes(bytes);
		//������������
		Node tree=createHuffmanTree(nodes);
		//���������������
		Map<Byte, String> huffCodes=getCodes(tree);
		//����
		byte[] b=zip(bytes,huffCodes);
		return b;
	}

	//����������
	private static byte[] decode(Map<Byte, String> huffCodes2, byte[] bytes) {
		//������תΪ�������ַ���
		StringBuilder sb=new StringBuilder();
		for (int i=0; i<bytes.length; i++) {
			byte b=bytes[i];
			boolean flag=(i==bytes.length-1);//�ж��Ƿ�Ϊ���һ���ֽ�
			sb.append(byteToByte(!flag,b));
		}
		//�ַ������ձ������н���
		//�������м�ֵ����
		Map<String , Byte> map=new HashMap<>();
		for (Map.Entry<Byte, String> entry:huffCodes.entrySet()) {
			map.put(entry.getValue(), entry.getKey());
		}
		//��Ž�ȡ�����ֽ�
		List<Byte> list=new ArrayList<>();
		//�����ַ���
		for (int i=0; i<sb.length();) {
			int count=1;
			boolean flag=true;
			Byte b=null;
			//��ȡ��byte
			while (flag){
				String key=sb.substring(i,i+count);
				b=map.get(key);
				if (b == null) {
					count++;
				}else {
					flag=false;
				}
			}
			list.add(b);
			i+=count;
		}
		//����תΪ����
		byte[] bt=new byte[list.size()];
		for (int i=0; i<bt.length; i++) {
			bt[i]=list.get(i);
		}
		return bt;
	}

	
	
	//����ת����
	private static List<Node> getNodes(byte[] bytes) {
		List<Node> nodes=new ArrayList<>();
		// ������ֵĴ���
		Map<Byte, Integer> counts=new HashMap<>();
		for (byte b:bytes) {
			Integer count=counts.get(b);
			if (count == null) {
				counts.put(b, 1);
			}else {
				counts.put(b, count+1);
			}
		}
		//�Ѽ�ֵ��תΪNode����
		for (Map.Entry<Byte,Integer> entry:counts.entrySet()) {
			nodes.add(new Node(entry.getKey(),entry.getValue()));
		}
		return nodes;
	}

	//������������
	private static Node createHuffmanTree(List<Node> nodes) {
		while (nodes.size() > 1) {
			//��������Ȩֵ����
			Collections.sort(nodes);
			//�Ӷ���������ȡ������Ȩֵ��С�Ķ�����
			Node left=nodes.get(nodes.size()-1);
			Node right=nodes.get(nodes.size()-2);
			//��ȡ�������������µĶ�����
			Node newNode=new Node(null,left.value+right.value);
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
	
	//��������������
	static StringBuilder sb=new StringBuilder(); //�洢��ʱ·��
	static Map<Byte,String> huffCodes=new HashMap<>();//�洢����������
	private static Map<Byte, String> getCodes(Node tree) {
		if (tree == null) {
			return null;
		}
		getCodes(tree.leftNode,"0",sb);
		getCodes(tree.rightNode,"1",sb);
		return huffCodes;
	}

	private static void getCodes(Node node, String code, StringBuilder sb) {
		StringBuilder sb2=new StringBuilder(sb);
		sb2.append(code);
		if (node.data == null) {
			getCodes(node.leftNode,"0",sb2);
			getCodes(node.rightNode,"1",sb2);
		}else {
			huffCodes.put(node.data, sb2.toString());
		}
	}

	//���ݱ������б���
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
		//��Ҫѹ�������鴦��Ϊ���ַ���
		StringBuilder sb=new StringBuilder();
		for (byte b:bytes) {
			sb.append(huffCodes.get(b));
		}
		//���峤��
		int length;
		if (sb.length()%8==0) {
			length=sb.length()/8;
		}else {
			length=sb.length()/8+1;
		}
		//���ڴ洢ѹ���������
		byte[] by=new byte[length];
		//��¼�±�
		int index=0;
		for (int i=0;i<sb.length();i+=8) {
			String str;
			if (i+8>sb.length()) {
				str=sb.substring(i);
			}else {
				str=sb.substring(i,i+8);
			}
			byte bt=(byte)Integer.parseInt(str,2);
			by[index]=bt;
			index++;
		}
		return by;
	}
	
	private static String byteToByte(Boolean flag,byte b) {
		int temp=b;
		if (flag) {
			temp|=256;
		}
		String str=Integer.toBinaryString(temp);
		if (flag) {
			return str.substring(str.length()-8);
		}else {
			return str;
		}
	}
	
}
