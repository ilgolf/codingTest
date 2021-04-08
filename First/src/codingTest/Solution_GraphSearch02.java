package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_GraphSearch02 {
	
	private static int n,m;
	private static boolean[][] checked;
	private static int[][] count;
	private static int[][] map;
	private static int[][] moving = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{x, y});
		checked[x][y] = true;
		count[x][y] = 1;
		
		while(!queue.isEmpty()) {
			int curX = queue.peek()[0];
			int curY = queue.peek()[1];
			
			int curCount = count[curX][curY];
			
			queue.poll();
			
			for(int i=0; i<moving.length; i++) {
				int nX = curX + moving[i][0];
				int nY = curY + moving[i][1];
				
				if(nX < 0 || nX >= n) continue;
				if(nY < 0 || nY >= m) continue;
				if(map[nX][nY] == 0) continue;
				if(checked[nX][nY]) continue;
				
				count[nX][nY] = curCount + 1;
				checked[nX][nY] = true;
				queue.offer(new int[] {nX, nY});
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		checked = new boolean[n][m];
		map = new int[n][m];
		count = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		bfs(0, 0);
		
		System.out.println(count[n-1][m-1]);
	}
}
