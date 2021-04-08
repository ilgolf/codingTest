package 복습;

import java.util.Scanner;

public class day1104_ATM2문제 {
	
	/*
	 * # ATM
	 * 1. 로그인
	 * . 로그인 후 재 로그인 불가
	 * . 로그아웃 상태에서만 이용 가능
	 * 2. 로그아웃
	 * . 로그인 후 이용가능
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int dbAcc1 = 1111;
		int dbPw1 = 1234;
		
		int dbAcc2 = 2222;
		int dbPw2 = 2345;
		
		int log = -1;						// -1(로그아웃), 1(dbAcc1로그인), 2(dbAcc2로그인)
		
		boolean run = true;
		while(run) {
			
			if(log == 1) {
				System.out.println("#로그인 상태 : " + dbAcc1 + "로그인 중....");
			}
			else if(log == 2) {
				System.out.println("#로그인 상태 : " + dbAcc2 + "로그인 중....");
			}
			else  {
				System.out.println("#로그인 상태 :" + "로그인 해주세요.");
			}
			System.out.println("1.로그인");
			System.out.println("2.로그아웃");
			System.out.println("0.종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				if(log == -1) {
					System.out.println("ID >>> ");
					int acc = sc.nextInt();
					System.out.println("PW >>> ");
					int pw = sc.nextInt();
					
					if(acc == dbAcc1 && pw == dbPw1) {
						log = 1;
						System.out.println(dbAcc1 + "님 환영합니다.");
					}
					else if(acc == dbAcc2 && pw == dbPw2) {
						log = 2;
						System.out.println(dbAcc2 + "님 환영합니다.");
					}
					else {
						System.out.println("로그인 실패 !");
					}
				}
				else {
					System.out.println("이미 로그인 중입니다.");
				}
			}
			else if(sel == 2) {
				if(log == -1) {
					System.out.println("이미 로그아웃 상태입니다.");
				}
				else {
					log = -1;
					System.out.println("안녕히 가십시오");
				}
			}
			else if(sel == 0) {
				run = false;
				System.out.println("프로그램 종료");
			}
		}
	}
}
