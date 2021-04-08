package programmers_step1;

public class Solution03 {
	public int solution(int[] d, int budget) {
		int answer = 0;

		int sum = 0;
		int count = 0;
		for (int i = 0; i < d.length; i++) {
			sum += d[i];

			if (sum > budget) {
				count = i;
				break;
			}
			else if(sum == budget) {
				count = i+1;
				break;
			}
		}
		answer = count;
		return answer;
	}
	public static void main(String[] args) {
		int[] d = {2,2,3,3};
		int budget = 10;
		
		Solution03 s = new Solution03();
		
		int answer = s.solution(d, budget);
		System.out.println(answer);
	}
}
