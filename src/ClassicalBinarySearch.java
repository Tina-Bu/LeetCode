class ClassicalBinarySearchSolution {
	// time complexity log(N) so recursion won't cause stack overflow
	public int findPosition(int nums[], int target) {
		return binarySearch(nums, 0, nums.length - 1, target);
	}
	
	public int binarySearch(int[] nums, int start, int end, int target) {
		if (start > end) {
			return -1;
		}
		
		int mid = (start + end) / 2;
		if (nums[mid] == target ) {
			return mid;
		} 
		if (nums[mid] < target) {
			return binarySearch(nums, mid + 1, end, target);
		}
		return binarySearch(nums, start, mid - 1, target);
	}
}

public class ClassicalBinarySearch {
	public static void main(String[] args) {
		ClassicalBinarySearchSolution s = new ClassicalBinarySearchSolution();
	}
}
