
public class test {
    public static void main(String[] args) {
		Site site=new Site();
		Thread t1=new Thread(site,"������");
		Thread t2=new Thread(site,"��Ʊ����");
		Thread t3=new Thread(site,"��ţ��");
		t1.start();
		t2.start();
		t3.start();
	}
}
