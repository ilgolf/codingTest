import java.io.*;
import java.util.*;

class dfsbfs기본문법 {
	// 함수에서 사용할 변수들
	static int[][] check; // 간선 연결상태
	static boolean[] checked; // 확인 여부
	static int n; // 정점 개수
	static int m; // 간선 개수
	static int start; // 시작 정점

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		check = new int[1001][1001];
		checked = new boolean[1001];

		// 간선 연결상태 저장
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			check[x][y] = check[y][x] = 1;
		}
		
		dfs(start); // dfs 호출

		checked = new boolean[1001]; // 확인상태 초기화
		System.out.println();

		bfs(); // bfs 호출
	}

	// dfs
	public static void dfs(int i) {
		checked[i] = true;
		System.out.print(i + " ");

		for (int j = 1; j <= n; j++) {
			if (check[i][j] == 1 && checked[j] == false) {
				dfs(j);
			}
		}
	}

	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		checked[start] = true;
		System.out.print(start + " ");

		while (!queue.isEmpty()) {
			int temp = queue.poll();

			for (int j = 1; j <= n; j++) {
				if (check[temp][j] == 1 && checked[j] == false) {
					queue.offer(j);
					checked[j] = true;
					System.out.print(j + " ");
				}
			}
		}
	}
}