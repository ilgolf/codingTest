package code.up;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int m = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[m];
		
		for(int i=0; i<a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			System.out.printf("%d%n", a[i]);
		}
	}
}
