package 복습;

import java.util.Scanner;

public class day0202_단어검색문제 {

	/*
	 * # 단어 검색
	 * 1. 단어를 입력받아 text변수 문장 속에 해당 단어가 있는지 검색한다.
	 * 2. 단어가 존재하면 true
	 *    단어가 없으면 false를 출력한다.
	 */
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String text = "Life is too short.";
		System.out.println(text);
		
		System.out.print("검색할 단어를 입력하세요 : ");
		String word = scan.next();
		
		String[] temp = text.split(" ");
		
		boolean check = false;
		
		for(int i=0; i<temp.length; i++) {
			if(word.equals(temp[i])) {
				check = true;
			}
		}
		
		if(check) {
			System.out.println(check);
		}
		else if(!check) {
			System.out.println(false);
		}
	}
}
