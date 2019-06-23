
public class Site implements Runnable{
     private int count=10;
     private int num=0;
     private boolean flag = false;
     public void run(){
    	 while (!flag) {
			synchronized (this) {
				if (count<=0) {
					break;
				}
				num++;
				count--;
				try {
					Thread.sleep(200);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println(Thread.currentThread().getName()+num+"ÕÅÆ±£¬Ê£Óà"+count+"ÕÅÆ±£¡");
			}
			
		}
     }
}
