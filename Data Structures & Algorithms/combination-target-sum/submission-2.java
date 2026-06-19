class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        combination(0,target,outer,inner,nums);
        return outer;

    }

    private void combination(int index, int remain, List<List<Integer>> outer, List<Integer> inner, int[] arr) {
        if(remain==0) {
            outer.add(new ArrayList<>(inner));
            return;
        }
        if(remain<0 || index==arr.length) {
            return;
        }

        inner.add(arr[index]);
        combination(index,remain-arr[index],outer,inner,arr);
        inner.removeLast();
        combination(index + 1, remain, outer, inner, arr);
    }
}
