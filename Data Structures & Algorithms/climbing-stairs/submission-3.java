class Solution {
    public int climbStairs(int n) {
        /*
        O(N) space complexity solution:
        if(n==1) return 1;
       int[] ans = new int[n+1];
       ans[1] = 1;
       ans[2] = 2;
       for(int i = 3; i <= n ; i++) {
        ans[i] = ans[i-1] + ans[i-2];
       }
       return ans[n];
        */

        // O(1) space complexity solution, using only 2 variables

        if(n==1) return 1;
        if(n==2) return 2;
        int prev2 = 1;
        int prev1 = 2;
        for(int i = 3; i <= n; i++) {
            int temp = prev1;
            prev1 = prev2+prev1;
            prev2 = temp;
        }
        return prev1;
    }
}
