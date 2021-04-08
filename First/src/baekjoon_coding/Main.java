package baekjoon_coding;

import java.io.*;
import java.util.*;

public class Main {
	static int[] parents;
	static List<Integer>[] list;
	static boolean[] checked;
	static int n;
	
	private static void dfs(int v) {
		checked[v] = true;
		
		for(int i : list[v]) {
			if(!checked[i]) {
				parents[i] = v;
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n + 1];
		parents = new int[n + 1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		checked = new boolean[n + 1];
		for(int i=0; i< n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(1);
		for(int i=2; i<=n; i++) {
			System.out.println(parents[i]);
		}
	}
}
