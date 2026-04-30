class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int max = 0;
        Set<Character> set = new HashSet<Character>();
        while(r < s.length()) {
            char currentChar = s.charAt(r);
            while(set.contains(currentChar)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(currentChar);
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}


/*

z x y z x y z
0 1 2 3 4 5 6
l
r

*/
