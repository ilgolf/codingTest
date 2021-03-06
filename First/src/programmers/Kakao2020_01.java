package programmers;

public class Kakao2020_01 {
	
	static String processHit(int hit) {
		return hit > 1 ? String.valueOf(hit) : "";  // 문자열이 2개이상으로 짤릴경우 hit값 return 
	}

	public static int solution(String s) {
		if(s.length() == 1) return 1;
		
		int answer = 1001; // 최대길이 정답에 저장
		
		for(int i=1; i<=s.length() / 2; i++) { // 최대 잘라 넣어야 문자열 길이의 반을 넘지 못하므로 / 2
			String now, next = "", result = ""; 
			int hit = 1; // count변수
			for(int j=0; j<=s.length() / i; j++) { // 문자열을 i길이만큼 잘라 비교
				int start = j * i; // 문자열 시작점 
				int end = i * (j + 1) > s.length() ? s.length() : i * (j + 1); // 문자열 끝 끝점이 문자열 길이를 넘어서거나 같을시 s.length로 받음
				now = next;
				next = s.substring(start, end);
				
				if(now.equals(next)) {
					hit++; // count
				} else {
					result += (processHit(hit) + now);
					hit = 1;
				}
			}
			result += (processHit(hit) + next);
			answer = Math.min(answer, result.length()); // 최솟값 저장
		}
		return answer;
	}
	public static void main(String[] args) {
		String s = "aabbaccc";
		
		int answer = solution(s);
		System.out.println(answer);
	}
}
