/*
 * merge 2 sorted array nums1 and nums2, and put back in nums1
 * nums1 = {4, 5, 7, 10, 0, 0, 0}, length1 = 4
 * nums2 = {3, 6, 11}, length2 = 3
 * 
 */
class Solution {
	// can't create a new array because asked to put back to nums1
	// start from back so inserting elements will not affect existing ones
	public int[] mergeSortedArray(int[] nums1, int length1, int[] nums2, int length2) {
		int tail = length1 + length2 - 1;
		int i = length1 - 1;
		int j = length2 - 1;
		while(tail >= 0) {
			// corner case: one array is empty
			if (i == -1 || j != -1 && nums1[i] < nums2[j]) {
				nums1[tail--] = nums2[j--];
			} else {
				nums1[tail--] = nums1[i--];
			}
		}
		return nums1;
	}
	
}
public class MergedSortedArray {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums1 = new int[] {4, 5, 7, 10, 0, 0, 0};
		int[] nums2 = new int[] {3, 6, 11};
//		int[] nums1 = new int[] {4, 5, 7, 10, 0, 0, 0};
//		int[] nums2 = new int[] {1, 2, 3};
		
		solution.mergeSortedArray(nums1, 4, nums2, 3);	
		for (int num: nums1) {
			System.out.println(num);
		}
	}
}
/*
 * Followup questions
 * 1. 3 arrays
 * 3 pointers, compare 3 integers use heap
 * 2. if sorted descendingly
 * then loop from beginning
 */
