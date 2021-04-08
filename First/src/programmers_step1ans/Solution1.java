package programmers_step1ans;

import java.util.*;

class Solution1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        
        answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
        	int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
        	
        	Arrays.sort(temp);
        	answer[i] = temp[commands[i][2]-1];
        }
        
        return answer;
    }
    public static void main(String[] args) {
		Solution1 s = new Solution1();

		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		int[] answer = s.solution(array, commands);
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i]);
		}
	}
}