package programmers_step3;

import java.util.*;

public class Solution03_정답 {
	
	 public int solution(int[] A, int[] B) {
	        int answer = 0;
	        
	        Arrays.sort(A);
	        Arrays.sort(B);
	        
	        int index = B.length-1;
	        for(int i=A.length-1; i>=0; i--) {
	        	if(A[i] < B[index]) {
	        		index --;
	        		answer ++;
	        	}
	        }
	        
	        return answer;
	    }

	public static void main(String[] args) {
		Solution03_정답 s = new Solution03_정답();
		int[] A = {5,1,3,7};
		int[] B = {2,2,8,6};
		
		int answer = s.solution(A, B);
		System.out.println(answer);
	}
}
