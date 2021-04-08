package cos_Lv1;

import java.util.*;

public class Solution04_정답 {
	
	int getCount(int num) {
		int count = 0;
		while(true) {
			if(num == 0) {
				break;
			}
			num /= 10;
			count += 1;
		}
		return count;
	}
	
	void setNumber(Integer[] arr, int num) {
		int count = arr.length - 1;
		for(int i=0; i<arr.length; i++) {
			arr[count] = num % 10;
			num /= 10;
			count --;
		}
	}
	
	void printArr(Integer[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
	}
	
	void suffle(Integer[] arr) {
		Arrays.sort(arr, Collections.reverseOrder());
	}
	
	public String solution(int num) {
		String answer = "";
		int count = getCount(num);
		Integer arr[] = new Integer[count];
		setNumber(arr, num);
		suffle(arr);
		answer += arr[0];
		int number = arr[0];
		int c = 1;
		for(int i=1; i<arr.length; i++) {
			if(number != arr[i]) {
				answer += c;
				answer += arr[i];
				number = arr[i];
				c = 0;
			}
			c ++;
		}
		if(c > 0) {
			answer += c;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int num = 2423334;
			
		Solution04_정답 s = new Solution04_정답();

		String answer = s.solution(num);
		System.out.println(answer);
	}
}
