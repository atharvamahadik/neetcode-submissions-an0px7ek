class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outerList = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            while (l < r) {
                if (nums[l] + nums[r] == -nums[i]) {
                    outerList.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while ( l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                } else if (nums[l] + nums[r] > -nums[i]) {
                    r--;
                } else
                    l++;
            }
        }
        return outerList;
    }
}