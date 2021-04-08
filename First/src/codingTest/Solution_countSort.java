package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_countSort {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr1 = new int[1000001];
		
		String[] str1 = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			int idx = Integer.parseInt(str1[i]);
			arr1[idx] = 1;
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] arr2 = new int[n];
		
		String[] str2 = br.readLine().split(" ");
		for(int i=0; i<m; i++) {
			arr2[i] = Integer.parseInt(str2[i]);
		}
		
		for(int i=0; i<m; i++) {
			if(arr1[arr2[i]] == 1) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
