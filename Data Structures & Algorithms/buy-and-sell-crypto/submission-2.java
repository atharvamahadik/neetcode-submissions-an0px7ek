class Solution {
    public int maxProfit(int[] prices) {
        int l = 0; //buy price
        int r = 1; //sell price
        int maxProfit = 0;

        while(r < prices.length) {
            if(prices[l] >= prices[r]) {
                l = r;
                r++;
            }
            else {
                maxProfit = Math.max(prices[r]-prices[l], maxProfit);
                r++;
            }
        }
        return maxProfit;
    }
}


/*

10 1 5 6 7 1
   l r

*/
