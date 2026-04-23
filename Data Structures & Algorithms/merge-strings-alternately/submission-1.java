class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int l = 0;
        int r = 0;

        while(l<word1.length() && r<word2.length()) {
            merged.append(word1.charAt(l));
            merged.append(word2.charAt(r));
            l++; 
            r++;
        }

        while(l<word1.length()) {
            merged.append(word1.charAt(l));
            l++;
        }

        while(r<word2.length()){
            merged.append(word2.charAt(r));
            r++;
        }

        return merged.toString();
    } 
}