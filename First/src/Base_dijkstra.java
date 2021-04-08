import java.io.*;
import java.util.*;

class Node {
	private int idx;   // ��� ��ġ
	private int distance; // ���
	
	// ������ 
	public Node(int idx, int distance) {
		this.idx = idx;
		this.distance = distance;
	}
	
	// private get �޼��� ����
	public int getIdx() {
		return idx;
	}

	public int getDistance() {
		return distance;
	}
}

public class Base_dijkstra {
	public static final int INF = (int)1e9;  // ���Ѵ��� �� 
	public static int n, m, start;  // ����� ����, ������ ����, ������
	public static ArrayList<ArrayList<Node>> map = new ArrayList<>(); // �� ����� ������ ���� �� �ִ� �迭 
	public static boolean[] checked = new boolean[100001];  // �湮 ó��
	public static int[] d = new int[100001]; // �ִ� �Ÿ� ���̺�
	
	public static int getSmallestNode() {
		int min_value = INF; 
		int idx = 0; // ���� �ִܰŸ��� ª�� ���
		for(int i=1; i<=n; i++) {
			if(d[i] < min_value && !checked[i]) { // �湮���� ����� �ּڰ��� �� ������ ����
				min_value = d[i];
				idx = i;
			}
		}
		return idx;
	}
	
	// ���ͽ�Ʈ�� 
	public static void dijkstra(int start) {
		d[start] = 0; // 0���� ����
		checked[start] = true; // �湮ó�� 
		for(int j=0; j<map.get(start).size(); j++) {
			d[map.get(start).get(j).getIdx()] = map.get(start).get(j).getDistance();
		}
		
		// ���� ��带 ������ n - 1 ���� ��忡 ���� �ݺ�
		for(int i=0; i<n-1; i++) {
			int now = getSmallestNode();
			checked[now] = true;
			
			for(int j=0; j<map.get(now).size(); j++) {
				int cost = d[now] + map.get(now).get(j).getDistance();
				
				if(cost < d[map.get(now).get(j).getIdx()]) {
					d[map.get(now).get(j).getIdx()] = cost;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		
		for(int i=0; i<=n; i++) {
			map.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map.get(a).add(new Node(b, c));
		}
		
		Arrays.fill(d, INF);
		
		dijkstra(start);
		
		for(int i=1; i<=n; i++) {
			if(d[i] == INF) {
				System.out.println("INFINITY");
			} else {
				System.out.println(d[i]);
			}
		}
	}
}