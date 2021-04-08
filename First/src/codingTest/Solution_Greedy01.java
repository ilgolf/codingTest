package codingTest;

import java.util.Arrays;

public class Solution_Greedy01 {
	
	public int[] solution(int n) {
		int[] answer = {};
		
		answer = new int[4];
		int[] last_money = {500, 100, 50, 10};
		
		for(int i=0; i<4; i++) {
			answer[i] = n/last_money[i];
			n = n%last_money[i];
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int n = 15560;
		Solution_Greedy01 s = new Solution_Greedy01();
		
		int[] answer = s.solution(n);
		
		System.out.println(Arrays.toString(answer));
	}
}
