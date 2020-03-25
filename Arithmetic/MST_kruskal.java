package Arithmetic;

/* 最小生成树问题
 * 
 * 克鲁斯卡尔算法：按权值大小的顺序选择 n+1 条边，并保证这 n+1 条边不构成回路
 */
public class MST_kruskal {

	private int edgeNum; // 边的个数
	private char[] vertexs; // 顶点数组
	private int[][] matrix; // 邻接矩阵
	private static final int INF = Integer.MAX_VALUE;// 两不可联通顶点间的权值

	public static void main(String[] args) {
		// 创建图
		char[] vertxs = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int[][] matrix = new int[][] { { 0, 5, 7, INF, INF, INF, 2 }, { 5, 0, INF, 9, INF, INF, 3 },
				{ 7, INF, 0, INF, 8, INF, INF }, { INF, 9, INF, 0, INF, 4, INF }, { INF, INF, 8, INF, 0, 5, 4 },
				{ INF, INF, INF, 4, 5, 0, 6 }, { 2, 3, INF, INF, 4, 6, 0 } };
		MST_kruskal kruskal = new MST_kruskal(vertxs, matrix);

		kruskal.show();

		kruskal.kruskal();
	}

	public MST_kruskal(char[] vertxs, int[][] matrix) {
		this.vertexs = vertxs.clone();
		this.matrix = matrix.clone();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[0].length; j++) {
				if (matrix[i][j] != INF)
					this.edgeNum++;
			}
		}
	}

	// 克鲁斯卡尔算法生成最小生成树
	public void kruskal() {
		int index = 0;// 最后结果的数组的索引
		int[] ends = new int[edgeNum]; // 保存已有最小生成树中每个点在最小生成树的终点
		// 结果数组，保存最小生成树
		EData[] rets = new EData[edgeNum];
		// 获取所有边的集合
		EData[] edgs = getEdges();
//		System.out.println(Arrays.toString(edgs));
		// 按权值排序
		sortEdges(edgs);
		// 遍历数组，添加边并判断是否生成回路
		for (int i = 0; i < edgeNum; i++) {
			// 获取该边的两点
			int p1 = getPosition(edgs[i].start);
			int p2 = getPosition(edgs[i].end);
			// 获取在已有最小生成树中的终点
			int m = getEnd(ends, p1);
			int n = getEnd(ends, p2);

			// 判断是否构成回路
			if (m != n) { // 非回路
				ends[m] = n; // 将m的终点保存
				rets[index++] = edgs[i]; // 将边加入数组
			}
		}

		// 显示最小生成树
		System.out.println("最小生成树为");
		for (int i = 0; i < index; i++) {
			System.out.println(rets[i]);
		}
	}

	// 显示邻接矩阵
	public void show() {
		System.out.println("邻接矩阵为: \n");
		for (int i = 0; i < vertexs.length; i++) {
			for (int j = 0; j < vertexs.length; j++) {
				System.out.printf("%12d", matrix[i][j]);
			}
			System.out.println();// 换行
		}
	}

	// 对边进行排序处理
	private void sortEdges(EData[] edges) {
		for (int i = 0; i < edges.length - 1; i++) {
			for (int j = 0; j < edges.length - 1 - i; j++) {
				if (edges[j].weight > edges[j + 1].weight) {// 交换
					EData tmp = edges[j];
					edges[j] = edges[j + 1];
					edges[j + 1] = tmp;
				}
			}
		}
	}

	// 获取顶点对应的下标
	private int getPosition(char ch) {
		for (int i = 0; i < vertexs.length; i++) {
			if (vertexs[i] == ch) {
				return i;
			}
		}
		return -1;
	}

	// 获取图中的边，用于遍历已有数组
	private EData[] getEdges() {
		int index = 0;
		EData[] edges = new EData[edgeNum];
		for (int i = 0; i < vertexs.length; i++) {
			for (int j = i + 1; j < vertexs.length; j++) {
				if (matrix[i][j] != INF) {
					edges[index] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
					index++;
				}
			}
		}
		return edges;
	}

	// 获取下标为i的顶点的终点，判断是否产生回路
	private int getEnd(int[] ends, int i) {
		while (ends[i] != 0) {
			i = ends[i];
		}
		return i;
	}

}

//带权值的边
class EData {
	char start; // 点1
	char end; // 点2
	int weight; // 权值

	public EData(char start, char end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	public String toString() {
		return " <" + start + " , " + end + " >= " + weight + "";
	}

}
