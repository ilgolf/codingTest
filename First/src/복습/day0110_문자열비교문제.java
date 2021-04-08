package 복습;

import java.util.Scanner;

public class day0110_문자열비교문제 {
	/*
	 * # 문자열 비교
	 * . equals() 메서드 사용없이 문자의 일치여부 비교
	 * 예)
	 * 코끼리
	 * 입력 = 티라노사우루스
	 * 출력 = false
	 */

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String name = "코끼리";

		System.out.print("동물 이름을 입력하세요 : "); // ex) 티라노사우루스
		String myName = scan.next();
		
		int cnt = 0;
		if(name.length() == myName.length()) {
			for(int i=0; i<name.length(); i++) {
				if(name.charAt(i) == myName.charAt(i)) {
					cnt++;
				}
			}
		}
		
		if(cnt == name.length()) {
			System.out.println("정답");
		}
		else {
			System.out.println("오답");
		}
	}
}
