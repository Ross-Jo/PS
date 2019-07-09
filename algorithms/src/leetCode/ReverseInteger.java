package leetCode;

public class ReverseInteger {
    static int reverse(int x) {
        boolean negative = false;
    	if (x < 0) {
    		negative = true;
    		x *= -1;
    	}
    	
    	char[] nums = Integer.toString(x).toCharArray();
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i=nums.length-1; i>=0; i--) sb.append(nums[i]);
    	
    	int ret = 0;
    	try {
    		ret = Integer.parseInt(sb.toString());
    	} catch (NumberFormatException e) {
    		return 0;
    	}
    	return negative ? ret * -1: ret;
    }
	public static void main(String[] args) {
		System.out.println(reverse(2100000009));
	}
}
