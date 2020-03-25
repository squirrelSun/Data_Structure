package Arithmetic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//贪心算法
public class Greedy {

	public static void main(String[] args) {
		// 创建可选择的集合
		HashMap<String, HashSet<String>> map = new HashMap<>();
		// 将可选择内容加入集合
		HashSet<String> hashSet1 = new HashSet<>();
		hashSet1.add("A");
		hashSet1.add("B");
		hashSet1.add("C");
		hashSet1.add("D");
		HashSet<String> hashSet2 = new HashSet<>();
		hashSet2.add("A");
		hashSet2.add("E");
		hashSet2.add("C");
		hashSet2.add("F");
		HashSet<String> hashSet3 = new HashSet<>();
		hashSet3.add("A");
		hashSet3.add("E");
		hashSet3.add("F");
		hashSet3.add("D");
		HashSet<String> hashSet4 = new HashSet<>();
		hashSet4.add("C");
		hashSet4.add("B");
		hashSet4.add("F");
		HashSet<String> hashSet5 = new HashSet<>();
		hashSet5.add("A");
		hashSet5.add("E");
		// 加入map
		map.put("k1", hashSet1);
		map.put("k2", hashSet2);
		map.put("k3", hashSet3);
		map.put("k4", hashSet4);
		map.put("k5", hashSet5);
		// 所有元素
		HashSet<String> set = new HashSet<>();
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
		set.add("E");
		set.add("F");

		// 创建存放选择的集合
		ArrayList<String> arrayList = new ArrayList<>();

		// 临时集合，保存遍历过程中以选择与待选择的交集
		HashSet<String> tempSet = new HashSet<>();

		// 保存再一次遍历过程中，能够产生的交集的set的key
		String maxKey;
		while (set.size() != 0) { // 还存在未选择的数据
			maxKey = null;
			for (String key : map.keySet()) {
				tempSet.clear();
				// 当前集合中存在的待选择的数据
				HashSet<String> hashSet = map.get(key);
				tempSet.addAll(hashSet);
				// 与所有元素取交集
				tempSet.retainAll(set);

				// 找到存在待选择数据最多的集合的key 每次均选择最优
				if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > map.get(maxKey).size())) {
					maxKey = key;
				}

			}
			if (maxKey != null) {
				// 加入已选择的集合
				arrayList.add(maxKey);
				// 将已选择的集合中的元素从所有元素中去除
				set.removeAll(map.get(maxKey));
			}
		}

		System.out.println("得到的选择结果为：" + arrayList);
	}

}
