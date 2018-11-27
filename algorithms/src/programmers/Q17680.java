package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/17680

import java.util.Date;
import java.util.PriorityQueue;

class City implements Comparable<City> {
	String name;
	Date updatedTime;
	
	public City(String name) {
		super();
		this.name = name;
		this.updatedTime = new Date();
	}
	
	public void update() {
		this.updatedTime = new Date();
	}
	
	@Override
	public int compareTo(City target) {
		if (this.updatedTime.compareTo(target.updatedTime) > 0) {
			return 1;
		} else if (this.updatedTime.compareTo(target.updatedTime) < 0) {
			return -1;
		}
		return 0;
	}
}

public class Q17680 {
	public static void main(String[] args) {
		int cacheSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		
		PriorityQueue<City> cache = new PriorityQueue<City>();
		int time = 0;
		boolean hit = false; // hit = true, miss = false
		
		for (String city: cities) {
			
			City e = new City(city);
			
			for (City cacheElement: cache) {
				if (cacheElement.name.equals(city)) {
					time += 1;
					cacheElement.update(); // 우선순위 큐를 썼을때 불안정한게 이와 같은 요소의 '직접 수정'때문일 수 있음. 즉, 우선순위 큐를 이와 같은 방식으로 쓰는 게 잘못 되었단 얘기
					hit = true;
				} 
			}
			
			if (!hit) {
				time += 5;
				if (cache.size() == cacheSize) {
					cache.poll();
					cache.add(e);
				} else {
					cache.add(e);
				}
			}
			
			hit = false;
		}
		
		System.out.println(time);
	}
}