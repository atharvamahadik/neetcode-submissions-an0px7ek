class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> innerList = new ArrayList<>();
        List<List<Integer>> outerList = new ArrayList<>();
        createSubsets(0,outerList,innerList,nums);
        return outerList;
    }

    private void createSubsets(int index, List<List<Integer>> outerList,
     List<Integer> innerList, int[] nums) {
        if(index==nums.length){
            outerList.add(new ArrayList<>(innerList));
            return;
        }

        innerList.add(nums[index]);
        createSubsets(index+1,outerList,innerList,nums);
        innerList.removeLast();
        createSubsets(index+1,outerList,innerList,nums);
    }
}

