package programmers_step1ans;

import java.util.*;

public class Solution {
	public boolean solution(String[] phone_book) {

		Arrays.sort(phone_book, (o1, o2) -> {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				else {
					return Integer.compare(o1.length(), o2.length());
				}
		});
		
		String str = phone_book[0];
		
		for(int i=1; i<phone_book.length; i++) {
			if(phone_book[i].startsWith(str)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		
		Solution s = new Solution();
		
		boolean answer = s.solution(phone_book);
		System.out.println(answer);
	}
}
