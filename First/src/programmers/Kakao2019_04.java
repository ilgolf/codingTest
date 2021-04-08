package programmers;

import java.util.*;

public class Kakao2019_04 {
	class Food {
		int time;   // 시간 
		int idx;    // 음식 위치
		Food(int time, int idx) {
			this.time = time;
			this.idx = idx;
		}
	}
	
	// 정렬하기 시간 순 정렬
	Comparator<Food> compFood = new Comparator<Food>() {
		public int compare(Food a, Food b) {
			return a.time - b.time;
		}
	};
	
	// 위치순 정렬(시간 순 정렬로 빠르게 탐색후 답을 찾을때 다시 위치 순 정렬로 바꿔줌)
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

		foods.sort(compFood); // 시간 순 정렬
		
		int pretime = 0;
		int i = 0;
		for(Food f : foods) {
			long diff = f.time - pretime; // 전칸 윗칸 차이
			if(diff != 0) {
				long spend = diff * n; // 각 칸마다 먹은 갯수 연산
				if(spend <= k) {
					k -= spend;  // 그 칸수만큼 k 빼주기
					pretime = f.time; 
				} else {
					k %= n ; // 
					foods.subList(i, food_times.length).sort(compIdx);  // 만약 빠른 연산이 끝났을경우 정답 탐색을 위한 새로운 정렬
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
