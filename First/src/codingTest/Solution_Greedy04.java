package codingTest;

import java.io.*;
import java.util.*;

public class Solution_Greedy04 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		
		while(n != 1) {
			int target = (n/k) * k;
			cnt += (n-target);
			n = target;
			if(n < k) break;
			cnt ++;
			n /= k;
		}
		cnt += (n-1);
		System.out.println(cnt);
	}
}
