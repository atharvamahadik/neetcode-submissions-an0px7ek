class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> inner = new ArrayList<>();
        List<List<Integer>> outer = new ArrayList<>();
        subset(0, outer, inner, nums);
        return outer;
    }

    private void subset(int index, List<List<Integer>> outer, List<Integer> inner, int[] nums) {
        if(index==nums.length) {
            outer.add(new ArrayList<>(inner));
            return;
        }
        inner.add(nums[index]);
        subset(index+1, outer, inner, nums);
        inner.removeLast();
        subset(index+1, outer, inner, nums);
    }
}