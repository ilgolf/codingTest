package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_BinarySearch02 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] cake = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			cake[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cake);
		
		int right = cake[n - 1];
		int left = 1;
		int middle = 0;
		int tot = 0;
		for(int val : cake) tot += val;
		int answer = 0;
		System.out.println(tot);
		
		while(left <= right) {
			int sum = 0;
			middle = (right + left)/2;
			
			for(int val : cake) {
				if(val >= middle) sum += middle;
				else if(val < middle) sum += val;
			}
			
			if((tot - sum) == m) {
				answer = middle;
				left = middle + 1;
			}
			else if((tot-sum) < m) right = middle - 1;
			else if((tot-sum) > m) left = middle + 1;
		}
		System.out.println(answer);
	}
}
