package programmers;

public class Kakao2021_04 {

	public static final int INF = 40000000;  // 무한대의 값 
	public static int[][] d = new int[200][200]; // 최단 거리 테이블
	
	// 각 경로의 최저 비용을 찾기위해 탐색
	void floyd(int n) {
		for(int k=0; k<n; ++k) { // 경로
			for(int i=0; i<n; i++) { // 출발점
				for(int j=0; j<n; j++) {  // 도착점
					if(d[i][k] + d[k][j] < d[i][j]) {
						d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}
	}
	
	public int solution(int n, int s, int a, int b, int[][] fares) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i == j) { // 도착지점은 서로 겹치지 않는다.
					d[i][j] = 0;
				} else {
					d[i][j] = INF;
				}
			}
		}
		
		// 시작점, 도착점, 요금 테이블에 저장(1부터 idex 사용)
		for(int[] endge : fares) {
			d[endge[0] - 1][endge[1] - 1] = endge[2];
			d[endge[1] - 1][endge[0] - 1] = endge[2];
		}
		
		floyd(n);
		
		--s; // 1부터 idx를 쓴다
		--a;
		--b;
		
		int answer = INF;
		for(int k=0; k<n; k++) {
			answer = Math.min(answer, d[s][k] + d[k][a] + d[k][b]);
		}
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 6;  // 지점개수
		int s = 4;  // 출발점
		int a = 6;  // a의 출발점
		int b = 2;  // b의 출발점
		
		int[][] fares = {
				{4, 1, 10}, 
				{3, 5, 24}, 
				{5, 6, 2}, 
				{3, 1, 41}, 
				{5, 1, 24}, 
				{4, 6, 50}, 
				{2, 4, 66}, 
				{2, 3, 22},
				{1, 6, 25}	
		};
		
		Kakao2021_04 k = new Kakao2021_04();
		int answer = k.solution(n, s, a, b, fares);
		System.out.println(answer);
	}
}
