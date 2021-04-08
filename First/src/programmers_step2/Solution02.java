package programmers_step2;

import java.util.*;

public class Solution02 {
	public String solution(int[] numbers) {
		String answer = "";

		int[] check = new int[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] / 10 != 0) {
				check[i] = numbers[i] % 10;
			} else {
				check[i] = numbers[i];
			}
		}

		for (int i = 0; i < check.length; i++) {
			for (int j = 1; j < check.length; j++) {
				if (check[i] < check[j]) {

					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}

		for (int i = 0; i < numbers.length; i++) {
			answer += numbers[i];
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution02 s = new Solution02();
		int[] numbers = { 6, 10, 2 };

		String answer = s.solution(numbers);

		System.out.println(answer);
	}
}
