class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return "";

        String refString = strs[0];

        for(int i = 0; i < refString.length(); i++) {
            char currentChar = refString.charAt(i);

            for(int j = 1; j < strs.length; j++) {
                if(i==strs[j].length() || currentChar!=strs[j].charAt(i)) {
                    return refString.substring(0, i);
                }
            }
        }

        return refString;
    }
}