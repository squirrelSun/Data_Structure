
public class test {
    public static void main(String[] args) {
		Site site=new Site();
		Thread t1=new Thread(site,"ÌÒÅÜÅÜ");
		Thread t2=new Thread(site,"ÇÀÆ±´úÀí");
		Thread t3=new Thread(site,"»ÆÅ£µ³");
		t1.start();
		t2.start();
		t3.start();
	}
}
