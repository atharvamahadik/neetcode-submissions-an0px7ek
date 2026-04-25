class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outerList = new ArrayList<List<Integer>>(); 
Arrays.sort(nums);
for(int i = 0; i < nums.length - 2; i++) {
    if(i>0 && nums[i]==nums[i-1]){
        continue;
    }
    int l = i + 1;
    int r = nums.length - 1;
    while(l<r) {
        if((nums[l] + nums[r]) == -nums[i]) {
            List<Integer> innerList = new ArrayList<>(Arrays.asList(nums[i],nums[l],nums[r]));
            outerList.add(innerList);
            l++;
            r--;
            while(l < r && nums[l]==nums[l-1]) {
                l++;
            }
        }
        else if((nums[l] + nums[r]) > -nums[i]) {
            r--;
        }
        else {
            l++;
        }
    }
}
return outerList;

    }
}


/*

List<List<Integer>> outerList = new ArrayList<List<Integer>>(); 
Arrays.sort(nums);
for(int i = 0; i < nums.length - 2; i++) {
    if(i>0 && nums[i]==nums[i-1]){
        continue;
    }
    int l = i + 1;
    int r = nums.length - 1;
    while(l<r) {
        if((nums[l] + nums[r]) == -nums[i]) {
            List<Integer> innerList = new ArrayList<>(Arrays.asList(nums[i],nums[l],nums[r]));
            outerList.add(innerList);
            l++;
            r--;
            while(l < r && nums[l]==nums[l-1]) {
                l++;
            }
        }
        else if((nums[l] + nums[r]) > -nums[i]) {
            r--;
        }
        else {
            l++;
        }
    }
}
return outerList;

*/