package Graph;

import java.util.Arrays;

public class TestGraph {

	public static void main(String[] args) {
		vertex v1=new vertex("A");
		vertex v2=new vertex("B");
		vertex v3=new vertex("C");
		vertex v4=new vertex("D");
		vertex v5=new vertex("E");
		graph g=new graph(5);
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		g.addVertex(v5);
		g.addEage("A", "C");
		g.addEage("B", "C");
		g.addEage("A", "B");
		g.addEage("B", "D");
		g.addEage("B", "E");
		
		for (int[] a:g.adjMat) {
			System.out.println(Arrays.toString(a));
		}
		
//		g.dfs();//深度优先遍历
		g.bfs();//广度优先遍历
	}
	
}
