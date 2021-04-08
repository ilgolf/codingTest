package 복습;

import java.util.Scanner;

public class day0107_끝말잇기문제 {
	/*
	 * # 끝말잇기 게임
	 * 제시어 : 자전거
	 * 입력 : 거미
	 * 제시어 : 거미
	 * 입력 : 미술
	 * ...
	 */

	public static void main(String[] args) {
		String start = "자전거";
		
		Scanner sc = new Scanner(System.in);
		
		int turn = 0;
		
		while(true) {
			System.out.println("제시어 : " + start);
	
			System.out.println("끝말잇기 >>> ");
			String str = sc.next();
			
			char ch1 = start.charAt(start.length()-1);
			char ch2 = str.charAt(0);
			
			if(ch1 == ch2) {
				start = str;
				turn ++;
			}
			else {
				continue;
			}
			if(turn == 5) {
				break;
			}
		}
	}
}
