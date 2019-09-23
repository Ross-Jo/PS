package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 참고 : https://www.youtube.com/watch?v=F3Bfy3bKHc8&list=PL6YHvWRMtz7CyRH31LhCHR0gp_x7eeSK6&index=6

public class Q42983 {
	static class Page {
		int idx, basic, link;
		double score;
		Page(int idx, int basic, int link, double score) {
			this.idx = idx; this.basic = basic; this.link = link; this.score = score;
		}
	}
	
	static class Comp implements Comparator<Page> {
		public int compare(Page a, Page b) {
			if (a.score == b.score) return a.idx - b.idx;
			else if (a.score < b.score) return 1;
			else return -1;
		}
	}
	
	
	static int solution(String word, String[] pages) {
		int wsize = word.length();
		Map<String, Integer> pageMap = new HashMap<>();
		List<Page> pageList = new ArrayList<Page>();
		word = word.toLowerCase();
		
		for (int i=0; i<pages.length; i++) {
			String s = pages[i] = pages[i].toLowerCase();
			int mid = 0, posl = 0, posr = 0;
			
			while (mid <= posl) {
				posl = s.indexOf("<meta", posl + 1);
				posr = s.indexOf(">", posl);
				mid = s.lastIndexOf("https://", posr);
			}
			
			posr = s.indexOf("\"", mid);
			String url = s.substring(mid, posr);
			
			posl = s.indexOf("<body>", posr);
			int basic = 0;
			for (int start = posl;;) {
				start = s.indexOf(word, start + 1);
				if (start == -1) break;
				if (!Character.isLetter(s.charAt(start - 1)) && !Character.isLetter(s.charAt(start + wsize))) {
					basic++;
					start += wsize;
				}
			}
			
			int link = 0;
			for (int start = posl;;) {
				start = s.indexOf("<a href", start + 1);
				if (start == -1) break;
				link++;
			}
			pageMap.put(url, i);
			pageList.add(new Page(i, basic, link, (double) basic));
		}
		
		for (int i = 0; i < pages.length; i++) {
			String s = pages[i];
			for (int posl = 0, posr = 0;;) {
				posl = s.indexOf("<a href", posr);
				if (posl == -1) break;
				
				posl = s.indexOf("https://", posl);
				posr = s.indexOf("\"", posl);
				String linkurl = s.substring(posl, posr);
				
				Integer value = pageMap.get(linkurl);
				if (value != null) pageList.get(value).score += (double) pageList.get(i).basic / pageList.get(i).link;
				
			}
		}
		
		pageList.sort(new Comp());
		
		return pageList.get(0).idx;
	}

	public static void main(String[] args) {

	}

}
