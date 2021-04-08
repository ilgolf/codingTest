package programmers_step2;

import java.util.*;
import java.util.stream.*;

public class Solution02Instram {
	public String solution(int[] numbers) {
		String answer = IntStream.of(numbers)
				.mapToObj(String::valueOf)
				.sorted((s1, s2) -> (s2 + s1).compareTo(s1+s2))
				.collect(Collectors.joining());
				
		if(answer.startsWith("0")) return "0";
		return answer;
	}
}