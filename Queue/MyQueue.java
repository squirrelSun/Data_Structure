package Queue;

public class MyQueue {

	int[] elements;
	
	public MyQueue() {
		elements = new int[0];
	}
	
	public void show() {
		for(int i=0;i<elements.length;i++)
			System.out.println(elements[i]);
 	}
	
	public void add(int element) {
		int[] Arrery=new int[elements.length+1];
		Arrery[Arrery.length-1]=element;
		for(int i=0;i<elements.length;i++) 
			Arrery[i]=elements[i];
		elements=Arrery;
	}
	
	public int poll() {
		int element=elements[0];
		int[] Arrery=new int[elements.length-1];
		for(int i=0;i<Arrery.length;i++) 
			Arrery[i]=elements[i+1];
		elements=Arrery;
		return element;
	}
	
}
