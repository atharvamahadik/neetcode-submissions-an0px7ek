class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int currentSum = nums[0];
        int globalMax = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int current = nums[i];
            currentSum = Math.max(current, current+currentSum);
            globalMax = Math.max(globalMax, currentSum);
        }
        return globalMax;
    }
}

