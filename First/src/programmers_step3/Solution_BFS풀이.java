package programmers_step3;

import java.util.*;

public class Solution_BFSǮ�� {
	
	class Position { // ��ġ ���� �� �������ֱ� ���� Ŭ���� ����
		int x,y;
		
		Position(int x, int y) {  // ������ ��ġ���� �޾ƾ���
			this.x = x;
			this.y = y;
		}
		
		boolean isValid(int width, int height) {  // BFS �˻�� ����ó��
			if(x < 0 || x >= width) return false;
			if(y < 0 || y >= height) return false;
			
			return true;
		}
	}

	public int solution(int[][] maps) {
		
		int size_y = maps.length;  
		int size_x = maps[0].length;
		
		// �湮�� ó���� ������ �̵��Ҷ����� count �������� ������ ����
		Queue<Position> queue = new LinkedList<>();
		int[][] count = new int[size_y][size_x];
		boolean[][] checked = new boolean[size_y][size_x];
		
		// ������ ���
		queue.offer(new Position(0, 0));
		count[0][0] = 1;
		checked[0][0] = true;
		while(!queue.isEmpty()) {  // ť�� �����Ͱ� �� ���������� �ݺ�
			Position current = queue.poll();
			
			int currentCount = count[current.y][current.x]; // ���� ��ġ�� ī���� ���ֱ� ���� ����
			
			final int[][] moving = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
			for(int i=0; i<moving.length; i++) {
				Position moved = new Position(current.x + moving[i][0], current.y + moving[i][1]);
				if(!moved.isValid(size_x, size_y)) continue;  // �����ʰ��� ����
				if(checked[moved.y][moved.x]) continue;   // �̹� �湮������ ����
				if(maps[moved.y][moved.x] == 0) continue; // ���� ������ ����
				
				count[moved.y][moved.x] = currentCount + 1;
				checked[moved.y][moved.x] = true;
				queue.offer(moved); // ���� ��ġ �ҷ�����
			}
		}
		
		int answer = count[size_y-1][size_x-1]; // ���������� �������� �����Ƿ� �ǵ� �迭�� ���ڰ� �ִܰŸ�
		if(answer == 0) return -1; //�ݺ����� �������������� ������������ -1 ����
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[][] maps = {
				{1,0,1,1,1},
				{1,0,1,0,1},
				{1,0,1,1,1},
				{1,1,1,0,1},
				{0,0,0,0,1}
		};
		
		Solution_BFSǮ�� s = new Solution_BFSǮ��();
		
		int answer = s.solution(maps);
		System.out.println(answer);
	}
}