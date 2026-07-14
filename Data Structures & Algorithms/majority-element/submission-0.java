class Solution {
    public int majorityElement(int[] nums) {
        if(nums==null || nums.length==0) return 0;

        int count = 0;
        int num = 0;

        for(int i = 0; i < nums.length; i++) {
           if(count==0) num=nums[i];

           if(nums[i]!=num){
            count--;
           } else {
            count++;
           }
        }
        return num;
    }
}
