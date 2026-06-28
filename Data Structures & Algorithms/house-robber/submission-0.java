class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];

        int lastSecondHouse = 0;
        int lastHouse = 0;

        for(int i = 0; i < nums.length; i++) {
            int currentMaxLoot = Math.max(nums[i] + lastSecondHouse, lastHouse);
            lastSecondHouse = lastHouse;
            lastHouse = currentMaxLoot;
        }

        return lastHouse;
    }
}
