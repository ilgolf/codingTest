package programmers;

public class Kakao2019_07 {
	int N;
	int[][] Board;
	
	//  0, 0 인덱스부터 빈칸 바로위까지 0일 경우 true 리턴
	boolean canFill(int row, int col) {
		for(int i=0; i<row; i++) {
			if(Board[i][col] != 0) return false;
		}
		return true;
	}
	
	// 블록 한 종류에 2개의 블록을 채우기 
	boolean find(int row, int col, int h, int w) {
		int emtycount = 0;
		int lastVal = -1;
		
		for(int r = row; r<row + h; r++) {
			for(int c = col; c<col + w; c++) {
				if(Board[r][c] == 0) {
					if(!canFill(r, c)) return false;
					if(++emtycount > 2) return false; // 2개 이상이 채워지는경우 한 종류에 블럭이 사각형이 된게 아님
				}
				else {
					if(lastVal != -1 && lastVal != Board[r][c]) return false; // 2종류 이상의 블록의 일부가 직사각형이 되는 예외 처리
					lastVal = Board[r][c];
				}
			}
		}
		
		// 이중포문을 빠져 나오면 정상적인 직사각형이므로 삭제 후 true 리턴
		for(int r = row; r<row + h; ++r) {
			for(int c = col; c<col + w; ++c) {
				Board[r][c] = 0;
			}
		}
		return true;
	}

	public int solution(int[][] board) {
		Board = board;
		N = board.length;
		
		int answer = 0;
		int cnt;
		
		// 처음에 무조건 한번은 실행 되야하므로 do while로 루프 처리
		do {
			cnt = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i <= N-2 && j <= N-3 && find(i, j, 2, 3)) {
						++ cnt;
					} else if(i <= N-3 && j <= N-2 && find(i, j, 3, 2)) {
						++ cnt;
					}
				}
			}
			answer += cnt;
		} while(cnt != 0);
		
		return answer;
	}

	public static void main(String[] args) {
		int[][] board = {
		                 {0,0,0,0,0,0,0,0,0,0},
		                 {0,0,0,0,0,0,0,0,0,0},
		                 {0,0,0,0,0,0,0,0,0,0},
		                 {0,0,0,0,0,0,0,0,0,0},
		                 {0,0,0,0,0,0,4,0,0,0},
		                 {0,0,0,0,0,4,4,0,0,0},
		                 {0,0,0,0,3,0,4,0,0,0},
		                 {0,0,0,2,3,0,0,0,5,5},
		                 {1,2,2,2,3,3,0,0,0,5},
		                 {1,1,1,0,0,0,0,0,0,5}
		       };
		
		Kakao2019_07 k = new Kakao2019_07();
		int answer = k.solution(board);
		System.out.println(answer);
	}
}
