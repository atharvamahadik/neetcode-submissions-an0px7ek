class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

// -2

// -1 0 2 4 6 8
//  0 1 2 3 4 5
//  l   m     h
      
//  low = 0
//  high = 5

//  mid = 0 + 5 / 2 = 5/2 = 2

