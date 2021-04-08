package programmers;

public class Kakao2021_01 {
	public String solution(String new_id) {
		String answer = new_id.toLowerCase(); // 1�ܰ�
		
		answer = answer.replaceAll("[^-_.a-z0-9]", ""); // 2�ܰ�
		answer = answer.replaceAll("[.]{2,}", ".");  // 3�ܰ�
		answer = answer.replaceAll("^[.]|[.]$", ""); // 4�ܰ�
		
		System.out.println(answer);
		
		if(answer.equals("")) answer += "a"; // 5�ܰ�
		if(answer.length() > 15) {
			answer = answer.substring(0, 15);   
		}
		if(answer.endsWith(".")) {
			answer = answer.substring(0, answer.length() - 1);
		}

		
		System.out.println(answer);
		
		if(answer.length() <= 2) {
			while(answer.length() < 3) {
				answer += answer.charAt(answer.length() - 1);
			}
		}  // ������ �ܰ�
		return answer;
	}

	public static void main(String[] args) {
		String new_id = "abcdefghijklmn.p";
		
		Kakao2021_01 k = new Kakao2021_01();
		
		String answer = k.solution(new_id);
		System.out.println(answer);
	}
}
