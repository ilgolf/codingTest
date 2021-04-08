package programmers;

import java.util.*;

public class Kakao2020_06 {
	
	static final int INF = 987654321; // �ּڰ��� ���� ���Ѵ� ����
	int N, MinCnt; // �ܺ��� ����, �ּҰ���
	int[] Week; // �����
	int[] Dist; // �Ÿ�
	
	// ��ġ�� �ϳ��� �÷����� Ž��
	void solve(int cnt, int pos, int checked) {
		if(cnt > Dist.length) return;
		if(cnt >= MinCnt) return;
		
		// ��� ���� ���� Ž��
		for(int i=0; i<Week.length; i++) {
			int nextPos = (pos + i) % Week.length;  // �� ������ 0 ���� �� �� �ִ� ��Ȳ�� ����⶧����
			int diff = Week[nextPos] - Week[pos];  // �̵��� �Ÿ� 
			
			if(nextPos < pos) diff += N;   // ���� 0�� �������� N�� �����־� �ѹ��� ������ ��� 
			
			if(diff > Dist[Dist.length - cnt]) break; // �̵��� �� ���� �Ÿ����� �� ũ�� break

			checked|= 1 << nextPos; // �湮�Ѱ��� ��Ʈ ���ֱ�
		}
		
		if(checked == (1 << Week.length) - 1) {  // ��� ��Ʈ�� �����ִٸ� ��� �湮�� ���
			MinCnt = cnt;  // ����
			return;
		}
		
		for(int i=0; i<Week.length; i++) {
			if((checked & (1 << i)) != 0) continue;  // �̹� �湮 �߾��ٸ� ���ư���
			
			solve(cnt + 1, i, checked); // ����Լ� ������
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
		
		if(MinCnt == INF) return -1;  // Ž�� ������ ����� ���� ���� ���
		
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
