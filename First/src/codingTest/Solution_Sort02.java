package codingTest;

import java.io.*;
import java.util.*;

public class Solution_Sort02 {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[][] arr = new String[N][N];
		
		for(int i=0; i<N; i++) {
			String[] temp = br.readLine().split(" ");
			
			arr[i][0] = temp[0];
			arr[i][1] = temp[1];
		}
		Arrays.sort(arr, (o1, o2) -> Integer.compare(Integer.parseInt(o1[1]), Integer.parseInt(o2[1])));

		for(int i=0; i<N; i++) {
			System.out.println(arr[i][0]);
		}
	}
}
