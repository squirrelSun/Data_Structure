package Queue;

//环形队列

public class queue {

	private int MAX_LENGTH = 5;//队列长度
	private int head = 0;//队头
	private int foot = 0;//队尾
	private int[] nums = new int[MAX_LENGTH];//容器
	
	//入队
	public void add(int num) {
		if (this.isFull()) {
			throw new RuntimeException("队内已满无法添加");
		}
		foot = (foot + 1) % MAX_LENGTH;
		nums[foot] = num;
	}
	
	//出队
	public int del() {
		if (this.isEmity()) {
			throw new RuntimeException("队内暂无元素");
		}
		int x = nums[head + 1];
		head = (head + 1) % MAX_LENGTH;
		return x;
	}
	
	//是否队满
	public boolean isFull() {
		return (foot + 1) % MAX_LENGTH == head;
	}
	
	//是否队空
	public boolean isEmity() {
		return foot == head;
	}
	
	//显示队内元素
	public void show() {
		if (isEmity()) {
			throw new RuntimeException("队内暂无元素");
		}
		for (int i = head + 1 ; i < foot + MAX_LENGTH + 1; i++) {
			System.out.print(nums[(i) % MAX_LENGTH ] + "\t");
		}
	}
	
	//获取队首元素
	public int showHead() {
		if (isEmity()) {
			throw new RuntimeException("队内暂无元素");
		}
		return nums[head + 1];
	}
	
	//获取队尾元素
	public int showFoot() {
		if (isEmity()) {
			throw new RuntimeException("队内暂无元素");
		}
		return nums[foot];
	}
}
