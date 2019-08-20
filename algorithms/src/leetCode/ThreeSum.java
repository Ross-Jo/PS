package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        
        for (int i=0; i<nums.length; i++) {
        	if (i > 0 && nums[i] == nums[i-1]) continue;
        	int l = i + 1;
        	int h = nums.length - 1;
        	
        	while(l < h) {
        		int sum = nums[i] + nums[l] + nums[h];
        		
        		if (sum > 0) h--;
        		else if (sum < 0) l++;
        		else {
					ret.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[l], nums[h])));
					while (nums.length > l + 1 && nums[l] == nums[l + 1]) l++;
					while (0 <= h - 1 && nums[h] == nums[h - 1]) h--;
					l++; h--;
        		}
        	}
        }
        return ret;
    }
	
	public static void main(String[] args) {
		List<List<Integer>> ans = threeSum(new int[] {-1, 0, 1});
		for (List<Integer> l: ans) for (int e: l) System.out.println(e + " ");
	}
}
