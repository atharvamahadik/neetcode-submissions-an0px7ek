class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        permutation( outer, inner, flag, nums);
        return outer;
    }

    private void permutation( List<List<Integer>> outer, List<Integer> inner,boolean[] flag,int[] arr) {
       if(inner.size()==arr.length) {
        outer.add(new ArrayList<>(inner));
        return;
       }

        for(int i = 0; i < arr.length; i++) {
            if(!flag[i]) {
                flag[i]=true;
                inner.add(arr[i]);
                permutation(outer, inner, flag, arr);
                inner.removeLast();
                flag[i]=false;
            }
        }
    }
}
