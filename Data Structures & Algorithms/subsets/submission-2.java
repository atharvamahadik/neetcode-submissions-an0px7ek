class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backTrack(0, result, current, nums);
        return result;
    }

    private void backTrack(int index, List<List<Integer>> result, List<Integer> current, int[] nums) {
        if(index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        backTrack(index + 1, result, current, nums);
        current.remove(current.size() - 1);
        backTrack(index + 1, result, current, nums);
    }
}
