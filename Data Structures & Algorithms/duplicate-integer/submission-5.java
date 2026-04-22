class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for(int i = 0; i<=nums.length - 1; i++) {
            if(!seen.add(nums[i])) return true;
        }

        return false;
    }
}