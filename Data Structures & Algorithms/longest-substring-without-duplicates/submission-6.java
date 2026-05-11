class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> map = new HashSet<>();
        int l = 0;
        int r = 0;
        int maxLength = 0;
        while(r < s.length()) {
            char currentChar = s.charAt(r);
            while(map.contains(currentChar)){
                map.remove(s.charAt(l));
                l++;
            }
            map.add(currentChar);
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
    }
}