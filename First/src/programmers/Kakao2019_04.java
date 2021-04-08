package programmers;

import java.util.*;

public class Kakao2019_04 {
	class Food {
		int time;   // �ð� 
		int idx;    // ���� ��ġ
		Food(int time, int idx) {
			this.time = time;
			this.idx = idx;
		}
	}
	
	// �����ϱ� �ð� �� ����
	Comparator<Food> compFood = new Comparator<Food>() {
		public int compare(Food a, Food b) {
			return a.time - b.time;
		}
	};
	
	// ��ġ�� ����(�ð� �� ���ķ� ������ Ž���� ���� ã���� �ٽ� ��ġ �� ���ķ� �ٲ���)
	Comparator<Food> compIdx = new Comparator<Food>() {
		public int compare(Food a, Food b) {
			return a.idx - b.idx;
		}
	};
	
	public int solution(int[] food_times, int k) {
		List<Food> foods = new LinkedList<>();
		int n =  food_times.length;
		for(int i=0; i<n; i++) {
			foods.add(new Food(food_times[i], i + 1));
		}

		foods.sort(compFood); // �ð� �� ����
		
		int pretime = 0;
		int i = 0;
		for(Food f : foods) {
			long diff = f.time - pretime; // ��ĭ ��ĭ ����
			if(diff != 0) {
				long spend = diff * n; // �� ĭ���� ���� ���� ����
				if(spend <= k) {
					k -= spend;  // �� ĭ����ŭ k ���ֱ�
					pretime = f.time; 
				} else {
					k %= n ; // 
					foods.subList(i, food_times.length).sort(compIdx);  // ���� ���� ������ ��������� ���� Ž���� ���� ���ο� ����
					return foods.get(i + (int)k).idx; 
				}
			}
			++i; 
			--n; 
		}
		
		return -1;
	}

	public static void main(String[] args) {
		int[] food_times = {3, 1, 2};
		int k = 5;
		
		Kakao2019_04 s = new Kakao2019_04();
		int answer = s.solution(food_times, k);
		System.out.println(answer);
	}
}
