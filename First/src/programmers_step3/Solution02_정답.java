package programmers_step3;

public class Solution02_정답 {
	public int solution(int n, int[] stations, int w) {
		int answer = 0;
		int left = 0;   // 범위외 왼쪽
		int right = 0;  // 범위외 오른쪽
		int baseL = 0;  // 범위 내 왼쪽
		int baseR = 0;  // 범위 내 오른쪽
		
		for(int i=0; i<stations.length; i++) {
			int base = stations[i]; // 기준점 설정
			left = baseR; //오른쪽 끝이 범위 바깥 기준 왼쪽이므로 left에 저장
			
			// 범위 지정 w 가 1인경우 양옆 1 
			baseL = base - w;
			baseR = base + w;
			
			// 범위 예외 설정
			if(baseL < 0) baseL = 0;
			if(baseR > n) baseR = n;
			
			// 
			right = baseL - 1;
			
			// right가 갖을수 없는 범위 예외처리
			if(right < 0) continue; 
			if(left == right) continue;
			if(left > right) continue;
			
			// 기지국이 미치지 않는 범위(right - left)에서 기지국의 범위를 나눠주고
			double temp = (double)(right - left)/((w*2) + 1);
			
			// 그 값이 딱떨어지면 그대로 answer값이 계속해서 더해주고 딱떨어지지 않는다면 + 1을 해준다.
			if(temp%1 == 0) { answer += (int)temp; }
			else { answer += (int)temp + 1; } 
		}
		
		// 만약 범위가 마지막을 채우지 못했다면 +1을 해준 상태에서 다시 아까와 같은 방식으로 answer에 계속해서 더해준다.
		if(baseR != n) {
			double temp = (double) (n - baseR) / ((w*2) + 1);
			if(temp % 1 == 0) { answer += (int)temp; }
			else { answer += ((int)temp) + 1; }
		}
		return answer;
	}
}