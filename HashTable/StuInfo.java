package HashTable;

public class StuInfo {

	private int age;
	private int count;
	/*散列函数
	 * 包括：直接定址、数据分析、平方取中、取余、随机数等(按实际需要选择)
	 * 绝大部分时候会出现散列冲突
	 * 解决方案：开放地址（线性探测法、二次探测法、再哈希法），链地址
	 * */
	public int hashCode() {
		return age;
	}
	
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public StuInfo(int age, int count) {
		super();
		this.age = age;
		this.count = count;
	}
	public StuInfo(int age) {
		super();
		this.age = age;
	}

	@Override
	public String toString() {
		return "StuInfo [age=" + age + ", count=" + count + "]";
	}
	
	
}
