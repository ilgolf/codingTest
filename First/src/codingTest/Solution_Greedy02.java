package codingTest;

import java.io.*;
import java.util.*;

public class Solution_Greedy02 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Integer[] arr = new Integer[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, Collections.reverseOrder());
		
		// 가장 큰 수가 더해지는 횟수 계산
		int count = (m/(k+1))*k;
		count += m%(k+1);
		
		int sum = count * arr[0];
		
		// 가장 큰 수를 다 더해주고 남은 연산은 두번째로 큰 숫자 더해주기
		sum += (m - count) * arr[1];
		
		System.out.println(sum);
	}
}
