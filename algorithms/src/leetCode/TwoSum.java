package leetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
//    static int[] twoSum(int[] nums, int target) {
//        int[] ret = new int[2];
//        for (int i=0; i<nums.length-1; i++) {
//        	for (int j=i+1; j<nums.length; j++) {
//        		if (nums[i]+nums[j] == target) {
//        			ret[0] = i;
//        			ret[1] = j;
//        		}
//        	}
//        }
//    	return ret;
//    }
    
	static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) return new int[] { map.get(nums[i]), i }; // 그 카운터파트가 나왔을 때, 해당 카운터파트의 인덱스와 현재 인덱스를 반환한다. 
			else map.put(target - nums[i], i); // 카운터 파트를 저장하고 
		}
		return new int[] { 0, 0 };
	}
	
	public static void main(String args[]) {
		int[] arr = {2, 7, 11, 15};
		int target = 9;
		
		for (int e: twoSum(arr, target)) {
			System.out.print(e + " ");
		}
	}
}
