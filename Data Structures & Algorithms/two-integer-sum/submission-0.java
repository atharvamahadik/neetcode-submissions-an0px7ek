class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int r = 0;
        while(r < nums.length) {
            int complement = target - nums[r];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),r};
            } 
            map.put(nums[r], r);
            r++;
        }

        return new int[]{-1,-1};
    }
}
