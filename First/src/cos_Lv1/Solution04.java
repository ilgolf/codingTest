package cos_Lv1;

import java.util.*;

public class Solution04 {

	public String solution(Integer[] num) {
		String answer = "";

		Map<Integer, Integer> hash = new LinkedHashMap<>();
		
		Arrays.sort(num, Collections.reverseOrder());
		
		for (int i = 0; i < num.length; i++) {
			hash.put(num[i], hash.getOrDefault(num[i], 0) + 1);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int key : hash.keySet()) {
			answer += key;
			answer += hash.get(key);
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Integer[] num = { 2, 4, 2, 3, 3, 3, 4 };

		Solution04 s = new Solution04();

		String answer = s.solution(num);
		System.out.println(answer);
	}
}
