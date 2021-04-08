import java.io.*;
import java.util.*;

class dfsbfs�⺻���� {
	// �Լ����� ����� ������
	static int[][] check; // ���� �������
	static boolean[] checked; // Ȯ�� ����
	static int n; // ���� ����
	static int m; // ���� ����
	static int start; // ���� ����

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		check = new int[1001][1001];
		checked = new boolean[1001];

		// ���� ������� ����
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			check[x][y] = check[y][x] = 1;
		}
		
		dfs(start); // dfs ȣ��

		checked = new boolean[1001]; // Ȯ�λ��� �ʱ�ȭ
		System.out.println();

		bfs(); // bfs ȣ��
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