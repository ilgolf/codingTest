package cos_Lv1;

import java.util.*;

public class Solution06 {
	
	public int solution(int a, int b, int c) {
		int answer = 0;
		int max = 0;
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=1; i<=a; i++) {
			if(24%i == 0 && 9%i == 0 && 15%i == 0) {
				list.add(i);
			}
		}
		
		for(int i=0; i<list.size(); i++) {
			if(max < list.get(i)) {
				max = list.get(i);
			}
		}
		int count = 0;
		
		for(int i=1; i<=max; i++) {
			if(max%i == 0) {
				count ++;
			}
		}
		
		answer = count;
		
		return answer;
	}

	public static void main(String[] args) {
		int a = 24;
		int b = 9;
		int c = 15;
		
		Solution06 s = new Solution06();
		int answer = s.solution(a, b, c);
		System.out.println(answer);
	}
}
