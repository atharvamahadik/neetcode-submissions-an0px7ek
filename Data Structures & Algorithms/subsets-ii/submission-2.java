class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        Arrays.sort(nums);
        subset(0, outer, inner, nums);
        return outer;
    }

    private void subset(int index, List<List<Integer>> outer, List<Integer> inner, int[] arr) {
        outer.add(new ArrayList<>(inner));
        
        if(index == arr.length) {
            return;
        }

        for(int i = index; i < arr.length; i++) {
            if(i > index && arr[i-1]==arr[i]) {
                continue;
            }
            inner.add(arr[i]);
            subset(i+1, outer, inner, arr);
            inner.removeLast();
        } 
    }
}
