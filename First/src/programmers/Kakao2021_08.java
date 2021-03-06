package programmers;

import java.util.*;

public class Kakao2021_08 {
	
	List<Integer>[] list = new ArrayList[300005];
	List<Integer> s = new ArrayList<>();
	final long INF = (long)1e9;
	long d[][] = new long[300005][2];
	
	// dfs Ž?? 
	void dfs(int cur) {
		if(list[cur].isEmpty()) {
			d[cur][0] = s.get(cur);
			d[cur][1] = 0;
			return;
		}
		long mingap = INF;
		d[cur][0] = s.get(cur);
		for(Integer x : list[cur]) {
			dfs(x);
			d[cur][0] += Math.min(d[x][0], d[x][1]);
			mingap = Math.min(mingap, d[x][0] - d[x][1]);
		}
		if(mingap < 0) mingap = 0;
		d[cur][1] = d[cur][0] + mingap - s.get(cur);
	}
	
	public int solution(int[] sales, int[][] links) {
		int n = sales.length;
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		s.add(0);
		
		for(int i=0; i<n; i++) {
			s.add(sales[i]);
		}
		
		for(int i=0; i<n - 1; i++) {
			list[links[i][0]].add(links[i][1]);
		}
		
		dfs(1);
		
		return (int)Math.min(d[1][0], d[1][1]);
    }
	
	public static void main(String[] args) {
		int[] sales = {14, 17, 15, 18, 19, 14, 13, 16, 28, 17};
		int[][] links = {{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}};
		
		Kakao2021_08 k = new Kakao2021_08();
		int answer = k.solution(sales, links);
		System.out.println(answer);
	}
}
