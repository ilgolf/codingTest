package cos_Lv1;

import java.util.*;

public class Solution04_정답2 {

	public String solution(Integer[] num) {
		String answer = "";

		Map<Integer, Integer> hash = new HashMap<>();

		for (int i = 0; i < num.length; i++) {
			hash.put(num[i], hash.getOrDefault(num[i], 0) + 1);
		}


		for (int key : hash.keySet()) {
			answer += key;
			answer += hash.get(key);
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution04_정답2 s = new Solution04_정답2();
		
		Integer[] num = { 2, 4, 2, 3, 3, 3, 4 };
		String answer = s.solution(num);
		StringBuilder sb = new StringBuilder(answer);
		sb.reverse();
		System.out.println(sb);
	}
}
