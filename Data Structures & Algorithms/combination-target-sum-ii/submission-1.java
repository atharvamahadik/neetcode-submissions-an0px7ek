class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        Arrays.sort(candidates);
        combination(0, target, outer, inner, candidates);
        return outer;
    }

    private void combination(int index, int remain, List<List<Integer>> outer, List<Integer> inner, int[] arr) {
        if(remain==0) {
            outer.add(new ArrayList<>(inner));
            return;
        }
        if(remain < 0 || index >= arr.length) {
            return;
        }

        for(int i = index; i < arr.length; i++) {
            if(i > index && arr[i-1]==arr[i]) {
                continue;
            }
            inner.add(arr[i]);
            combination(i+1,remain-arr[i],outer,inner,arr);
            inner.removeLast();
        }
    }
}
