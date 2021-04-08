package programmers;

public class Kakao2020_01 {
	
	static String processHit(int hit) {
		return hit > 1 ? String.valueOf(hit) : "";  // ���ڿ��� 2���̻����� ©����� hit�� return 
	}

	public static int solution(String s) {
		if(s.length() == 1) return 1;
		
		int answer = 1001; // �ִ���� ���信 ����
		
		for(int i=1; i<=s.length() / 2; i++) { // �ִ� �߶� �־�� ���ڿ� ������ ���� ���� ���ϹǷ� / 2
			String now, next = "", result = ""; 
			int hit = 1; // count����
			for(int j=0; j<=s.length() / i; j++) { // ���ڿ��� i���̸�ŭ �߶� ��
				int start = j * i; // ���ڿ� ������ 
				int end = i * (j + 1) > s.length() ? s.length() : i * (j + 1); // ���ڿ� �� ������ ���ڿ� ���̸� �Ѿ�ų� ������ s.length�� ����
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
			answer = Math.min(answer, result.length()); // �ּڰ� ����
		}
		return answer;
	}
	public static void main(String[] args) {
		String s = "aabbaccc";
		
		int answer = solution(s);
		System.out.println(answer);
	}
}