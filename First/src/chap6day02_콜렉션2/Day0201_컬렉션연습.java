package chap6day02_콜렉션2;

import java.util.*;

public class Day0201_컬렉션연습 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Vector<int[]> vec = new Vector<int[]>();

		int win = 0;

		for (int i = 0; i < 3; i++) {
			vec.add(new int[3]);
		}

		boolean turn = true;

		while (true) {

			if (win == 1) {
				System.out.println("P1 win !");
				break;
			} else if (win == 2) {
				System.out.println("P2 win !");
				break;
			}

			System.out.println("------------------------");
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (vec.get(i)[j] == 1) {
						System.out.print("O\t");
					} else if (vec.get(i)[j] == 2) {
						System.out.print("X\t");
					} else {
						System.out.print(vec.get(i)[j] + "\t");
					}
				}
				System.out.println("\n");
			}
			System.out.println("------------------------");
			System.out.print("y : ");
			int y = sc.nextInt();
			System.out.print("x : ");
			int x = sc.nextInt();

			if (turn) {
				vec.get(y)[x] = 1;
				turn = !turn;
			} else {
				vec.get(y)[x] = 2;
				turn = !turn;
			}

			// 세로 검사
			if (vec.get(y)[0] == 1 && vec.get(y)[1] == 1 && vec.get(y)[2] == 1) {
				win = 1;
			}
			if (vec.get(y)[0] == 2 && vec.get(y)[1] == 2 && vec.get(y)[2] == 2) {
				win = 2;
			}
			
			// 가로 검사
			if (vec.get(0)[x] == 1 && vec.get(1)[x] == 1 && vec.get(2)[x] == 1) {
				win = 1;
			}
			if (vec.get(0)[x] == 2 && vec.get(1)[x] == 2 && vec.get(2)[x] == 2) {
				win = 2;
			}
			
			// 크로스 검사
			if (vec.get(0)[0] == 1 && vec.get(1)[1] == 1 && vec.get(2)[2] == 1) {
				win = 1;
			}
			if (vec.get(0)[0] == 2 && vec.get(1)[1] == 2 && vec.get(2)[2] == 2) {
				win = 2;
			}
			if (vec.get(0)[2] == 1 && vec.get(1)[1] == 1 && vec.get(2)[0] == 1) {
				win = 1;
			}
			if (vec.get(0)[2] == 2 && vec.get(1)[1] == 2 && vec.get(2)[0] == 2) {
				win = 2;
			}
		}
	}
}
