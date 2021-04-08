package programmers_step2;

import java.util.*;

public class Solution02_정답 {

	public String solution(int[] numbers) {
		String answer = "";

		String[] result = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			result[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(result, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return ((o2 + o1).compareTo(o1 + o2));
			}
		});

		if (result[0].startsWith("0")) {
			return "0";
		}
		for (String a : result) {
			answer += a;
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] numbers = { 3, 30, 34, 5, 9 };

		Solution02_정답 s = new Solution02_정답();

		String answer = s.solution(numbers);

		System.out.println(answer);
	}
}
