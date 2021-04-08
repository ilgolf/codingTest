package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_BinarySearch01 {
	
	public static int binarySearch(int[] a, int target, int middle, int right, int left) {
		while(left <= right) {
			middle = (right + left)/2;
			
			if(a[middle] == target) return middle;
			else if(target < a[middle]) right = middle - 1; 
			else if(target > a[middle]) left = middle + 1;
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] b = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		
		int right = a.length - 1;
		int left = 0;
		int middle = (right + left)/2;
		
		for(int i=0; i<m; i++) {
			int result = binarySearch(a, b[i], middle, right, left);
			
			if(result != -1) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
