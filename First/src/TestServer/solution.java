package TestServer;

import java.util.Random;

class Solution {
	Random ran = new Random();
	boolean[] check;
	boolean[] used;

	public String solution(String[] participant, String[] completion) {
		String answer = "";
		
		check = new boolean[participant.length];
		used = new boolean[completion.length];
		
		for (int i = 0; i <participant.length; i++) {
			for(int j=0; j<completion.length; j++) {
				if(used[j] = false && participant[i].equals(completion[j])) {
					used[j] = true;
					check[i] = true;
					break;
				}
			}
		}
		
		int idx = 0;
		for(int i=0; i<used.length; i++ ) {
			if(used[i] == false && check[i] == false) {
				idx = i;
			}
		}
		
		return answer;
	}
}
