package codingTest;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_realize04 {
	
	private static int N;
	private static int M;
	private static int[][] map;
	private static boolean[][] check;
	private static int dir;
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	
	// �ݽð� �������� ���� ���� ���ʱ��� �� ���Ҵٸ� �ٽ� ��ó���� �������� �ʱ�ȭ
	private static void turn_left() {
		dir -= 1;
		if(dir == -1) dir = 3;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new boolean[N][M];  // üŷ �迭
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken()); // ����
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 1;
		int turn_time = 0;
		
		while(true) {
			turn_left();  // �ѹ� ������ Ʋ���ش�
			int nx = x + dx[dir]; 
			int ny = y + dy[dir];
			
			// ���� �湮�� ���ϰ� �����Ͻ� �̵� 
			if(map[ny][nx] == 0 && !check[ny][nx]) {
				x = nx;
				y = ny;
				count ++;
				check[ny][nx] = true;
				turn_time = 0; // �湮 ������ turnȽ�� �ʱ�ȭ
				continue;
			} else {
				turn_time ++;
				
				// �������� ��� �̵������� ���� �Դ� ������ �̵�
				if(turn_time == 4) {
					nx = x - dx[dir];
					ny = y - dy[dir];
					
					// �̵��� ������ ������ �ٽ� �������� �����Ͽ� �̵�
					if(map[ny][nx] == 0) {
						x = nx;
						y = ny;
					} else {
						break;
					}
					// turn_time �ʱ�ȭ
					turn_time = 0;
				}
			}
		}
		System.out.println(count);
	}
}
