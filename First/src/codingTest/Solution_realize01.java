package codingTest;

import java.io.*;
import java.util.*;

public class Solution_realize01 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int x = 1;
		int y = 1;
		String[] move = br.readLine().split(" ");

		for (int i = 0; i < move.length; i++) {
			if (move[i].equals("R")) if(x+1 <= N) x++; 
			else if (move[i].equals("L")) if(x-1 >= 1) x--; 
			else if(move[i].equals("U")) if(y-1 >= 1) y--; 
			else if(move[i].equals("D")) if(y+1 <= N) y++;
		}
		System.out.println(y + ", " + x);
	}
}
