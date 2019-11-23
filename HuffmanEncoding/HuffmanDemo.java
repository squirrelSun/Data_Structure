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
		//进行哈夫曼编码压缩
		byte[] b=huffmanZip(bytes);
//		System.out.println(bytes.length);
//		System.out.println(b.length);
		//进行哈夫曼解码
		byte[] newByte=decode(huffCodes,b);
		System.out.println(new String(newByte));
		
//		String src="";//操作前文件名
//		String path="";//操作后文件名
//		//压缩文件
//		try {
//			zipFile(src, path);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		//解压文件
//		try {
//			unZip(src,path);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	//哈夫曼压缩文件
	public static void zipFile(String src,String path) throws IOException {
		//创建输入流
		InputStream is=new FileInputStream(src);
		//创建数组存放文件内容
		byte[] b=new byte[is.available()];
		//读取文件
		is.read(b);
		is.close();
		//进行哈夫曼编码
		byte[] byteZip=huffmanZip(b);
		//创建输出流
		OutputStream os=new FileOutputStream(path);
		ObjectOutputStream os2=new ObjectOutputStream(os);
		//把压缩文件和哈夫曼编码表写入文件
		os2.write(byteZip);
		os2.writeObject(huffCodes);
		os2.close();
		os.close();
	}
	
	//哈夫曼解压文件
	public static void unZip(String src,String path) throws Exception {
		//创建输入流
		InputStream is=new FileInputStream(src);
		ObjectInputStream ois=new ObjectInputStream(is);
		//读取字节数组
		byte[] b=(byte[])ois.readObject();
		//读取编码表
		@SuppressWarnings("unchecked")
		Map<Byte,String> huffCodes=(Map<Byte, String>) ois.readObject();
		ois.close();
		is.close();
		//解码
		byte[] bytes=decode(huffCodes, b);
		//创建输出流
		OutputStream os=new FileOutputStream(path);
		//写数据
		os.write(bytes);
		os.close();
	}
	

	//哈夫曼压缩
	private static byte[] huffmanZip(byte[] bytes) {
		//先统计每一个byte出现的次数，放入集合
		List<Node> nodes=getNodes(bytes);
		//创建哈夫曼树
		Node tree=createHuffmanTree(nodes);
		//创建哈夫曼编码表
		Map<Byte, String> huffCodes=getCodes(tree);
		//编码
		byte[] b=zip(bytes,huffCodes);
		return b;
	}

	//哈夫曼解码
	private static byte[] decode(Map<Byte, String> huffCodes2, byte[] bytes) {
		//把数组转为二进制字符串
		StringBuilder sb=new StringBuilder();
		for (int i=0; i<bytes.length; i++) {
			byte b=bytes[i];
			boolean flag=(i==bytes.length-1);//判断是否为最后一个字节
			sb.append(byteToByte(!flag,b));
		}
		//字符串按照编码表进行解码
		//编码表进行键值调换
		Map<String , Byte> map=new HashMap<>();
		for (Map.Entry<Byte, String> entry:huffCodes.entrySet()) {
			map.put(entry.getValue(), entry.getKey());
		}
		//存放截取出的字节
		List<Byte> list=new ArrayList<>();
		//处理字符串
		for (int i=0; i<sb.length();) {
			int count=1;
			boolean flag=true;
			Byte b=null;
			//截取出byte
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
		//集合转为数组
		byte[] bt=new byte[list.size()];
		for (int i=0; i<bt.length; i++) {
			bt[i]=list.get(i);
		}
		return bt;
	}

	
	
	//数组转集合
	private static List<Node> getNodes(byte[] bytes) {
		List<Node> nodes=new ArrayList<>();
		// 计算出现的次数
		Map<Byte, Integer> counts=new HashMap<>();
		for (byte b:bytes) {
			Integer count=counts.get(b);
			if (count == null) {
				counts.put(b, 1);
			}else {
				counts.put(b, count+1);
			}
		}
		//把键值对转为Node对象
		for (Map.Entry<Byte,Integer> entry:counts.entrySet()) {
			nodes.add(new Node(entry.getKey(),entry.getValue()));
		}
		return nodes;
	}

	//创建哈夫曼树
	private static Node createHuffmanTree(List<Node> nodes) {
		while (nodes.size() > 1) {
			//二叉树按权值排序
			Collections.sort(nodes);
			//从二叉树集合取出两个权值最小的二叉树
			Node left=nodes.get(nodes.size()-1);
			Node right=nodes.get(nodes.size()-2);
			//将取出的树创建成新的二叉树
			Node newNode=new Node(null,left.value+right.value);
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
	
	//创建哈夫曼编码
	static StringBuilder sb=new StringBuilder(); //存储临时路径
	static Map<Byte,String> huffCodes=new HashMap<>();//存储哈夫曼编码
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

	//根据编码表进行编码
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
		//需要压缩的数组处理为长字符串
		StringBuilder sb=new StringBuilder();
		for (byte b:bytes) {
			sb.append(huffCodes.get(b));
		}
		//定义长度
		int length;
		if (sb.length()%8==0) {
			length=sb.length()/8;
		}else {
			length=sb.length()/8+1;
		}
		//用于存储压缩后的数组
		byte[] by=new byte[length];
		//记录下标
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
