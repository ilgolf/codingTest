package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_Dynamic03 {

	private static long[] d = new long[1001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		d[0] = 1;
		d[1] = 3;
		
		for(int i=2; i<N; i++) {
			d[i] = (d[i-1] + 2 * d[i-2]) % 796796;
		}
		System.out.println(d[N - 1]);
	}
}
