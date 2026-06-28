class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length == 0) return 0;
        int currentMax = nums[0];
        int currentMin = nums[0];
        int globalMax = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int tempMax = Math.max(current, Math.max(current*currentMax, current*currentMin));
            currentMin = Math.min(current, Math.min(current*currentMax, current*currentMin));

            currentMax = tempMax;
            globalMax = Math.max(currentMax, globalMax);
        }

        return globalMax;
    }
}
