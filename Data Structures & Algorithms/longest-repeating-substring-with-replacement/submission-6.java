class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqMap = new int[26];
        int l = 0;
        int r = 0;

        int maxLength = 0;
        int maxFreq = 0;

        while(r < s.length()) {
            char c = s.charAt(r);
            freqMap[c - 'A']++;
            maxFreq = Math.max(maxFreq, freqMap[c - 'A']);
            while((r - l + 1) - maxFreq > k) {
                freqMap[s.charAt(l) - 'A']--;
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;

    }
}
