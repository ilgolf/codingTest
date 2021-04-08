package solution;

import java.util.Scanner;

public class Solution04 {

	public int[][] solution(int[][] omok, int x, int y) {
		int[][] ans = new int[omok.length][omok[0].length];

		int cnt = 0;

		if (omok[y][x] == 0) {
			for (int i = -2; i < 3; i++) {
				if (y + i > 0 && x + i > 0 || y + i < omok.length && x + i < omok.length) {
					if (omok[y + i][x + i] == 1) {
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);

			if (cnt >= 4) {
				System.out.println("삼삼입니다.");
			} else {
				omok[y][x] = 1;
			}
		} else if (omok[y][x] == 1) {
			System.out.println("그 자리에 놓을 수 없습니다.");
		}

		for (int i = 0; i < omok.length; i++) {
			for (int j = 0; j < omok[i].length; j++) {
				ans[i][j] = omok[i][j];
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution04 s = new Solution04();

		int omok[][] = { { 0, 0, 0, 0, 0, 0, 0, }, { 0, 0, 0, 0, 0, 0, 0, }, { 0, 0, 0, 0, 0, 0, 0, },
				{ 0, 1, 1, 0, 1, 0, 0, }, { 0, 0, 0, 1, 0, 0, 0, }, { 0, 0, 0, 1, 0, 0, 0, },
				{ 0, 0, 0, 0, 0, 0, 0, } };

		int turn = 5;
		while (turn >= 0) {
			System.out.println("Y >>> ");
			int y = sc.nextInt();
			System.out.println("X >>> ");
			int x = sc.nextInt();

			int[][] ans = s.solution(omok, x, y);

			for (int i = 0; i < ans.length; i++) {
				for (int j = 0; j < ans[i].length; j++) {
					System.out.print(ans[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
