package programmers_step2;

import java.util.*;

public class Solution_Hindex {
	
	 public int solution(int[] citations) {
	        int answer = 0;
	        
	        Arrays.sort(citations);
	        
	        int[] count = new int[citations.length];
	        
	        for(int i=0; i<citations.length; i++) {
	        	int cnt = 0;
	            for(int j=0; j<citations.length; j++) {
	                if(citations[i] <= citations[j]) {
	                    cnt++;
	                    if(cnt == citations[i]) {
	                    	count[i] = cnt;
	                    }
	                }
	            }
	        }
	        Arrays.sort(count);
	        
	        for(int val : count) {
	            answer = Math.max(answer, val);
	        }
	        return answer;
	    }

	public static void main(String[] args) {
		int[] citations = {3,0,6,1,5};
		
		Solution_Hindex s = new Solution_Hindex();
		
		int answer = s.solution(citations);
		System.out.println(answer);
	}
}
