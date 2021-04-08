package 복습;

import java.util.Random;
import java.util.Scanner;

public class day0108_타자연습문제 {
	/*
	 * # 타자연습 게임[1단계]
	 * 1. 문제를 섞는다.(shuffle)
	 * 2. 순서대로 문제를 출제하고, 문제를 다 맞추면 게임 종료
	 * 예)
	 * 문제 : mysql
	 * 입력 : mydb
	 * 문제 : mysql
	 * 입력 : mysql	<--- 정답을 맞추면, 다음 문제 제시
	 * 문제 : jsp
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		String[] words = {"java", "mysql", "jsp", "spring"};
		
		// shuffle
		for(int i=0; i<1000; i++) {
			int r = ran.nextInt(words.length);
			
			String temp = words[0];
			words[0] = words[r];
			words[r] = temp;
		}
		
		
		int i = 0;
		
		while(i < words.length) {
			System.out.println((i+1) + ". " + words[i]);
			System.out.println("정답 입력 >>> ");
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
