package programmers;

import java.util.*;

class Kakao2020_04 {
	class Trie {
		Trie[] child = new Trie[26];
		int count;   // ī��Ʈ ����
		int aletter = Character.getNumericValue('a'); // �ƽ�Ű�ڵ尪
		
		// ���ڿ��� Ʈ�������� ����
		void insert(String str) {
			Trie curr = this;
			for(char ch : str.toCharArray()) {
				curr.count++;
				int idx = Character.getNumericValue(ch) - aletter;  // �� ���ڿ� ��ġ�� �ƽ�Ű�ڵ尪���� ����
				if(curr.child[idx] == null) {
					curr.child[idx] = new Trie();  
				}
				
				curr = curr.child[idx];
			}
			curr.count ++;  // �� ��忡 ī��Ʈ�� ����
		}
		
		int search(String str) {
			Trie curr = this;
			for(char ch : str.toCharArray()) {
				if(ch == '?') return curr.count;
				
				curr = curr.child[Character.getNumericValue(ch) - aletter];
				if(curr == null) return 0;   // ��ġ�ϴ� ���ڰ� �����Ƿ� 0 ����
				
			}
			return curr.count;
		}
	}
	
	Trie[] TrieRoot = new Trie[10000]; // ������ Ʈ������
	Trie[] ReTrieRoot = new Trie[10000]; // ������ Ʈ������
	
	public int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
		int ansIdx = 0;
		
		for(String str : words) {
			int idx = str.length() - 1;
			if(TrieRoot[idx] == null) {
				TrieRoot[idx] = new Trie();
				ReTrieRoot[idx] = new Trie();
			}
			
			TrieRoot[idx].insert(str); // �� ���ڿ� ����
			str = new StringBuilder(str).reverse().toString();  // �Ųٷ� ����� ����
			ReTrieRoot[idx].insert(str);
		}
		
		for(String str : queries) {
			int idx = str.length() - 1;
			
			// ���ڿ��� ���̰� �� �� ���
			if(TrieRoot[idx] == null) {
				answer[ansIdx ++] = 0;
				continue;
			}
			
			if(!str.startsWith("?")) {
				answer[ansIdx++] = TrieRoot[idx].search(str); 
			} else {
				str = new StringBuilder(str).reverse().toString();
				answer[ansIdx++] = ReTrieRoot[idx].search(str);
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {

		String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String[] queries = { "fro??", "????o", "fr???", "fro???", "pro?" };

		Kakao2020_04 k = new Kakao2020_04();
		
		int[] answer = k.solution(words, queries);
		System.out.println(Arrays.toString(answer));
	}
}
