package programmers_step2;

import java.util.*;

public class Solution_phone2 {
	
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<phone_book.length; i++) {
			map.put(phone_book[i], i);
		}
		
		for(int i=0; i<phone_book.length; i++) {
			for(int j=0; j<phone_book[i].length(); j++) {
				if(map.containsKey(phone_book[i].substring(0,j))) {   // containsKey를 이용하여 key값중 
					answer = false;									  // 접두어부분을 잘라내 동일하면 false 리턴
				}
			}
		}
		
		return answer;
	}
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		
		Solution_phone2 s = new Solution_phone2();
		
		boolean answer = s.solution(phone_book);
		System.out.println(answer);
	}
}
