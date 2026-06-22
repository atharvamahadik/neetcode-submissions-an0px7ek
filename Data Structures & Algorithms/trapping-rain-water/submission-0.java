class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxLeft = height[l];
        int maxRight = height[r];
        int totalWater = 0;
        while(l < r) {
            if(maxLeft <= maxRight) {
                l++;
                int currWater = maxLeft - height[l];
                if(currWater > 0) {
                    totalWater = totalWater + currWater;
                }
                maxLeft = Math.max(maxLeft, height[l]);
            }
            else {
                r--;
                int currWater = maxRight - height[r];
                if(currWater > 0) {
                    totalWater = totalWater + currWater;
                }
                maxRight = Math.max(maxRight, height[r]);
            }
        }
        return totalWater;
    }
}
