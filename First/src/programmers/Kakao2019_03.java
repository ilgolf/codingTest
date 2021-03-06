package programmers;

import java.util.*;

public class Kakao2019_03 {
	
	// 정렬 
	Comparator<Integer> comp = new Comparator<Integer>() {
		int countBits(int n) {
			int ret = 0;
			while(n != 0) {
				if((n & 1) != 0) ret ++;  // 비트가 켜져있으면 ret 변수 올려주기
				n = n >> 1;  // 비트를 하나씩 지워주기
			}
			return ret;
		}
		
		// 비트가 켜진 순서 속성값 순으로 정렬
		public int compare(Integer a, Integer b) {
			int x = countBits(a), y = countBits(b);
			if (x > y) return 1;
			else if(x < y) return -1;
			else return 0;
		}
	};
	
	// 탐색하며 비트속성 확인
	boolean check(String[][] relation, int rowsize, int colsize, int subset) {
		for(int a = 0; a < rowsize - 1; a++) {
			for(int b = a + 1; b < rowsize; b++) {
				boolean isSame = true;
				for(int k=0; k<colsize; k++) {
					if((subset & 1 << k) == 0) continue;   // 비트가 꺼져있으면 속성값이 없음
					if(!relation[a][k].equals(relation[b][k])) {  
						isSame = false;  // 각 속성이 다르면 false
						break;
					}
				}
				if(isSame) return false;  // 유일성이 만족하지 못함
			}
		}
		return true;
	}
	
	public int solution(String[][] relation) {
		int answer = 0;
		
		int rowsize = relation.length;
		int colsize = relation[0].length;
		List<Integer> candidates = new LinkedList<>();
		
		// 유일성 만족시 배열에 저장
		for(int i = 1; i < 1 << colsize; i++) {
			if(check(relation, rowsize, colsize, i)) {
				candidates.add(i);
			}
		}
		
		Collections.sort(candidates, comp);
		
		while(candidates.size() != 0) {
			// 최소성 만족하면 카운트
			int n = candidates.remove(0);
			answer ++;
			
			// 최소성 탐색
			for(Iterator<Integer> it = candidates.iterator(); it.hasNext(); ) {
				int c = it.next();
				if ((n & c) == n) //최소성을 만족 못하므로 삭제
					it.remove();
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		String[][] relation = {
				{"100","ryan","music","2"},
				{"200","apeach","math","2"},
				{"300","tube","computer","3"},
				{"400","con","computer","4"},
				{"500","muzi","music","3"},
				{"600","apeach","music","2"}
		};
		
		Kakao2019_03 k = new Kakao2019_03();
		int answer = k.solution(relation);
		System.out.println(answer);
	}
}
