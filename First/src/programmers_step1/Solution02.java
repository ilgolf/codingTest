package programmers_step1;

public class Solution02 {
	public int solution(int[] budgets, int M) {
		int answer = 0;
		int left = 0;  // 최솟값 
		int right = 0; // 최댓값
		
		// 최댓값 설정
		for (int budget : budgets) {
			if (budget > right) {
				right = budget;
			}
		}
		
		int middle = 0; // 중간값
		
		// 최솟값이 최댓값과 같아질때까지 반복
		while (left <= right) {
			long sum = 0;
			
			// 중간값 설정
			middle = (left + right) / 2;
			
			// 정해놓은 중간값보다 예산값이 크거나 같으면 sum에다 중간값을 더하고 작을시 예산을 더해줌 그러면
			// 자연스럽게 중간값 == 상한선이됨
			for (int budget : budgets) {
				if (budget >= middle) {
					sum += middle;
				} else {
					sum += budget;
				}
			}
			
			// 합쳤을때 총 예산보다 클때는 상한선을 1 낮춘값을 최댓값으로 해놓고 다시 탐색
			if (sum > M) {
				right = middle - 1;
			} else {
				// 합쳤을때 총예산보다 크거나 작을땐 상한값이 답이된다.최솟값에 상한선 + 1 로 설정해 더 큰값중 상한선 조건을 맞추는 값이 있는지 탐색
				answer = middle;
				left = middle + 1;
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