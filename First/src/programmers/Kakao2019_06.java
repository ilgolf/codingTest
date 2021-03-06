package programmers;

import java.util.*;

public class Kakao2019_06 {
	class Page {
		int idx;  // 페이지 인덱스
		int basic, link; // 기본점수 외부링크
		double score;  // 링크점수
		
		Page(int idx, int basic, int link, double score) {
			this.idx = idx;
			this.basic = basic;
			this.link = link;
			this.score = score;
		}
	}
	
	// 링크점수 내림차순 정렬 , 같을 시 위치별 정렬
	class Comp implements Comparator<Page> {
		public int compare(Page a, Page b) {
			if(a.score == b.score) return a.idx - b.idx;
			else if(a.score < b.score) return 1;
			else return -1;
		}
	}
	
	public int solution(String word, String[] pages) {
		int wsize = word.length();
		Map<String, Integer> map = new HashMap<>();
		List<Page> list = new ArrayList<>();
		word = word.toLowerCase(); // 대소문자 구분이 없으므로 전부 소문자로 변환
		for(int i=0; i<pages.length; i++) {
			StringBuilder sb = new StringBuilder(pages[i].toLowerCase());  // 탐색할 대상 또한 변환
			int mid = 0, posl = 0, posr = 0;  // 중간부터 탐색, 왼쪽 탐색, 오른쪽 탐색
			
			// meta 태그안에 URL이 있는지 확인하고 있으면 꺼내오고 없으면 있을때까지 탐색 
			while(mid <= posl) {
				posl = sb.indexOf("<meta", posl + 1);  // meta태그 시작점
				posr = sb.indexOf(">", posl);          // meta태그 끝나는 점
				mid = sb.lastIndexOf("https://", posr);   // meta 태그안에 링크 탐색
			}
			
			posr = sb.indexOf("\"", mid);   // 링크 끝지점
			String url = sb.substring(mid, posr);  // url 갖고오기
			
			// 기본점수 채점 루프
			posl = sb.indexOf("<body>", posr);
			int basic = 0;
			for(int start = posl; ;) {
				start = sb.indexOf(word, start + 1);
				if(start < 0) break; // 예외처리
				
				// 주변이 문자가 아닐경우에만 기본 점수 ++
				if(!Character.isLetter(sb.charAt(start - 1)) && !Character.isLetter(sb.charAt(start + wsize))) {
					basic ++;
					start += wsize;
				}
			}
			
			// 외부링크 탐색
			int link = 0;
			for(int start = posl; ;) {
				start = sb.indexOf("<a href", start + 1);
				if(start < 0) break; // 예외처리
				link ++;
			}
			map.put(url, i);
			list.add(new Page(i, basic, link, (double)basic)); // 각 저장된 위치, 기본점수, 외부링크, 링크점수 추가
		}
		
		for(int i=0; i<pages.length; i++) {
			StringBuilder sb = new StringBuilder(pages[i].toLowerCase()); // 대소문자 구분 없애기 위해 소문자 처리
			for(int posl = 0, posr = 0; ;) {
				posl = sb.indexOf("<a href", posr); 
				if(posl < 0) break; // 예외처리
				
				posl = sb.indexOf("https://", posl);
				posr = sb.indexOf("\"", posl);
				
				// 외부링크 저장
				String linkurl = sb.substring(posl, posr);
				
				Integer value = map.get(linkurl);
				
				// 만약 외부링크키를 토대로 값이 있을경우 링크점수 계산후 저장
				if(value != null) {
					list.get(value).score += (double)list.get(i).basic / list.get(i).link;
				}
			}
		}
		
		// 저장된 링크점수 토대로 정렬
		list.sort(new Comp());
		
		// 제일 작은 인덱스 출력
		return list.get(0).idx;
	}
}
