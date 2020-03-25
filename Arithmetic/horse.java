package Arithmetic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;

public class horse {

	private static int X;//列数
	private static int Y;//行数
	private static boolean visited[];//标记位置是否被访问
	private static boolean finished;//标记是否被遍历完成
	
	public static void main(String[] args) {
		X = 8;
		Y = 8;
		int row = 1 , column = 1;//指定开始位置
		int[][] chessboard = new int[X][Y];	//棋盘
		visited = new boolean[X * Y];
		
		long start = System.currentTimeMillis();
		traver(chessboard, row - 1, column - 1, 1);
		long end = System.currentTimeMillis();
		show(chessboard);
		System.out.println("用时：" + (end - start));
	}
						//		棋盘				当前行数	     当前列数		   第几步
	public static void traver(int[][] chessboard , int row , int column , int step) {
		chessboard[row][column] = step;
		visited[row * X + column] = true;	//标记为已访问
		//获取可以走的位置的集合
		ArrayList<Point> ps = next(new Point(column , row));
		
		//基于贪心算法优化，进行非递减排序，获取下一步可走位置最少的位置
		sort(ps);
		
		while(!ps.isEmpty()) {
			Point p = ps.remove(0);	//取出一个可以走位置
			//判断是否被访问
			if(!visited[p.y * X + p.x]) {	//说明未访问
				traver(chessboard, p.y, p.x, step + 1);
			}
		}
		//判断是否回溯完成过后全部被访问
		if (step < X * Y && !finished) {
			//修改为未访问状态，后续回溯使用
			chessboard[row][column] = 0;
			visited[row * X + column] = false;
		}else {
			finished = true;
		}
	}
	
	//根据当前位置，得到可以走的位置（最多8个）
	public static ArrayList<Point> next(Point curPoint){
		ArrayList<Point> ps = new ArrayList<>();
		Point p1 = new Point();
		if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
			ps.add(new Point(p1));
		}
		if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
			ps.add(new Point(p1));
		}
		if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
			ps.add(new Point(p1));
		}
		if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
			ps.add(new Point(p1));
		}
		if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
			ps.add(new Point(p1));
		}
		if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
			ps.add(new Point(p1));
		}
		if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
			ps.add(new Point(p1));
		}
		if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
			ps.add(new Point(p1));
		}
		return ps;
	}
	
	public static void sort(ArrayList<Point> ps) {
		ps.sort(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				//获取到o1的下一步的所有位置个数
				int count1 = next(o1).size();
				//获取到o2的下一步的所有位置个数
				int count2 = next(o2).size();
				if(count1 < count2) {
					return -1;
				} else if (count1 == count2) {
					return 0;
				} else {
					return 1;
				}
			}
		});
	}
	
	//显示棋盘
	public static void show(int[][] chessboard) {
		for (int[] row : chessboard) {
			for (int column : row) {
				System.out.print(column + "\t");
			}
			System.out.println();
		}
	}
	
}
