package programmers_step2;

import java.util.*;

public class Solution_greedy {

	public String solution(String number, int k) {
		StringBuilder sb = new StringBuilder(number);
		char[] result = new char[number.length()- k];
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<number.length(); i++) {
			char c = number.charAt(i);
			while(!stack.isEmpty() && stack.peek() < c && k-- > 0) {
				stack.pop();
			}
			stack.push(c);
		}
		
		for(int i=0; i<result.length; i++) {
			result[i] = stack.get(i);
		}
		return new String(result);
	}

	public static void main(String[] args) {
		String number = "1231234";
		int k = 3;

		Solution_greedy s = new Solution_greedy();

		String answer = s.solution(number, k);
		System.out.println(answer);
	}
}
