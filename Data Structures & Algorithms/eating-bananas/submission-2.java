class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int low = 1;
        int high = 1;

        for(int i : piles) {
            if(i>high) {
                high = i;
            }
        }

        int result = high;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(isEnough(piles,h,mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;

    }

    private boolean isEnough(int[] piles, int h, int k) {

        int totalHours = 0;
        for(int pile : piles) {
            totalHours += (pile + k - 1) / k;
        }
        return totalHours <= h;
    }

    




}