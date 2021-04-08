package cos_Lv1;

import java.util.*;

public class Solution03 {
	
	boolean loopEnd(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > 0) {
				return false;
			}
		}
		return true;
	}
	
	void setArr(int n, int[] arr) {
		arr[0] -= 1;
		for(int i=0; i<n-1; i++) {
			if(arr[i] == 0) {
				if(arr[i+1] > 0) {
					arr[i+1] -= 1;
					arr[i] = n;
				}
			}
		}
	}
	
	public int solution(int n) {
		int answer = 0;
		Map<Vector<Integer>, Vector<Integer>> map = new HashMap<>();
		
		int[] arr = new int[n];
		for(int i=0; i<arr.length; i++) {
			arr[i] = n;
		}
		while(true) {
			if(loopEnd(arr)) {
				break;
			}
			
			setArr(n, arr);
			
			for(int i=0; i<n; i++) {
				Vector<Integer> temp = new Vector<>();
				boolean conCheck = false;
				for(int j=0; j<n; j++) {
					if(arr[j] > 3) {
						conCheck = true;
						break;
					}
				}
				if(conCheck == true) {
					continue;
				}
				
				int sum = 0;
				for(int j=0; j<n; j++) {
					sum += arr[j];
				}
				
				if(sum != n) {
					continue;
				}
				
				for(int j=0; j<n; j++) {
					if(arr[j] != 0) {
						temp.add(arr[j]);
					}
				}
				
				if(temp.size() > 0) {
					map.put(temp, temp);
				}
			}
		}
		
		for(Vector<Integer> key : map.keySet()) {
			Vector<Integer> temp = map.get(key);
			System.out.println(temp.toString());
			answer += 1;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int n = 4;
		Solution03 s = new Solution03();
		int answer = s.solution(n);
		System.out.println(answer);
	}
}
