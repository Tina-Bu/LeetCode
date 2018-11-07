import java.util.*;

class Solution1 {
	// HashSet O(N)
	public boolean FindTarget(int[] nums, int target) {
		Set<Integer> h = new HashSet<>();
		for (int num: nums) {
			if (h.contains(target - num)) {
				return true;
			} else {
				h.add(num);
			}
		}
		return false;
	}
}

class Solution2 {
	// two pointers O(N) (if array is sorted)
	public boolean FindTarget(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			if (nums[low] + nums[high] == target) {
				return true;
			} else if (nums[low] + nums[high] > target) {
				high--;
			} else {
				low++;
			}
		}
		return false;
	}
}

public class TwoSum {
	// testing
	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		System.out.println(solution.FindTarget(new int[] {4, 5, 7, 10}, 12));
		System.out.println(solution.FindTarget(new int[] {4, 5, 7, 10}, 8));
		System.out.println(solution.FindTarget(new int[] {4, 4, 7, 10}, 8));
//		System.out.println(solution.FindTarget(new int[] {10, 4, 4, 1}, 8));
//		System.out.println(solution.FindTarget(new int[] {10, 4, 4, 1, -1}, 0));
		System.out.println(solution.FindTarget(new int[] {}, 0));
	}
}

/*
 * Follow up questions
 * 1. 1 element can be used multiple times
 * 		directly add everything to hash set, check if contains(target - num)
 * 2. 3 sum
 *		 for each number, find 2 numbers that sum equal target - num -> O(N)
 * 3. If list is sorted
 * 		Binary search O(NlogN)
 * 		2 pointers
 */
 
