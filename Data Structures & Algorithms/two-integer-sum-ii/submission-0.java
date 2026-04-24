class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int[] output = new int[2];
        
        while(l<r) {
            if((numbers[l]+numbers[r]) == target) {
                output[0] = l+1;
                output[1] = r+1;
                break;
            }
            else if((numbers[l]+numbers[r]) > target) {
                r = r - 1;
            }
            else {
                l = l + 1;
            }
        }
        return output;

    }
}
