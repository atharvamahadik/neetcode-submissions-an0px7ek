class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length <= 0) return 0;

        int currentMax = nums[0];
        int currentMin = nums[0];
        int globalMax = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int tempMax = currentMax;
            currentMax = Math.max(current, Math.max(current*tempMax, current*currentMin));
            currentMin = Math.min(current, Math.min(current*tempMax, current*currentMin));
            globalMax = Math.max(currentMax, globalMax);
        }

        return globalMax;
    }
}