package programmers_step2;

import java.util.*;

public class Solution_phone {

	public boolean solution(String[] phone_book) {
		boolean answer = true;
		
		// phone_book Á¤·Ä
		Arrays.sort(phone_book);
		// 
		String str = phone_book[0];

		int check = 0;
		for (int i = 1; i < phone_book.length; i++) {
			if (phone_book[i].startsWith(str)) {
				check += 1;
			}
		}
		if (check > 0) {
			answer = false;
		} else if (check == 0) {
			answer = true;
		}

		return answer;
	}

	public static void main(String[] args) {
		String[] phone_book = { "123", "456", "789" };
		Solution_phone s = new Solution_phone();

		boolean answer = s.solution(phone_book);
		System.out.println(answer);
	}
}