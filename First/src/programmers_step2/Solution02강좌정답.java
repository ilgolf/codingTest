package programmers_step2;

import java.util.*;

public class Solution02°­ÁÂÁ¤´ä {
	public String solution(int[] numbers) {
		String[] strNums = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			strNums[i] = "" + numbers[i];
		}

		Arrays.sort(strNums, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

		String answer = "";
		for (String s : strNums) {
			answer += s;
		}

		if (answer.startsWith("0"))
			return "0";
		return answer;
	}

	public static void main(String[] args) {
		Solution02°­ÁÂÁ¤´ä s = new Solution02°­ÁÂÁ¤´ä();
		int[] numbers = { 6, 10, 2 };

		String answer = s.solution(numbers);

		System.out.println(answer);
	}
}