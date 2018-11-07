
/*
 * Brute force: scan whole array 
 * 	worst case O(n)
 * 
 * Divide and Conquer 分治法
 * 	Binary cut: if mid != first, then left side
 * 	其实是三分不是二分，左，中，右
 * 	O(logn)
 */

class DifferentElementSolution {
	public int findIndex(int[] array) {
		int left = 0;
		int right = array.length - 1;
		
		// corner case
		if (array == null || array.length == 0 || array[array.length - 1] == 0) {
			return -1;
		}
		
		while (left < right) {
			// int mid = (left + right) / 2; // needs optimization to avoid integer overflow
			int mid = left + (right - left) / 2;
			// can't do (left + right + 1) / 2, when left = right - 1, infinite loop 死循环
			if (array[mid] == 1) {
				right = mid;
			} else if (array[mid] == 0) {
				left = mid + 1;
			}
		}
		return left;
		/*
		 * prove that will definitely find： 目标值一定在剩下的范围内，一直在逼近
		 * prove the results will not exceed time limit, will converge: always deleting part of the array 每部都会删除元素，长度变小，会收敛
		 */
	}
}

/*
 * Modification 1
 * find the first 1 
 * 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0
 * 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0
 * 
 * when find the first 1, take the left side
 * when find a 0, don't know if take left or right, split into half, both search, until find the first 1
 * 用宽度优先搜索，层次遍历，avoid search O(n) in the sub array with all 0s
 * 
 * Modification 2
 * random 0 and 1 position, find the first 1
 * 0, 0, 0, 1, 0, 1, 1, 0
 */


public class DifferentElement {
	/*
	 * given array: [0, 0, 0, 0, 1, 1, 1] find index for the first 1
	 */
	public static void main (String[] args) {
		DifferentElementSolution s = new DifferentElementSolution();
		System.out.println(s.findIndex(new int[] {0, 0, 0, 1, 1, 1, 1}));
		System.out.println(s.findIndex(new int[] {0, 1}));
		System.out.println(s.findIndex(new int[] {1, 1, 1, 1}));
		System.out.println(s.findIndex(new int[] {}));
		System.out.println(s.findIndex(new int[] {0, 0, 0, 0}));
	}
}
