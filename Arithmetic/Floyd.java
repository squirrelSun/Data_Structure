package Arithmetic;

import java.util.Arrays;

/*
 * 弗洛伊德算法解决最短路径
 * 
 * 计算每两个点的最短路径
 */
public class Floyd {
	public static void main(String[] args) {
		char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		// 邻接矩阵
		int[][] matrix = new int[vertex.length][vertex.length];
		final int N = 65535;// 表示不可以连接
		matrix[0] = new int[] { 0, 5, 7, N, N, N, 2 };
		matrix[1] = new int[] { 5, 0, N, 9, N, N, 3 };
		matrix[2] = new int[] { 7, N, 0, N, 8, N, N };
		matrix[3] = new int[] { N, 9, N, 0, N, 4, N };
		matrix[4] = new int[] { N, N, 8, N, 0, 5, 4 };
		matrix[5] = new int[] { N, N, N, 4, 5, 0, 6 };
		matrix[6] = new int[] { 2, 3, N, N, 4, 6, 0 };

		graph01 graph01 = new graph01(vertex.length, matrix, vertex);
		graph01.floyd();
		graph01.show();
	}
}

class graph01 {
	private int[][] dis; // 各顶点至其他顶点的距离
	private int[][] pre; // 前驱点

	// 构造器
	public graph01(int length, int[][] matrix, char[] vertex) {
		this.dis = matrix;
		this.pre = new int[length][length];

		for (int i = 0; i < length; i++) {
			Arrays.fill(pre[i], i);
		}
	}

	// 弗洛伊德算法
	public void floyd() {
		for (int k = 0; k < dis.length; k++) { // 中间顶点
			for (int i = 0; i < dis.length; i++) { // 开始顶点
				for (int j = 0; j < dis.length; j++) { // 结束顶点
					if (dis[i][k] + dis[k][j] < dis[i][j]) {
						dis[i][j] = dis[i][k] + dis[k][j]; // 取最短路径
						pre[i][j] = pre[k][j]; // 更新前驱节点
					}
				}
			}
		}
	}

	// 显示
	public void show() {
		char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		for (int k = 0; k < dis.length; k++) {
			// 先将pre数组输出的一行
			for (int i = 0; i < dis.length; i++) {
				System.out.print(vertex[pre[k][i]] + " ");
			}
			System.out.println();
			// 输出dis数组的一行数据
			for (int i = 0; i < dis.length; i++) {
				System.out.print("(" + vertex[k] + "->" + vertex[i] + "=" + dis[k][i] + ") ");
			}
			System.out.println();
			System.out.println();

		}
	}
}
