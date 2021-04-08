package programmers;

import java.util.*;

public class Kakao2019_06 {
	class Page {
		int idx;  // ������ �ε���
		int basic, link; // �⺻���� �ܺθ�ũ
		double score;  // ��ũ����
		
		Page(int idx, int basic, int link, double score) {
			this.idx = idx;
			this.basic = basic;
			this.link = link;
			this.score = score;
		}
	}
	
	// ��ũ���� �������� ���� , ���� �� ��ġ�� ����
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
		word = word.toLowerCase(); // ��ҹ��� ������ �����Ƿ� ���� �ҹ��ڷ� ��ȯ
		for(int i=0; i<pages.length; i++) {
			StringBuilder sb = new StringBuilder(pages[i].toLowerCase());  // Ž���� ��� ���� ��ȯ
			int mid = 0, posl = 0, posr = 0;  // �߰����� Ž��, ���� Ž��, ������ Ž��
			
			// meta �±׾ȿ� URL�� �ִ��� Ȯ���ϰ� ������ �������� ������ ���������� Ž�� 
			while(mid <= posl) {
				posl = sb.indexOf("<meta", posl + 1);  // meta�±� ������
				posr = sb.indexOf(">", posl);          // meta�±� ������ ��
				mid = sb.lastIndexOf("https://", posr);   // meta �±׾ȿ� ��ũ Ž��
			}
			
			posr = sb.indexOf("\"", mid);   // ��ũ ������
			String url = sb.substring(mid, posr);  // url ��������
			
			// �⺻���� ä�� ����
			posl = sb.indexOf("<body>", posr);
			int basic = 0;
			for(int start = posl; ;) {
				start = sb.indexOf(word, start + 1);
				if(start < 0) break; // ����ó��
				
				// �ֺ��� ���ڰ� �ƴҰ�쿡�� �⺻ ���� ++
				if(!Character.isLetter(sb.charAt(start - 1)) && !Character.isLetter(sb.charAt(start + wsize))) {
					basic ++;
					start += wsize;
				}
			}
			
			// �ܺθ�ũ Ž��
			int link = 0;
			for(int start = posl; ;) {
				start = sb.indexOf("<a href", start + 1);
				if(start < 0) break; // ����ó��
				link ++;
			}
			map.put(url, i);
			list.add(new Page(i, basic, link, (double)basic)); // �� ����� ��ġ, �⺻����, �ܺθ�ũ, ��ũ���� �߰�
		}
		
		for(int i=0; i<pages.length; i++) {
			StringBuilder sb = new StringBuilder(pages[i].toLowerCase()); // ��ҹ��� ���� ���ֱ� ���� �ҹ��� ó��
			for(int posl = 0, posr = 0; ;) {
				posl = sb.indexOf("<a href", posr); 
				if(posl < 0) break; // ����ó��
				
				posl = sb.indexOf("https://", posl);
				posr = sb.indexOf("\"", posl);
				
				// �ܺθ�ũ ����
				String linkurl = sb.substring(posl, posr);
				
				Integer value = map.get(linkurl);
				
				// ���� �ܺθ�ũŰ�� ���� ���� ������� ��ũ���� ����� ����
				if(value != null) {
					list.get(value).score += (double)list.get(i).basic / list.get(i).link;
				}
			}
		}
		
		// ����� ��ũ���� ���� ����
		list.sort(new Comp());
		
		// ���� ���� �ε��� ���
		return list.get(0).idx;
	}
}