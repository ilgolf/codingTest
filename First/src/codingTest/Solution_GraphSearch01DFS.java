package codingTest;

import java.io.*;
import java.util.*;

public class Solution_GraphSearch01DFS {

	private static int N;
	private static int M;
	private static boolean[][] checked;
	private static int[][] map;
	private static int count = 0;

	private static boolean dfs(int x, int y) {
		if(x <= -1 || x >= N || y <= -1 || y >= M) return false;
		
		if(map[x][y] == 0 && !checked[x][y]) {
			checked[x][y] = true;
			
			dfs(x - 1, y);
			dfs(x, y - 1);
			dfs(x + 1, y);
			dfs(x, y + 1);
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		checked = new boolean[N][M];
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(dfs(i, j)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
