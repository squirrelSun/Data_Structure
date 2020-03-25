package Arithmetic;

//动态规划解决0-1背包问题
public class Dynamic {

	public static void main(String[] args) {
		int[] w = new int[] { 1, 4, 3 }; // w物品重量
		int[] val = new int[] { 15, 30, 20 };// 物品价值
		int m = 4; // 背包容量
		int n = val.length; // 物品个数

		int[][] v = new int[n + 1][m + 1]; // 在前i个物品中能够装入容量为j的背包中的最大价值
		int[][] path = new int[n + 1][m + 1]; // 记录背包在对应最大价值时的存放情况

		// 初始化第一行第一列
		for (int i = 0; i < v.length; i++)
			v[i][0] = 0;
		for (int j = 0; j < v[0].length; j++)
			v[0][j] = 0;

		// 动态规划
		for (int i = 1; i < v.length; i++) { // 不处理第一行
			for (int j = 1; j < v[0].length; j++) { // 不处理第一列
				if (w[i - 1] > j) {
					v[i][j] = v[i - 1][j];
				} else {
//					v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
					if (v[i - 1][j] > val[i - 1] + v[i - 1][j - w[i - 1]]) {
						v[i][j] = v[i - 1][j];
					} else if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
						v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
						path[i][j] = 1;
					}
				}
			}
		}

		//获取商品种类
		int i = path.length - 1;
		int j = path[0].length - 1;
		while (i > 0 && j > 0) {
			if (path[i][j] == 1) {
				System.out.println("将第" + i + "个商品加入背包");
				j -= w[i - 1];
			}
			i--;
		}
	}

}
