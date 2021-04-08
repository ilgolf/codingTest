package solution;

import java.util.Scanner;

public class Solution03 {
	Scanner sc = new Scanner(System.in);
	
	public int[][] solution(int[][] tetris) {
		int n = tetris.length;
		int m = tetris[0].length;
		
		System.out.println("ют╥б >>>> ");
		String enter = sc.next();
		
		int[][] ans;
		
		switch(enter) {
			case "left":
			case "right":
				ans = new int[m][n];
				break;
			 default:
	                throw new IllegalArgumentException();
		}
		
		for(int i=0; i<ans.length; i++) {
			for(int j=0; j<ans[i].length; j++) {
				switch(enter) {
					case "right":
						ans[i][j] = tetris[n-1-j][i];
						break;
					case "left":
						ans[i][j] = tetris[j][m-1-i];
						break;
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		
		Solution03 s = new Solution03();
		
		int tetris[][] = {
				{0,0,0,0},
				{0,0,0,1},
				{0,1,1,1},
				{0,0,0,0},
		};
		
		int[][] ans = s.solution(tetris);
		
		for(int i=0; i<ans.length; i++) {
			for(int j=0; j<ans[i].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
}
