package programmers_step1;

public class Solution02 {
	public int solution(int[] budgets, int M) {
		int answer = 0;
		int left = 0;  // �ּڰ� 
		int right = 0; // �ִ�
		
		// �ִ� ����
		for (int budget : budgets) {
			if (budget > right) {
				right = budget;
			}
		}
		
		int middle = 0; // �߰���
		
		// �ּڰ��� �ִ񰪰� ������������ �ݺ�
		while (left <= right) {
			long sum = 0;
			
			// �߰��� ����
			middle = (left + right) / 2;
			
			// ���س��� �߰������� ���갪�� ũ�ų� ������ sum���� �߰����� ���ϰ� ������ ������ ������ �׷���
			// �ڿ������� �߰��� == ���Ѽ��̵�
			for (int budget : budgets) {
				if (budget >= middle) {
					sum += middle;
				} else {
					sum += budget;
				}
			}
			
			// �������� �� ���꺸�� Ŭ���� ���Ѽ��� 1 ���ᰪ�� �ִ����� �س��� �ٽ� Ž��
			if (sum > M) {
				right = middle - 1;
			} else {
				// �������� �ѿ��꺸�� ũ�ų� ������ ���Ѱ��� ���̵ȴ�.�ּڰ��� ���Ѽ� + 1 �� ������ �� ū���� ���Ѽ� ������ ���ߴ� ���� �ִ��� Ž��
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