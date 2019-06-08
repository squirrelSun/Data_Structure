package Stack;

public class MyStack {
	
	int[] elements;
	
	public MyStack(){
		elements=new int[0];
	}
	
	public void show() {
		for(int i=0;i<elements.length;i++)
			System.out.println(elements[i]);
	}
	
	public void push(int element) {
		int[] Arrery=new int[elements.length+1];
		Arrery[Arrery.length-1]=element;
		for(int i=0;i<elements.length;i++) 
			Arrery[i]=elements[i];
		elements=Arrery;
	}
	
	public int pop() {
		if(elements.length==0) 
			throw new RuntimeException("数组越界");
		int[] Arrery=new int[elements.length-1];
		for(int i=0;i<Arrery.length;i++)  
			Arrery[i]=elements[i];
		elements=Arrery;
		return elements[elements.length-1];
	}
}
