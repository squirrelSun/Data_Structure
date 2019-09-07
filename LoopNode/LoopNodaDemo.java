package LoopNode;

public class LoopNodaDemo {

	public static void main(String[] args) {
		LoopNoda n1=new LoopNoda(1);
		LoopNoda n2=new LoopNoda(2);
		LoopNoda n3=new LoopNoda(3);
		LoopNoda n4=new LoopNoda(4);
		n1.after(n2);
		n2.after(n3);
		n3.after(n4);
		System.out.println(n1.next.GetNoda());
		System.out.println(n2.next.GetNoda());
		System.out.println(n3.next.GetNoda());
		System.out.println(n4.next.GetNoda());
	}

}
