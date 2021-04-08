import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Watcha {
	
	static int N, M;
	static int[][] map;
	static int[][] moving = {{1,0},{0,1}};
	static int sum = 0;
	
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {x,  y});
		sum += map[x][y];
		
		while(true) {
			
			int curX = queue.peek()[0];
			int curY = queue.peek()[1];
			queue.poll();
			
			if(curX == 4 && curY == 2) {
				sum += map[curX][curY];
				break;
			}
			
			for(int i=0; i<moving.length; i++) {
				int nX = curX + moving[i][0];
				int nY = curY + moving[i][1];
				
				if(nX >= 0 && nY >= 0 && nX < M && nY <N) {
					if(map[curX][nY] > map[nX][curY]) {
						queue.offer(new int[] {curX, nY});
						sum += map[curX][nY];
					} else if(map[curX][nY] <= map[nX][curY]) {
						queue.offer(new int[] {nX, curY});
						sum += map[nX][curY];
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		
		for(int i=0; i<map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(0, 0);
		System.out.println(sum);
	}
}