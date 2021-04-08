import java.io.*;
import java.util.*;

class Node {
	private int idx;   // 노드 위치
	private int distance; // 비용
	
	// 생성자 
	public Node(int idx, int distance) {
		this.idx = idx;
		this.distance = distance;
	}
	
	// private get 메서드 생성
	public int getIdx() {
		return idx;
	}

	public int getDistance() {
		return distance;
	}
}

public class Base_dijkstra {
	public static final int INF = (int)1e9;  // 무한대의 값 
	public static int n, m, start;  // 노드의 개수, 간선의 개수, 시작점
	public static ArrayList<ArrayList<Node>> map = new ArrayList<>(); // 각 노드의 정보를 담을 수 있는 배열 
	public static boolean[] checked = new boolean[100001];  // 방문 처리
	public static int[] d = new int[100001]; // 최단 거리 테이블
	
	public static int getSmallestNode() {
		int min_value = INF; 
		int idx = 0; // 가장 최단거리가 짧은 노드
		for(int i=1; i<=n; i++) {
			if(d[i] < min_value && !checked[i]) { // 방문안한 노드중 최솟값을 각 변수에 저장
				min_value = d[i];
				idx = i;
			}
		}
		return idx;
	}
	
	// 다익스트라 
	public static void dijkstra(int start) {
		d[start] = 0; // 0부터 시작
		checked[start] = true; // 방문처리 
		for(int j=0; j<map.get(start).size(); j++) {
			d[map.get(start).get(j).getIdx()] = map.get(start).get(j).getDistance();
		}
		
		// 시작 노드를 제외한 n - 1 개의 노드에 대해 반복
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