package Stack;

public class StackDemo {
	public static void main(String[] args) {
		MyStack st=new MyStack();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);		
		st.push(5);
		st.pop();
		st.pop();
//		st.show();
		st.pop();
	}
}
