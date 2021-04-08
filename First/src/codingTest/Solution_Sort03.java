package codingTest;

import java.io.*;
import java.util.*;

public class Solution_Sort03 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Integer[] arr1 = new Integer[n];
		Integer[] arr2 = new Integer[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2, Collections.reverseOrder());
		
		for(int i=0; i<k; i++) {
			if(arr1[i] < arr2[i]) {
				Integer temp = arr1[i];
				arr1[i] = arr2[i];
				arr2[i] = temp;
			} else {
				break;
			}
		}
		
		long sum = 0;
		for(int val : arr1) {
			sum += val;
		}
		System.out.println(sum);
	}
}
