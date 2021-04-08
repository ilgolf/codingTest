package programmers_step1;

import java.util.stream.IntStream;
import java.util.*;

public class Solution02_강사풀이 {
	public int solution(int[] budgets, int M) {
		int answer = 0;
		Arrays.sort(budgets);
		
		int min = 0;
		int max = IntStream.of(budgets).max().orElse(0);
		
		while(min <= max) {
			final int MID = (min + max)/2;
			
			int sum = IntStream.of(budgets)
					.map(b -> Math.min(b, MID))
					.sum();
			
			if(sum <= M) {
				min = MID + 1;
				answer = MID;
			}
			else {
				max = MID + 1;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		int[] budgets = { 120, 110, 140, 150 };
		int M = 485;

		Solution02 s = new Solution02();

		int answer = s.solution(budgets, M);
		System.out.println(answer);
	}
}
