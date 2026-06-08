class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> internal = new ArrayList<>();
        List<List<Integer>> external = new ArrayList<>();

        include(0, internal, external, nums);
        return external;
    }

    private void include(int index, List<Integer> internal, List<List<Integer>> external, int[] nums) {
        if(index == nums.length) {
            external.add(new ArrayList<>(internal));
            return;
        }
        internal.add(nums[index]);
        include(index + 1, internal, external, nums);
        internal.remove(internal.size() - 1);
        include(index + 1, internal, external, nums);
    }
}
