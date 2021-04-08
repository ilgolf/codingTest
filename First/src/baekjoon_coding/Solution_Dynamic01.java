package baekjoon_coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_Dynamic01 {
	
	private static int[] d = new int[100];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		String[] str = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		d[0] = arr[0];
		d[1] = Math.max(arr[0], arr[1]);
		
		for(int i=2; i<n; i++) {
			d[i] = Math.max(d[i - 1], d[i - 2] + arr[i]);
		}
		
		System.out.println(d[n - 1]);
	}
}
