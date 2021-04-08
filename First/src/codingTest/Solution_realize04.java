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
	
	// 반시계 방향으로 돈다 만약 북쪽까지 다 돌았다면 다시 맨처음인 서쪽으로 초기화
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
		check = new boolean[N][M];  // 체킹 배열
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken()); // 방향
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 1;
		int turn_time = 0;
		
		while(true) {
			turn_left();  // 한번 방향을 틀어준다
			int nx = x + dx[dir]; 
			int ny = y + dy[dir];
			
			// 만약 방문도 안하고 육지일시 이동 
			if(map[ny][nx] == 0 && !check[ny][nx]) {
				x = nx;
				y = ny;
				count ++;
				check[ny][nx] = true;
				turn_time = 0; // 방문 성공시 turn횟수 초기화
				continue;
			} else {
				turn_time ++;
				
				// 동서남북 모두 이동했을시 전에 왔던 곳으로 이동
				if(turn_time == 4) {
					nx = x - dx[dir];
					ny = y - dy[dir];
					
					// 이동할 육지가 있으면 다시 동서남북 선택하여 이동
					if(map[ny][nx] == 0) {
						x = nx;
						y = ny;
					} else {
						break;
					}
					// turn_time 초기화
					turn_time = 0;
				}
			}
		}
		System.out.println(count);
	}
}
