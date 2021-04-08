package cos_Lv1;

import java.util.*;

public class Solution06_정답 {
	
	int getNum(int t1, int t2) {
		if(t1 < t2) {
			int temp = t1;
			t1 = t2;
			t2 = temp;
		}
		
		while(true) {
			if(t1 % t2 == 0) {
				break;
			}
			int temp = t1%t2;
			t1 = t2;
			t2 = temp;
		}
		return t2;
	}
	
	public int solution(int a, int b, int c) {
		int answer = 0;
		int test = getNum(a, b);
		test = getNum(test, c);
		
		for(int i=1; i<=test; i++) {
			if(test%i == 0) {
				answer ++;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Solution06_정답 s = new Solution06_정답();
		
		int answer = s.solution(24, 9, 15);
		System.out.println(answer);
	}
}
