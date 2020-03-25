package Arithmetic;

/* 最小生成树问题
 * 
 * 普利姆算法：任选开始节点，依次加入的节点为与已选择的店相连的权值最小的边，共有 n-1 条边
 */
public class MST_prim {

	private static final int INF = Integer.MAX_VALUE;// 两不可联通顶点间的权值

	public static void main(String[] args) {
		// 创建图
		char[] data = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int verxs = data.length;
		int[][] weight = new int[][] { { 0, 5, 7, INF, INF, INF, 2 }, { 5, 0, INF, 9, INF, INF, 3 },
				{ 7, INF, 0, INF, 8, INF, INF }, { INF, 9, INF, 0, INF, 4, INF }, { INF, INF, 8, INF, 0, 5, 4 },
				{ INF, INF, INF, 4, 5, 0, 6 }, { 2, 3, INF, INF, 4, 6, 0 } }; // 权值10000表示不连通
		MGraph graph = new MGraph(verxs);
		minTree minTree = new minTree();
		minTree.creatGraph(graph, verxs, data, weight);

		System.out.println("邻接矩阵为");
		minTree.show(graph);

		// 普利姆算法生成最小生成树
		System.out.println("最小生成树为");
		minTree.prim(graph, 0);
		System.out.println("-----------"); // 不同的起始点路径生成顺序不同，总最小权值相同
		minTree.prim(graph, 5);

	}

}

//最小生成树
class minTree {
	// 普利姆算法
	public void prim(MGraph graph, int vertx) {
		int[] visited = new int[graph.vertexs]; // 标记节点是否被访问过，默认为0，表示未访问
		// 将当前节点标记为已访问
		visited[vertx] = 1;
		// 记录连接的顶点的下标
		int h1 = -1;
		int h2 = -1;
		int minWeight; // 记录遍历的最小权值
		for (int m = 1; m < graph.vertexs; m++) { // n个顶点有n-1条边
			minWeight = 10000;
			for (int i = 0; i < graph.vertexs; i++) {
				for (int j = 0; j < graph.vertexs; j++) {
					// 第i个已访问，第j个未访问，并且权值最小
					if (visited[i] == 1 && visited[j] == 0 && minWeight > graph.weight[i][j]) {
						minWeight = graph.weight[i][j];
						h1 = i;
						h2 = j;
					}
				}
			}
			// 输出最小权值边
			System.out.println(" < " + graph.data[h1] + " , " + graph.data[h2] + " >= " + minWeight);
			// 标记为已访问节点
			visited[h2] = 1;
		}
	}

	// 获取图的邻接矩阵
	public void creatGraph(MGraph graph, int verxs, char[] data, int[][] weight) {
		for (int i = 0; i < verxs; i++) {
			graph.data[i] = data[i];
			for (int j = 0; j < verxs; j++) {
				graph.weight[i][j] = weight[i][j];
			}
		}
	}

	// 打印邻接矩阵
	public void show(MGraph graph) {
		for (int i = 0; i < graph.weight.length; i++) {
			for (int j = 0; j < graph.weight[0].length; j++) {
				System.out.printf("%12d", graph.weight[i][j]);
			}
			System.out.println();// 换行
		}
	}

}

//邻接矩阵
class MGraph {
	int vertexs; // 表示图的节点数
	char[] data; // 表示存放的节点数据
	int[][] weight; // 邻接矩阵

	public MGraph(int verxs) {
		this.vertexs = verxs;
		data = new char[verxs];
		weight = new int[verxs][verxs];
	}
}
