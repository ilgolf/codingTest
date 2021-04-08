package 복습;

import java.util.Random;
import java.util.Scanner;

public class day0109_타자연습2문제 {
	/*
	 * # 타자연습 게임[2단계]
	 * 1. 문제를 섞는다.(shuffle)
	 * 2. 순서대로 문제를 출제하고, 문제를 다 맞추면 게임 종료
	 * 3. 단 문제를 출제할 때, 단어의 랜덤한 위치 한 곳만 *로 출력
	 * 예)
	 * 문제 : mys*l
	 * 입력 : mysql	<--- 정답을 맞추면, 다음 문제 제시
	 * 문제 : *sp
	 * 입력 : jsp
	 * ...
	 */
	
	public static void main(String[] args) {
		String[] words = {"java", "mysql", "jsp", "spring"};
		
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		for(int i=0; i<words.length; i++) {
			int r = ran.nextInt(words.length);
			
			String temp = words[0];
			words[0] = words[r];
			words[r] = temp;
		}
		
		int i = 0;
		while(i < words.length) {
			int r = ran.nextInt(words.length);
			
			for(int j=0; j<words[i].length(); j++) {
				if(j == r) {
					System.out.print("*");
				}
				else if(j != r) {
					System.out.print(words[i].charAt(j));
				}
			}
			System.out.println();
			
			System.out.println("정답 >>> ");
			String str = sc.next();
			
			int cnt = 0;
			if(str.length() == words[i].length()) {
				for(int j=0; j<str.length(); j++) {
					if(str.charAt(j) == words[i].charAt(j)) {
						cnt++;
					}
				}
			}
			
			if(cnt == str.length()) {
				System.out.println("정답 !");
				i++;
			}
			else {
				System.out.println("오답!");
			}
		}
	}
}
