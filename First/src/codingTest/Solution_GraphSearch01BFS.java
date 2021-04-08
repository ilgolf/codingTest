package codingTest;

import java.io.*;
import java.util.*;

public class Solution_GraphSearch01BFS {
	
	private static int N;
	private static int M;
	private static boolean[][] checked;
	private static int[][] map;
	private static int[][] moving = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static int count = 0;
	
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		checked[x][y] = true;
		queue.offer(new int[] {x, y});
		count ++;

		while(!queue.isEmpty()) {
			int curX = queue.peek()[0];
			int curY = queue.peek()[1];
			queue.poll();
			
			for(int i=0; i<moving.length; i++) {
				int nx = curX + moving[i][0];
				int ny = curY + moving[i][1];
				
				if(ny < 0 || ny >= M) continue;
				if(nx < 0 || nx >= N) continue;
				if(map[nx][ny] == 1) continue;
				if(checked[nx][ny]) continue;
				
				queue.offer(new int[] {nx, ny});
				checked[nx][ny] = true;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		checked = new boolean[N][M];
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0 && !checked[i][j]) {
					bfs(i, j);
				}
			}
		}
		System.out.println(count);
	}
}
