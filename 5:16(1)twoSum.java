class Solution {
	// (1) naive bruteforce solution 
    public int[] twoSum(int[] nums, int target) {
        // java check array length: a field of array
        if(nums.length >= 2) {
            for(int i = 0; i < nums.length; i++) {
                for(int j = i+1; j < nums.length; j++) {
                    if(nums[i] + nums[j] == target) {
                        // java doesn't support return 2 values, have to create an array first
                        return new int[] {i, j};
                    }
                }
            }
        }
        // return null for other cases
        return null;
        // or throw exception
        // throw new IllegalArgumentException("No two sum solution");

    }
}

class Solution {
    // (2) hash table solution
    // because we are returning the indexes, hash table is the easiest for that
    public int[] twoSum(int[] nums, int target) {
        // put <value, index> as key value pair in hashmap first
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            hashmap.put(nums[i], i);
        }
        // search in hashmap is amortized O(1)
        // trade space for time
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(hashmap.containsKey(complement)) {
                return new int[] {i, hashmap.get(complement)};
            }
        }
        return null;
        // or throw exception
        // throw new IllegalArgumentException("no two sums available");
    }
}

class Solution {
    // (3) hash table solution optimization
    // check if valid result exists while creating the hashmap
    // if complement value doesn't exist, insert the value in the hashmap
    // else return result directly
    public int[] twoSum(int[] nums, int target) {
        // put <value, index> as key value pair in hashmap first
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hashmap.containsKey(complement)) {
                return new int[] {i, hashmap.get(complement)};
            }
            hashmap.put(nums[i], i);
        }
        return null;
        // or throw exception
        // throw new IllegalArgumentException("no two sums available");
    }
}
