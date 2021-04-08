package programmers_step3;

import java.util.*;

public class Solution_BFS풀이 {
	
	class Position { // 위치 변수 를 선언해주기 위해 클래스 생성
		int x,y;
		
		Position(int x, int y) {  // 생성자 위치값을 받아야함
			this.x = x;
			this.y = y;
		}
		
		boolean isValid(int width, int height) {  // BFS 검사시 예외처리
			if(x < 0 || x >= width) return false;
			if(y < 0 || y >= height) return false;
			
			return true;
		}
	}

	public int solution(int[][] maps) {
		
		int size_y = maps.length;  
		int size_x = maps[0].length;
		
		// 방문시 처리할 변수와 이동할때마다 count 세기위한 변수를 설정
		Queue<Position> queue = new LinkedList<>();
		int[][] count = new int[size_y][size_x];
		boolean[][] checked = new boolean[size_y][size_x];
		
		// 시작점 찍기
		queue.offer(new Position(0, 0));
		count[0][0] = 1;
		checked[0][0] = true;
		while(!queue.isEmpty()) {  // 큐에 데이터가 다 빠질때까지 반복
			Position current = queue.poll();
			
			int currentCount = count[current.y][current.x]; // 현재 위치에 카운터 해주기 위한 변수
			
			final int[][] moving = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
			for(int i=0; i<moving.length; i++) {
				Position moved = new Position(current.x + moving[i][0], current.y + moving[i][1]);
				if(!moved.isValid(size_x, size_y)) continue;  // 범위초과시 종료
				if(checked[moved.y][moved.x]) continue;   // 이미 방문했을시 종료
				if(maps[moved.y][moved.x] == 0) continue; // 벽이 있을시 종료
				
				count[moved.y][moved.x] = currentCount + 1;
				checked[moved.y][moved.x] = true;
				queue.offer(moved); // 다음 위치 불러오기
			}
		}
		
		int answer = count[size_y-1][size_x-1]; // 도착했을때 루프문을 나오므로 맨뒤 배열의 숫자가 최단거리
		if(answer == 0) return -1; //반복문을 빠져나왔음에도 도착못했을시 -1 리턴
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[][] maps = {
				{1,0,1,1,1},
				{1,0,1,0,1},
				{1,0,1,1,1},
				{1,1,1,0,1},
				{0,0,0,0,1}
		};
		
		Solution_BFS풀이 s = new Solution_BFS풀이();
		
		int answer = s.solution(maps);
		System.out.println(answer);
	}
}