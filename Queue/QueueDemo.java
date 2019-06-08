package Queue;

public class QueueDemo {
	public static void main(String[] args) {
		MyQueue mq=new MyQueue();
		mq.add(1);
		mq.add(2);
		mq.add(3);
		System.out.println(mq.poll());
		System.out.println(mq.poll());
//		mq.show();
	}
}
