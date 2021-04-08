package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution_HashSet {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		HashSet<Integer> s = new HashSet<>();
		
		String[] str1 = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(str1[i]);
			
			s.add(x);
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] arr2 = new int[m];
		
		String[] str2 = br.readLine().split(" ");
		for(int i=0; i<m; i++) {
			arr2[i] = Integer.parseInt(str2[i]);
		}
		
		for(int i=0; i<m; i++) {
			if(s.contains(arr2[i])) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
