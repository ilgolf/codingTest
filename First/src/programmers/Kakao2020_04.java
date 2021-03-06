package programmers;

import java.util.*;

class Kakao2020_04 {
	class Trie {
		Trie[] child = new Trie[26];
		int count;   // 카운트 변수
		int aletter = Character.getNumericValue('a'); // 아스키코드값
		
		// 문자열을 트리구조로 삽입
		void insert(String str) {
			Trie curr = this;
			for(char ch : str.toCharArray()) {
				curr.count++;
				int idx = Character.getNumericValue(ch) - aletter;  // 각 문자열 위치값 아스키코드값으로 저장
				if(curr.child[idx] == null) {
					curr.child[idx] = new Trie();  
				}
				
				curr = curr.child[idx];
			}
			curr.count ++;  // 각 노드에 카운트값 저장
		}
		
		int search(String str) {
			Trie curr = this;
			for(char ch : str.toCharArray()) {
				if(ch == '?') return curr.count;
				
				curr = curr.child[Character.getNumericValue(ch) - aletter];
				if(curr == null) return 0;   // 일치하는 숫자가 없으므로 0 리턴
				
			}
			return curr.count;
		}
	}
	
	Trie[] TrieRoot = new Trie[10000]; // 정방향 트리구조
	Trie[] ReTrieRoot = new Trie[10000]; // 역방향 트리구조
	
	public int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
		int ansIdx = 0;
		
		for(String str : words) {
			int idx = str.length() - 1;
			if(TrieRoot[idx] == null) {
				TrieRoot[idx] = new Trie();
				ReTrieRoot[idx] = new Trie();
			}
			
			TrieRoot[idx].insert(str); // 각 문자열 삽입
			str = new StringBuilder(str).reverse().toString();  // 거꾸로 뒤집어서 삽입
			ReTrieRoot[idx].insert(str);
		}
		
		for(String str : queries) {
			int idx = str.length() - 1;
			
			// 문자열의 길이가 더 길 경우
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

