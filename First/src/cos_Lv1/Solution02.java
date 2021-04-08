package cos_Lv1;

public class Solution02 {
	
	public int solution(int K, String[] words) {
		int answer = 0;
		String data = "";
		
		int count = 0;
		for(int i=0; i<words.length; i++) {
			int tempCount = count;
			
			count += words[i].length();
			
			if(count == 10) {
				data += words[i];
				data += "\n";
				count = 0;
			}
			else if(count > 10) {
				for(int j=tempCount; j<K; j++) {
					data += "_";
				}
				data += "\n";
				count = 0;
				i -= 1;
			}
			else {
				data += words[i];
				if(i < words.length - 1) {
					data += "_";
					count += 1;
				}
			}
		}
		System.out.println(data);
		String[] token = data.split("\n");
		answer = token.length;
		
		return answer;
	}

	public static void main(String[] args) {
		int K = 10;
		String[] words = {"nice", "happy", "hello", "world", "hi"};
		Solution02 s = new Solution02();
		
		int answer = s.solution(K, words);
		System.out.println(answer);
	}
}
