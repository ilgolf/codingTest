package programmers_step3;

import java.util.*;

public class Solution_BFS {
	static boolean[] checked; // 확인 여부
	static int[][] check;
	static int n;
	static int m;
	static int start; // 시작 정점
	static int count = 0;
	
	public int solution(int[][] map) {
		int answer = 0;
		start = 1;
		m = map.length;
		n = map[0].length;
		checked = new boolean[101];
		check = new int[101][101];
		
		for(int i=0; i<map.length; i++) {
			int x = 0; int y = 0;
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j] == 1) {
					y = i;
					x = j;
				}
			}
			check[y][x] = 1;
		}
		
		bfs();
		
		answer = count;
		
		return answer;
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		checked[start] = true;
		count ++;
		
		while(! queue.isEmpty()) {
			int temp = queue.poll();
			
			for(int j=1; j<=n; j++) {
				if(check[temp][j] == 1 && checked[j] == false) {
					queue.offer(j);
					checked[j] = true;
					count++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] map = {
				{1,0,1,1,1},
				{1,0,1,0,1},
				{1,0,1,1,1},
				{1,1,1,0,1},
				{0,0,0,0,1}
		};
		
		Solution_BFS s = new Solution_BFS();
		
		int answer = s.solution(map);
		System.out.println(answer);
	}
}
