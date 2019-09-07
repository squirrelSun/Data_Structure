package Recursive;
//�ݹ�ʵ�ֺ�ŵ������
public class TestHanoi {

	public static void main(String[] args) {
		hanoi(5,'a','b','c');
	}
	/**
	 * @param i	������
	 * @param from	��ʼλ��
	 * @param in	����λ��
	 * @param to	Ŀ��λ��
	 * �����ж��ٸ����ӣ�������Ϊֻ������(�����棬����)
	 */
	public static void hanoi(int i,char from,char in,char to) {
		if (i==1) {
			System.out.println("��"+i+"�����Ӵ�"+from+"�Ƶ�"+to);
		}else {
			hanoi(i-1,from,to,in);//�����һ������ƶ�������λ��
			System.out.println("��"+i+"�����Ӵ�"+from+"�Ƶ�"+to);
			hanoi(i-1,in,from,to);//����λ������Ԫ���ƶ���Ŀ��λ��
		}
	}
	
}
