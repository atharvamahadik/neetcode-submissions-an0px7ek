class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int maxFreq = 0;
        int windowLength = 0;
        int[] count = new int[26];
        while(r < s.length()) {
            count[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(r) - 'A']);
            while((r-l+1) - maxFreq > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }
            windowLength = Math.max(windowLength, r-l+1);
            r++;
        }
        return windowLength;
    }
}

// k = 2
// X Y Y X
// 0 1 2 3
// l
//         r
// maxFreq = 2
// windowLen = 2
// X Y
// 1 2

