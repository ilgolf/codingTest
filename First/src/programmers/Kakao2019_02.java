package programmers;

import java.util.*;

public class Kakao2019_02 {
	class Stage implements Comparable<Stage> {
		public int id;  // ���̵�
		public double fail; // ������
		
		public Stage(int id, double fail) {
			this.id = id;
			this.fail = fail;
		}
		
		@Override
		public int compareTo(Stage o) {  // ������ ���� ������ ����
			if(fail < o.fail) {
				return -1;
			}
			if(fail > o.fail) {
				return 1;
			}
			return 0;
		}
	}
	
	public int[] solution(int N, int[] stages) {
		int nPlayers = stages.length;
		int[] arr = new int[N + 2]; // 1���� �������� N + 1 ���� �ֱ⶧�� 
		
		for(int val : stages) arr[val] ++;  // �������� ���� 
		
		int remain = nPlayers;
		List<Stage> sta = new ArrayList<>();
		for(int i = 1; i<=N; i++) {
			
			// ���������� ���������� ���� Ŭ�������� ���� �÷��̾��� �� / ���������� ������ �÷��̾� ��
			double fail = (double) arr[i] / (remain -= arr[i]); 
			
			Stage s = new Stage(i, fail);
			sta.add(s);  // �迭�� ��ġ�� ������ ����
		}
		
		// ����
		Collections.sort(sta, Collections.reverseOrder());
		
		int[] answer = new int[N];
		
		for(int i=0; i<N; i++) {
			answer[i] = sta.get(i).id; // ���̵� ���� ���信 ����
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		
		Kakao2019_02 k = new Kakao2019_02();
		int[] answer = k.solution(N, stages);
		System.out.println(Arrays.toString(answer));
	}
}