class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;
        while(l < r) {
            int currentWidth = (r-l);
            int currentHeight = Math.min(height[l],height[r]);
            maxArea = Math.max(currentWidth*currentHeight, maxArea);
            
            if(height[l]<height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxArea;
    }
}
