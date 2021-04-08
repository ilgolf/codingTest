package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_Greedy03 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int min = 10001;
			for(int j=0; j<m; j++) {
				int card = Integer.parseInt(st.nextToken());
				min = Math.min(min, card);
			}
			answer = Math.max(answer, min);
		}
		
		System.out.println(answer);
	}
}
