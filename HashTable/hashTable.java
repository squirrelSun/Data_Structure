package HashTable;

import java.util.Arrays;

public class hashTable {

	private StuInfo[] data=new StuInfo[100];
	
	//��ɢ�б������Ԫ��
	public void put(StuInfo stuinfo) {
		//����ɢ�к�����ȡ�洢λ��
		int index=stuinfo.hashCode();
		//���Ԫ��
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
