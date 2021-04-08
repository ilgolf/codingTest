import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Today_house {
	
	private static int N;
	private static int[][] map;
	private static boolean[][] checked;
	private static int[][] moving1 = {{1, 0},{-1, 0},{0, 1},{0, -1}};
	private static int count = 0;
	private static int count2 = 0;
	
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {x, y});
		checked[x][y] = true;
		count = 0;
		count ++;
		
		while(!queue.isEmpty()) {
			
			int curX = queue.peek()[0];
			int curY = queue.peek()[1];
			queue.poll();
			
			for(int i=0; i<moving1.length; i++) {
				int nX = curX + moving1[i][0];
				int nY = curY + moving1[i][1];
				
				if(nX >= 0 && nY >= 0 && nX < N && nY < N) {
					if(map[nX][nY] == 1 && !checked[nX][nY]) {
						queue.offer(new int[] {nX, nY});
						checked[nX][nY] = true;
						count ++;
					}
				}
			}
			if(count > 3) {
				count2 = count/4 + 1;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		checked = new boolean[N][N];
		int result1 = 0;
		int result2 = 0;
		
		for(int i=0; i<N; i++) {
			String[] temp = br.readLine().split("");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!checked[i][j] && map[i][j] == 1) {
					bfs(i, j);
					result1 += count;
				}
			}
		}
		result2 = count2;
		int total = result1 + result2;
		System.out.println("total: " + total);
		System.out.println("size[1]: " + result1);
		System.out.println("size[2]: " + result2);
	}
}