package programmers_step3;

import java.util.*;

public class Solution02_Queue {
	public int solution(int n, int[] stations, int w) {
		int answer = 0;
		int si = 0;
		int position = 1;
		while(position <= n) {
			if(si < stations.length && stations[si] - w <= position) {
				position = stations[si] + w + 1;
				si += 1;
			} else {
				answer ++;
				position += w * 2 + 1;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int n = 16;
		int[] stations = { 9 };
		int w = 2;
		Solution02_Queue s = new Solution02_Queue();
		
		int answer = s.solution(n, stations, w);
		
		System.out.println(answer);
	}
}
