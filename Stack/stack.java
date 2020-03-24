package Stack;

//栈

public class stack {

	private int MAT_Length = 5;//栈的容量
	private int[] nums = new int[MAT_Length];//容器
	private int top = 0;//栈顶
	private int down = 0;//栈底
	
	public stack() {
		
	}
	
	//入栈
	public void push(int num) {
		if (isFull())
			throw new RuntimeException("目前栈满，无法添加");
		top++;
		nums[top % MAT_Length] = num;
	}
	
	//出栈
	public int pop() {
		if (isEmpty())
			throw new RuntimeException("目前栈内无元素");
		int num = nums[top];
		top = (top - 1 + MAT_Length) % MAT_Length;
		return num;
	}
	
	//显示栈顶元素
	public void showTop() {
		if (isEmpty())
			throw new RuntimeException("目前栈内无元素");
		System.out.println(nums[top]);
	}
	
	//显示栈底
	public void showDown() {
		if (isEmpty())
			throw new RuntimeException("目前栈内无元素");
		System.out.println(nums[(down + 1) % MAT_Length]); 
	}
	
	//显示栈所有元素
	public void show() {
		if (isEmpty()) {
			throw new RuntimeException("队内暂无元素");
		}
		for (int i = top ; i > down ; i--) {
			System.out.print(nums[(i) % MAT_Length ] + "\t");
		}
		System.out.println();
	}
	
	//显示栈内指定位置元素
	public int indexOf(int index) {
		if (index > MAT_Length - 1 || index > size())
			throw new RuntimeException("角标有误");
		if (isEmpty())
			throw new RuntimeException("目前栈内无元素");
		return nums[(top + index - 1 + MAT_Length) % MAT_Length];
	}
	
	//显示栈内元素数量
	public int size() {
		if (isEmpty())
			return 0;
		if (isFull())
			return MAT_Length - 1;
		return (down - top + MAT_Length) % MAT_Length;
	}
	
	//栈满
	public boolean isFull() {
		return (top + 1) % MAT_Length == down;
	}
	
	//栈空
	public boolean isEmpty() {
		return top == down;
	}
}
