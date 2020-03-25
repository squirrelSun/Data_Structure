package Arithmetic;

//KMP算法实现字符串匹配
public class KMP {

	public static void main(String[] args) {
		String str1 = "asdasasasasfdas";
		String str2 = "sasf";
		int[] kmpNext = kmpNext(str2);
		int index = kmpSearch(str1, str2, kmpNext);
		System.out.println(index);
	}

	/**
	 * kmp搜索算法
	 * @param str1 父串
	 * @param str2 字串
	 * @param next 部分匹配表
	 * @return 匹配索引 
	 */
	public static int kmpSearch(String str1, String str2, int[] next) {
		for (int i = 0, j = 0; i < str1.length(); i++) {
			//从匹配表中取下一次匹配的开始点
			while(j > 0 && str1.charAt(i) != str2.charAt(j)) {
				j = next[j - 1];
			}
			//逐字符匹配
			if (str1.charAt(i) == str2.charAt(j)) {
				j++;
			}
			//匹配成功
			if (j == str2.length()) {
				return i - j + 1;
			}
		}
		return -1;
	}

	// 获取字串的部分匹配表
	public static int[] kmpNext(String str) {
		// 数组保存匹配值
		int[] next = new int[str.length()];
		next[0] = 0; // 自身的部分匹配值恒为零
		for (int i = 1, j = 0; i < str.length(); i++) {
			
			while (j > 0 && str.charAt(i) != str.charAt(j)) { // 无匹配值，更新需要匹配的字串
				j = next[j - 1];
			}
			
			if (str.charAt(i) == str.charAt(j)) { // 找到前后缀相同，匹配值加一
				j++;
			}
			next[i] = j;
		}
		return next;

	}

}
