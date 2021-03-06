package programmers;

import java.util.*;

public class Kakao2019_02 {
	class Stage implements Comparable<Stage> {
		public int id;  // 아이디
		public double fail; // 실패율
		
		public Stage(int id, double fail) {
			this.id = id;
			this.fail = fail;
		}
		
		@Override
		public int compareTo(Stage o) {  // 실패율 높은 순으로 정렬
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
		int[] arr = new int[N + 2]; // 1부터 스테이지 N + 1 까지 있기때문 
		
		for(int val : stages) arr[val] ++;  // 스테이지 저장 
		
		int remain = nPlayers;
		List<Stage> sta = new ArrayList<>();
		for(int i = 1; i<=N; i++) {
			
			// 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
			double fail = (double) arr[i] / (remain -= arr[i]); 
			
			Stage s = new Stage(i, fail);
			sta.add(s);  // 배열에 위치와 실패율 저장
		}
		
		// 정렬
		Collections.sort(sta, Collections.reverseOrder());
		
		int[] answer = new int[N];
		
		for(int i=0; i<N; i++) {
			answer[i] = sta.get(i).id; // 아이디만 따로 정답에 저장
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
