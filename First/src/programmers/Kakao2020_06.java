package programmers;

import java.util.*;

public class Kakao2020_06 {
	
	static final int INF = 987654321; // 최솟값을 위해 무한대 지정
	int N, MinCnt; // 외벽의 길이, 최소개수
	int[] Week; // 취약점
	int[] Dist; // 거리
	
	// 위치를 하나씩 올려가며 탐색
	void solve(int cnt, int pos, int checked) {
		if(cnt > Dist.length) return;
		if(cnt >= MinCnt) return;
		
		// 취약 지점 까지 탐색
		for(int i=0; i<Week.length; i++) {
			int nextPos = (pos + i) % Week.length;  // 맨 끝에서 0 으로 갈 수 있는 상황이 생기기때문에
			int diff = Week[nextPos] - Week[pos];  // 이동한 거리 
			
			if(nextPos < pos) diff += N;   // 만약 0을 지나가면 N을 더해주어 한바퀴 돌았을 경우 
			
			if(diff > Dist[Dist.length - cnt]) break; // 이동할 수 없는 거리보다 더 크면 break

			checked|= 1 << nextPos; // 방문한곳은 비트 켜주기
		}
		
		if(checked == (1 << Week.length) - 1) {  // 모든 비트가 켜져있다면 모두 방문한 경우
			MinCnt = cnt;  // 갱신
			return;
		}
		
		for(int i=0; i<Week.length; i++) {
			if((checked & (1 << i)) != 0) continue;  // 이미 방문 했었다면 돌아가기
			
			solve(cnt + 1, i, checked); // 재귀함수 돌리기
		}
	}
	
	public int solution(int n, int[] week, int[] dist) {
		Arrays.sort(dist);
		N = n;
		Week = week;
		Dist = dist;
		MinCnt = INF;
		
		for(int i=0; i<Week.length; i++) {
			solve(1, i, 0);
		}
		
		if(MinCnt == INF) return -1;  // 탐색 했지만 경우의 수가 없는 경우
		
        return MinCnt;
    }

	public static void main(String[] args) {
		int n = 12;
		int[] week = {1, 5, 6, 10};
		int[] dist = {1, 2, 3, 4};
		
		Kakao2020_06 k = new Kakao2020_06();
		
		int answer = k.solution(n, week, dist);
		System.out.println(answer);
	}
}
