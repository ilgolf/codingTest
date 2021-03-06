package programmers;

import java.util.*;

public class Kakao2021_06 {
	int[][] Board;
	static final int INF = (int)1e9;
	static final int[][] moving = {{-1, 0},{1, 0},{0, -1},{0, 1}};

	class Point {
		Point(int r, int c, int t) {
			row = r;
			col = c;
			cnt = t;
		}

		int row, col, cnt;
	}
	
	
	// bfs Ž?? 
	int bfs(Point src, Point dst) {  // src ??????, dst ??????
		boolean[][] checked = new boolean[4][4];
		Queue<Point> queue = new LinkedList<>();
		queue.add(src);
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			if(curr.row == dst.row && curr.col == dst.col) {
				return curr.cnt;
			}
			
			for(int i=0; i<4; i++) {
				int nr = curr.row + moving[i][0], nc = curr.col + moving[i][1];
				
				if(nr < 0 || nr > 3 || nc < 0 || nc > 3) {
					continue;
				}
				
				if(!checked[nr][nc]) {
					checked[nr][nc] = true;
					queue.add(new Point(nr, nc, curr.cnt + 1));
				}
				
				for(int j=0; j<2; j++) {
					if(Board[nr][nc] != 0) { break; }
					if(nr + moving[i][0] < 0 || nr + moving[i][0] > 3 || nc + moving[i][1] < 0 || nc + moving[i][1] > 3) break;
					
					nr += moving[i][0];
					nc += moving[i][1];
				}
				
				if(!checked[nr][nc]) {
					checked[nr][nc] = true;
					queue.add(new Point(nr, nc, curr.cnt + 1));
				}
			}
		}
		
		return INF;
	}

	int permutate(Point src) {
		int ret = INF;
		for (int num = 1; num <= 6; ++num) {
			List<Point> list = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (Board[i][j] == num) {
						list.add(new Point(i, j, 0));
					}
				}
			}
			if (list.isEmpty()) continue;

			int one = bfs(src, list.get(0)) + bfs(list.get(0), list.get(1)) + 2;
			int two = bfs(src, list.get(1)) + bfs(list.get(1), list.get(0)) + 2;

			for (int i = 0; i < 2; i++) {
				Board[list.get(i).row][list.get(i).col] = 0;
				
			}
			ret = Math.min(ret, one + permutate(list.get(1)));
			ret = Math.min(ret, two + permutate(list.get(0)));
			
			for (int i = 0; i < 2; i++) {
				Board[list.get(i).row][list.get(i).col] = num;
			}
		}
		
		if(ret == INF) return 0;
		
		return ret;
	}

	public int solution(int[][] board, int r, int c) {
		Board = board;
		return permutate(new Point(r, c, 0));
	}

	public static void main(String[] args) {
		int[][] board = { { 1, 0, 0, 3 }, { 2, 0, 0, 0 }, { 0, 0, 0, 2 }, { 3, 0, 1, 0 } };

		int r = 1;
		int c = 0;

		Kakao2021_06 k = new Kakao2021_06();
		int answer = k.solution(board, r, c);
		System.out.println(answer);
	}
}
