package programmers_step1;

public class Solution_greedy {
	
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		answer = n;
		
		for(int i=0; i<lost.length; i++) {
			boolean rent = false;
			int j = 0;
			while(!rent) {
				if(j == reserve.length) break;
				if(lost[j] == reserve[j]) {
					reserve[j] = -1; rent = true;
				}
				else if(lost[i] - reserve[j] == 1) {
					reserve[j] = -1; rent = true;
				}
				else if(lost[i] - reserve[j] == -1) {
					reserve[j] = -1; rent = true;
				}
				else { j++; }
			}
			if(!rent) answer --;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {1, 3, 5};
		
		Solution_greedy s = new Solution_greedy();
		int answer = s.solution(n, lost, reserve);
		System.out.println(answer);
	}
}
