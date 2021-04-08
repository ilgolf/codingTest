package 복습;

import java.util.Scanner;

public class day1102_쇼핑몰뒤로가기문제 {

	/*
	 * # 쇼핑몰 뒤로가기
	 * 
	 * 문제) 쇼핑몰메인메뉴에서 남성의류를 선택해서 뒤로가기 누르기전까지 남성의류 페이지 를 유지할려고한다. 힌트) 개층 별로 반복문을 추가
	 * 해주면된다. 1. 남성의류 1) 티셔츠 2) 바지 3) 뒤로가기 2. 여성의류 1) 가디건 2) 치마 3) 뒤로가기 3. 종료
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("===== Home Menu =====");
			System.out.println("1. Men style");
			System.out.println("2. Women style");
			System.out.println("0. exit");
			System.out.println("select Menu >>> ");
			int sel = sc.nextInt();

			if (sel == 1) {
				while (true) {
					System.out.println("===== Men =====");
					System.out.println("1. T-shirts");
					System.out.println("2. pants");
					System.out.println("0. return");

					System.out.println("select Menu >>> ");
					int choice = sc.nextInt();

					if (choice == 0) {
						System.out.println("return");
						break;
					}
				}
			} else if (sel == 2) {
				while (true) {
					System.out.println("===== Women =====");
					System.out.println("1. Cardigan");
					System.out.println("2. skirt");
					System.out.println("0. return");
					
					System.out.println("select Menu >>> ");
					int choice = sc.nextInt();
					
					if (choice == 0) {
						System.out.println("return");
						break;
					}
				}
			} else if (sel == 0) {
				System.out.println("exit");
				break;
			}
		}
	}
}
