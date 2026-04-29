class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int maxProfit = 0;
        while(r<prices.length) {
            if(prices[l]>=prices[r]){
                l = r;
            } else {
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            }
            r++;
        }
        return maxProfit;
    }
}


/* 

10 2 5 6 7 1
 l
   r

*/