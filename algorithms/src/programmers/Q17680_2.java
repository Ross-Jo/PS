package programmers;

//https://programmers.co.kr/learn/courses/30/lessons/17680

public class Q17680_2 {
	public static void main(String[] args) {
		int cacheSize = 0;
//		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
//		String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
//		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
//		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
//		String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		
		String[] cache_1 = new String[cacheSize]; 
		int[] cache_2 = new int[cacheSize];
		int slot = 0;
		
		int time = 0;
		int ret = 0;
		
		if (cacheSize == 0) {
			ret = 5 * cities.length;
		} else {
			for (String city: cities) {
				time++;
				
				if ((slot = hitChecker(cache_1, city)) != -1) {
					ret += 1;
					cache_2[slot] = time;
				} else {
					ret += 5;
					slot = findSlot(cache_2);
					
					cache_1[slot] = city.toLowerCase();
					cache_2[slot] = time;
				}
			}
		}
		
		System.out.println(ret);
	}
	
	public static int findSlot(int[] cache) { 
		int min = Integer.MAX_VALUE;
		int index = 0;
		for (int i=0; i<cache.length; i++) {
			if (cache[i] < min) {
				min = cache[i];
				index = i;
			}
		}
		
		return index;
	}
	
	public static int hitChecker(String[] cache, String city) {
		city = city.toLowerCase();
		
		for (int i=0; i<cache.length; i++) {
			if (cache[i] != null && cache[i].equals(city)) { // string 빈 배열 생성시 다 null로 채워져 있다는 점에 유의
				return i; // cache hit
			}
		}
		return -1; // cache miss
	}
}