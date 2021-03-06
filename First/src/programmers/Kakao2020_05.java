package programmers;

import java.util.*;

public class Kakao2020_05 {
	boolean[][] pillar; // 기둥
	boolean[][] Bar;    // 보
	int count = 0;
	
	// 기둥 설치 가능한지 체크
	boolean checkPillar(int x, int y) {
		if(y == 0 || pillar[x][y - 1]) { return true; }
		if((x > 0 && Bar[x - 1][y]) || Bar[x][y]) { return true; }
		
		return false;
	}
	
	// 보가 설치 가능한지 체크
	boolean checkBar(int x, int y) {
		if((y > 0 && pillar[x][y-1]) || pillar[x+1][y-1]) return true;
		if(Bar[x-1][y] && Bar[x+1][y]) { return true; }
		
		return false;
	}
	
	// 삭제시 삭제 가능한 기둥 or 보인지 체크
	boolean canDelete(int x, int y) {
		for(int i=Math.max(x-1, 0); i<=x+1; i++) {
			for(int j=y; j<=y+1; j++) {
				if(pillar[i][j] && !checkPillar(i, j)) {
					return false;
				}
				if(Bar[i][j] && !checkBar(i, j)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public int[][] solution(int n, int[][] build_frame) {
		pillar = new boolean[n+2][n+2];
		Bar = new boolean[n+2][n+2];
		
		for(int[] build : build_frame) {
			int x = build[0], y = build[1];  // 좌표
			int type = build[2], cmd = build[3];  // 기둥 or 보 , 설치 or 삭제
			
			if(type == 0) {
				if(cmd == 1) {
					if(checkPillar(x, y)) {
						pillar[x][y] = true;
						count ++;  // 설치시 count 증가
					}
				} else {
					pillar[x][y] = false;
					if(!canDelete(x,y)) {
						pillar[x][y] = true;
					} else {
						count--;  // 삭제시 count 감소
					}
				}
			} else {
				if(cmd == 1) {
					if(checkBar(x, y)) {
						Bar[x][y] = true;
						count ++;
					}
				} else {
					Bar[x][y] = false;
					if(!canDelete(x,y)) {
						Bar[x][y] = true;
					} else {
						count --;
					}
				}
			}
		}
		
		int[][] answer = new int[count][3];
		count = 0;
		
		// 정답 저장
		for(int x=0; x<=n; x++) {
			for(int y=0; y<=n; y++) {
				if(pillar[x][y]) {
					answer[count][0] = x;
					answer[count][1] = y;
					answer[count++][2] = 0;
				}
				if(Bar[x][y]) {
					answer[count][0] = x;
					answer[count][1] = y;
					answer[count++][2] = 1;
				}
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[][] build_frame = {
				{1,0,0,1},
				{1,1,1,1},
				{2,1,0,1},
				{2,2,1,1},
				{5,0,0,1},
				{5,1,0,1},
				{4,2,1,1},
				{3,2,1,1}
		};
		
		Kakao2020_05 k = new Kakao2020_05();
		
		int[][] answer = k.solution(n, build_frame);
		System.out.println(Arrays.deepToString(answer));
	}
}