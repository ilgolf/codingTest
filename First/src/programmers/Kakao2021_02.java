package programmers;

import java.util.*;

public class Kakao2021_02 {
	List<Map<String, Integer>> foodmaps = new ArrayList<>();
	int[] MaxCnt = new int[11];
	
	void comb(char[] str, int pos, StringBuilder sb) {
		if(pos >= str.length) {
			int len = sb.length();
			if(len >= 2) {
				int cnt = foodmaps.get(len).getOrDefault(sb.toString(), 0) + 1;
				foodmaps.get(len).put(sb.toString(), cnt);
				MaxCnt[len] = Math.max(MaxCnt[len], cnt);
			}
			return;
		}
		
		comb(str, pos+1, sb.append(str[pos]));
		sb.setLength(sb.length() - 1);
		comb(str, pos + 1, sb);
	}
	
	public String[] solution(String[] orders, int[] course) {
		
		// 각 배열에 hashmap 선언
		for(int i=0; i<11; i++) {
			foodmaps.add(new HashMap<String, Integer>());
		}
		
		// orders배열에 저장된 한 문자마다 잘라서 겹치는 코스마다 카운트
		for(String str : orders) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			comb(arr, 0, new StringBuilder());
		}
		
		List<String> list = new ArrayList<>();
		for(int len : course) {
			for(Map.Entry<String, Integer> entry : foodmaps.get(len).entrySet()) {
				if(entry.getValue() >= 2 && entry.getValue() == MaxCnt[len]) {
					list.add(entry.getKey());
				}
			}
		}
		Collections.sort(list);
		
		String[] answer = new String[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
	
	public static void main(String[] args) {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2, 3, 4};
		
		Kakao2021_02 k = new Kakao2021_02();
		
		String[] answer = k.solution(orders, course);
		
		System.out.println(Arrays.toString(answer));
	}
}
