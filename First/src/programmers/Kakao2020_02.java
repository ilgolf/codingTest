package programmers;

import java.util.*;

public class Kakao2020_02 {
	int pos; // ??????????ȣ?? ?????? ??ġ
	
	// ???????? ??ȣ Ž??
	boolean isCorrect(String str) {
		boolean ret = true;
		int left = 0, right = 0;
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				left ++;
				stack.push('(');
			} else {
				right ++;
				if(stack.isEmpty()) ret = false;
				else stack.pop();
			}
			if(left == right) { // ???????? ??ȣ
				pos = i + 1;
				return ret;
			}
		}
		
		return true;
	}
	
	public String solution(String p) {
		if(p.isEmpty()) return p;  // 1?ܰ? 
		
		// 2?ܰ?
		boolean correct = isCorrect(p);
		String u = p.substring(0, pos);
		String v = p.substring(pos, p.length());
		
		// 3?ܰ?
		if(correct) {
			return u + solution(v); // 3 - 1 ?????????? ????
		}
		
		// 4?ܰ?
		String answer = "(" + solution(v) + ")";  // 4-1, 4-2
		
		// 4-4
		for(int i=1; i<u.length() - 1; i++) {
			if(u.charAt(i) == '(') answer += ")";
			else answer += "(";
		} 
		
		// ???? ????
		return answer;
	}

	public static void main(String[] args) {
		String p = ")(";
		
		Kakao2020_02 k = new Kakao2020_02();
		
		String answer = k.solution(p);
		System.out.println(answer);
	}
}
