package HashTable;

public class hashTable_demo {

	public static void main(String[] args) {
		StuInfo s1=new StuInfo(16, 3);
		StuInfo s2=new StuInfo(17, 11);
		StuInfo s3=new StuInfo(18, 23);
		StuInfo s4=new StuInfo(19, 24);
		StuInfo s5=new StuInfo(20, 9);
		
		hashTable ht=new hashTable();
		ht.put(s1);
		ht.put(s2);
		ht.put(s3);
		ht.put(s4);
		ht.put(s5);
		System.out.println(ht);
		
		//��Ҫ��ȡ��Ŀ������
		StuInfo target=new StuInfo(18);
		StuInfo info=ht.get(target);
		System.out.println(info);
	}
	
}
