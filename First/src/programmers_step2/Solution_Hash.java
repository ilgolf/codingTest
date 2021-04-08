package programmers_step2;

import java.util.*;

public class Solution_Hash {
	 public int solution(String[][] clothes) {
	      return Arrays.stream(clothes)
	        .map(c -> c[1])
	        .distinct()
	        .map(type -> (int) Arrays.stream(clothes).filter(c -> c[1].equals(type)).count())
	        .map(c -> c + 1)
	        .reduce(1, (c,n) -> c*n) - 1;
	 }
	public static void main(String[] args) {
		String[][] clothes = {
				{"yellow_hat", "headgear"}, 
				{"blue_sunglasses", "eyewear"}, 
				{"green_turban", "headgear"}
			};
		
		Solution_Hash s = new Solution_Hash();
		int answer = s.solution(clothes);
		System.out.println(answer);
	}
}
