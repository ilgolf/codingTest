package cos_Lv1;

public class Solution {
	
	boolean isOut(int n, int y, int x) {
		if(x < 0 || y < 0 || x>=n || y>=n) {
			return true;
		}
		return false;
	}
	
	void setNumber(int n, int[][] garden, int y, int x) {
		if(!isOut(n, y, x)) {
			garden[y][x] = 1;
		}
	}
	boolean gameOver(int n, int[][] garden) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(garden[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	public int solution(int n, int[][] garden) {
		int answer = 0;
		
		while(true) {
			if(gameOver(n, garden)) {
				break;
			}
			answer ++;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(garden[i][j] == 1) {
						setNumber(n, garden, i-1, j);
						setNumber(n, garden, i, j + 1);
						setNumber(n, garden, i + 1, j);
						setNumber(n, garden, i, j-1);
					}
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int n = 3;
		int[][] garden = { 
				{ 1, 0, 1 }, 
				{ 0, 1, 0 }, 
				{ 1, 0, 1 }, 
			};

		Solution s = new Solution();

		int answer = s.solution(n, garden);
		System.out.println(answer);
	}
}
