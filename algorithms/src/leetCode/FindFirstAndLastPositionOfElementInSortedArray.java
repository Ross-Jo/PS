package leetCode;

public class FindFirstAndLastPositionOfElementInSortedArray {
	static int min, max;

	static void trackMinMax(int i) {
		if (min == -1)
			min = max = i;
		else {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
	}

	static void modifiedBinarySearch(int[] nums, int target, int low, int high) {
		if (low > high)
			return;
		int mid = (low + high) / 2;

		if (nums[mid] == target) {
			trackMinMax(mid);

			if (mid + 1 < nums.length && target == nums[mid + 1]) {
				trackMinMax(mid);
				modifiedBinarySearch(nums, target, mid + 1, high);
			}

			if (mid - 1 >= 0 && target == nums[mid - 1]) {
				trackMinMax(mid);
				modifiedBinarySearch(nums, target, low, mid - 1);
			}
		} else {
			if (nums[mid] < target) modifiedBinarySearch(nums, target, mid + 1, high);
			else modifiedBinarySearch(nums, target, low, mid - 1);
		}
	}

	static int[] searchRange(int[] nums, int target) {
		min = max = -1;
		if (nums.length != 0)
			modifiedBinarySearch(nums, target, 0, nums.length - 1);
		return new int[] { min, max };
	}

	public static void main(String[] args) {
		for (int num : searchRange(new int[] { 2, 2 }, 3)) {
			System.out.print(num + " ");
		}
	}
}

