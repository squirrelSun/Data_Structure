package HashTable;

import java.util.Arrays;

public class hashTable {

	private StuInfo[] data=new StuInfo[100];
	
	//向散列表中添加元素
	public void put(StuInfo stuinfo) {
		//调用散列函数获取存储位置
		int index=stuinfo.hashCode();
		//添加元素
		data[index]=stuinfo;
	}
	
	public StuInfo get(StuInfo stuinfo) {
		return data[stuinfo.hashCode()];
	}

	@Override
	public String toString() {
		return "hashTable [data=" + Arrays.toString(data) + "]";
	}
	
}
