class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while(l < r) {
            if(height[l]<height[r]){
                maxArea = Math.max(height[l]*(r-l),maxArea);
                l++;
            }
            else{
                maxArea = Math.max(height[r]*(r-l),maxArea);
                r--;
            }
        }
        return maxArea;
    }
}
