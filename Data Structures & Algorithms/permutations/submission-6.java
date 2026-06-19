class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        permutation(0, outer, nums);
        return outer;
    }

    private void permutation(int index, List<List<Integer>> outer, int[] arr) {
        if(index==arr.length) {
            List<Integer> inner = new ArrayList<>();
            for(int num: arr) {
                inner.add(num);
            }
            outer.add(inner);
            return;
        }
        for(int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permutation(index + 1, outer, arr);
            swap(arr,index,i);
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
