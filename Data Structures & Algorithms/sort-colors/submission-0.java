class Solution {
    public void sortColors(int[] nums) {
        if(nums==null || nums.length==0) return;
        int i = 0;
        int j = 0;
        int k = nums.length - 1;

        while(i <= k) {
            if(nums[i]==2) {
                swap(nums,i,k);
                k--;
            } else if(nums[i]==0) {
                swap(nums,i,j);
                i++;
                j++;
            } else {
                i++;
            }
        }


    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}