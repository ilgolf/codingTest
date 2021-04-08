package programmers;

import java.util.*;

class Solution {
	
	public static int[][] d = new int[10001][10001];
	
	void floyd(int[][] trains) {
		for(int i=0; i<trains.length; i++) {
			
		}
	}
	
	public int[] solution(int n, int[] passenger, int[][] train) {
		
		for(int i=0; i<train.length; i++) {
			d[train[i][0] - 1][train[i][1] - 1] = passenger[i];
		}
		
		floyd(train);
		
		int[] answer = {};
		return answer;
	}

	public static void main(String[] args) {
		int[] passanger = { 1,1,1,1,1,1 };
		int n = 6;
		int[][] train = {{1,2},{1,3},{1,4},{3,5},{3,6}};

		Solution s = new Solution();
		int[] answer = s.solution(n, passanger, train);
		System.out.println(Arrays.toString(answer));
	}
}