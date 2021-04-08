package codingTest;

import java.io.*;

public class Solution_realize03 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int x = str.charAt(0) - 'a' + 1; int y = str.charAt(1) - '0';
		int[][] move = {{2, 1}, {-2, 1}, {2, -1}, {-2, -1}, {1, 2}, {-1, 2}, {-1, -2}, {1, -2}};

		int cnt = 0;
		for(int i=0; i<move.length; i++) {
			int nx = x + move[i][0];
			int ny = y + move[i][1];
			if(nx > 0 && ny > 0 && nx < 8 && ny < 8) {
				cnt ++;
			}
		}
		System.out.println(cnt);
	}
}
