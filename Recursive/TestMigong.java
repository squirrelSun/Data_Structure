package Recursive;

//递归解决迷宫问题

public class TestMigong {

	// 地图
	static int[][] map = new int[8][7];

	public static void main(String[] args) {
		game();
		show();
		setWay(3 , 4);
		show();
		
	}

	//设置迷宫
	public static void game() {
		for (int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		for (int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		// 设置挡板, 1 表示
		map[3][1] = 1;
		map[3][2] = 1;
//		map[1][2] = 1;
		map[2][2] = 1;
	}
	
	// 输出地图
	public static void show() {
		System.out.println("地图的情况");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	//[1，1]开始[6，5]结束
	public static boolean setWay(int x , int y) {
		if(map[1][1] == 2)
			return true;
		else {
			if (map[x][y] == 0)	{	//未走过的点
				map[x][y] = 2;		//假定当前点可以走
				if (setWay(x + 1 , y)) {	//向下
					return true;
				}else if(setWay(x , y + 1)) {	//向右
					return true;
				} else if(setWay(x - 1 , y)) {	//向上
					return true;
				} else if(setWay(x , y - 1)) {	//向左
					return true;
				} 
				map[x][y] = 3;		//死路
				return false;
			}else {
				return false;
			}
		}
		
	}
	
}
