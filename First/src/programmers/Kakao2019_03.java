package programmers;

import java.util.*;

public class Kakao2019_03 {
	
	// ���� 
	Comparator<Integer> comp = new Comparator<Integer>() {
		int countBits(int n) {
			int ret = 0;
			while(n != 0) {
				if((n & 1) != 0) ret ++;  // ��Ʈ�� ���������� ret ���� �÷��ֱ�
				n = n >> 1;  // ��Ʈ�� �ϳ��� �����ֱ�
			}
			return ret;
		}
		
		// ��Ʈ�� ���� ���� �Ӽ��� ������ ����
		public int compare(Integer a, Integer b) {
			int x = countBits(a), y = countBits(b);
			if (x > y) return 1;
			else if(x < y) return -1;
			else return 0;
		}
	};
	
	// Ž���ϸ� ��Ʈ�Ӽ� Ȯ��
	boolean check(String[][] relation, int rowsize, int colsize, int subset) {
		for(int a = 0; a < rowsize - 1; a++) {
			for(int b = a + 1; b < rowsize; b++) {
				boolean isSame = true;
				for(int k=0; k<colsize; k++) {
					if((subset & 1 << k) == 0) continue;   // ��Ʈ�� ���������� �Ӽ����� ����
					if(!relation[a][k].equals(relation[b][k])) {  
						isSame = false;  // �� �Ӽ��� �ٸ��� false
						break;
					}
				}
				if(isSame) return false;  // ���ϼ��� �������� ����
			}
		}
		return true;
	}
	
	public int solution(String[][] relation) {
		int answer = 0;
		
		int rowsize = relation.length;
		int colsize = relation[0].length;
		List<Integer> candidates = new LinkedList<>();
		
		// ���ϼ� ������ �迭�� ����
		for(int i = 1; i < 1 << colsize; i++) {
			if(check(relation, rowsize, colsize, i)) {
				candidates.add(i);
			}
		}
		
		Collections.sort(candidates, comp);
		
		while(candidates.size() != 0) {
			// �ּҼ� �����ϸ� ī��Ʈ
			int n = candidates.remove(0);
			answer ++;
			
			// �ּҼ� Ž��
			for(Iterator<Integer> it = candidates.iterator(); it.hasNext(); ) {
				int c = it.next();
				if ((n & c) == n) //�ּҼ��� ���� ���ϹǷ� ����
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