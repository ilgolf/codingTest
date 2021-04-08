package º¹½À;

import java.util.stream.*;

public class Solution {
	public String solution(int[] numbers) {
		String answer = IntStream.of(numbers)
			.mapToObj(String::valueOf)
			.sorted((s1,s2) -> (s2 + s1).compareTo(s1+s2))
			.collect(Collectors.joining());
			
		if(answer.startsWith("0")) return "0";
		return answer;
	}

	public static void main(String[] args) {
		int[] numbers = { 6, 10, 2 };
		Solution s = new Solution();
		String answer = s.solution(numbers);
		System.out.println(answer);
	}
}
