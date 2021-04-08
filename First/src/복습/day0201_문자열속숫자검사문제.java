package 복습;

import java.util.Scanner;

public class day0201_문자열속숫자검사문제 {
	/*
	 * # 문자열 속 숫자검사
	 * 예) adklajsiod
	 * 	     문자만 있다.
	 * 예) 123123
	 *    숫자만 있다.
	 * 예) dasd12312asd
	 *    문자와 숫자가 섞여있다.
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		char[] check = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		
		System.out.print("입력 : ");
		String text = scan.next();
		
		int cnt = 0;
		for(int i=0; i<text.length(); i++) {
			for(int j=0; j<check.length; j++) {
				if(text.charAt(i) == check[j]) {
					cnt++;
				}
			}
		}
		
		if(cnt == text.length()) {
			System.out.println("숫자로만 이루어져있다.");
		}
		else if(cnt == 0) {
			System.out.println("문자로만 이루어져있다.");
		}
		else {
			System.out.println("섞여있다.");
		}
	}

}
