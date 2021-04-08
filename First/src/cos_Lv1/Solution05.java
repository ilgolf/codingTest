package cos_Lv1;

import java.util.*;

public class Solution05 {
	
	public int solution(int[] enemies, int[] armies) {
		int answer = 0;
		
		Arrays.sort(enemies); // 비교하기 쉽게 먼저 정렬
		Arrays.sort(armies);
		
		for(int i=0; i<armies.length; i++) {
			for(int j=0; j<enemies.length; j++) {
				if(enemies[j] != 0 && armies[i] >= enemies[j]) {
					enemies[j] = 0;
					armies[i] = 0;   // 이겼을시 두 값을 0으로 해 중복 제외
					answer ++;       // count
					break;           // 이겼을시 enemies배열 종료(중복 제외)
				}
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int[] enemies = {1,1,1};
		int[] armies = {1,2,3,4};
		
		Solution05 s = new Solution05();
		
		int answer = s.solution(enemies, armies);
		System.out.println(answer);
	}
}
