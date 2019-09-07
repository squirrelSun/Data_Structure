package Noda;

public class NodaDemo {

	public static void main(String[] args) {
		Noda n1=new Noda(1);
		Noda n2=new Noda(2);
		Noda n3=new Noda(3);
		n1.append(n2).append(n3).append(new Noda(4));
//		System.out.println(n1.next().next().GetNoda());
//		System.out.println(n3.isLast());
//		n1.show();
//		n1.next.removeNext();
		n2.after(new Noda(5));
		n1.show();
	}

}
