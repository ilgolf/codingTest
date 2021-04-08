package programmers;

import java.util.*;

public class Kakao2020_07 {
	
	// 쉽게 회전 하기위해 시계방향 설정
	static final int UP = 0;
	static final int RIGHT = 1;
	static final int DOWN = 2;
	static final int LEFT = 3;
	 
	int[][] moving = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};    // 이동 변수
	int[][][] mrot = {{{1, 1}, {1, -1}, {-1, -1}, {-1, 1}},  // 회전 변수
					 {{1, -1}, {-1, -1}, {-1, 1}, {1, 1}}};
	int[][][] mcor = {{{-1, 1}, {1, 1}, {1, -1}, {-1, -1}},  // 코너 확인하기위한 이동 변수
			 		 {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}}};
	
	class Point {
		Point (int row, int col, int dir, int time) {
			this.row = row; 
			this.col = col;
			this.dir = dir;
			this.time = time;
		}
		int row, col, dir, time;
	}
	
	int[][] Board;
	int N;
	Queue<Point[]> queue = new LinkedList<>();
	boolean[][][] checked = new boolean[100][100][4];
	
	// 예외처리
	boolean isValid(Point[] pt) {
		for(int i=0; i<2; i++) {
			if(pt[i].row < 0 || pt[i].row > N - 1 || pt[i].col < 0 || pt[i].col > N -1) 
				return false;
			if(Board[pt[i].row][pt[i].col] == 1) return false;
			if(checked[pt[i].row][pt[i].col][pt[i].dir] == true) return false;
		}
		return true;
	}
	
	// 회전 매서드
	int rotate(Point[] curr, int ccw, int idx) {
		Point[] newPt = new Point[2];
		int a = idx, b = (idx + 1) % 2 ;   // a 회전축, b 직접 회전하는 곳
		int dir = curr[a].dir; 
		
		// a가 회전
		newPt[0] = new Point(curr[a].row, curr[a].col, (curr[a].dir + 1) % 4, curr[a].time + 1);  // 시계방향 회전
		newPt[0] = new Point(curr[a].row, curr[a].col, (curr[a].dir + (ccw == 0 ? 1 : 3)) % 4, curr[a].time + 1);  // 반시계 방향 회전시
		
		// b가 회전
		newPt[1] = new Point(curr[b].row + mrot[ccw][dir][0], curr[b].col + mrot[ccw][dir][1], (curr[b].dir + (ccw == 0 ? 1 : 3)) % 4, curr[b].time + 1);
		
		if(isValid(newPt) == false) return 0; // 예외발생시 0 리턴
		if(Board[curr[a].row + mcor[ccw][dir][0]][curr[a].col + mcor[ccw][dir][1]] == 1) return 0;
		
		for(int i=0; i<2; i++) {
			if(newPt[1].row == N - 1 && newPt[i].col == N - 1) return newPt[i].time;  // 종착점 도착
			checked[newPt[i].row][newPt[i].col][newPt[i].dir] = true;  // 방문처리
		}
		
		queue.add(new Point[] {newPt[0], newPt[1]}); // 이게 회전시켜줌
		return 0;
	}
	
	public int solution(int[][] board) {
		Board = board;
		N = board.length;
		queue.add(new Point[] {new Point(0, 0, RIGHT, 0), new Point(0, 1, LEFT, 0)});
		checked[0][0][RIGHT] = true;
		checked[0][1][LEFT] = true;
		Point[] curr = new Point[2];
		Point[] newPt = new Point[2];
		
		while((curr = queue.poll()) != null) {
			
			// 이동
			for(int j=0; j<4; j++) {
				for(int i=0; i<2; i++) {
					newPt[i] = new Point(curr[i].row + moving[j][0], curr[i].col + moving[j][1], 
							curr[i].dir, curr[i].time + 1); 
				}
				 
				if(isValid(newPt) == false) continue; // 예외처리
				
				for(int i=0; i<2; i++) {
					if(newPt[i].row == N - 1 && newPt[i].col == N - 1) return newPt[i].time; // 종착점 도착
					checked[newPt[i].row][newPt[i].col][newPt[i].dir] = true; // 방문 처리
				}
				queue.add(new Point[] {newPt[0], newPt[1]});
			}
			
			// 회전
			for(int ccw = 0; ccw < 2; ++ccw) {
				for(int i=0; i<2; ++i) {
					int ret = rotate(curr, ccw, i);
					if(ret != 0)
						return ret;
				}
			}
		}
		
		// 이 전에 종착 하므로 아무거나 리턴
		return 0;
	}

	public static void main(String[] args) {
		int[][] board = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
		
		Kakao2020_07 k = new Kakao2020_07();
		
		int answer = k.solution(board);
		System.out.println(answer);
	}
}
