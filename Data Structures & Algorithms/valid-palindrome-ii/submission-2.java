class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l<r) {
            if(s.charAt(l)==s.charAt(r)) {
                l++;
                r--;
            }
            else {
                boolean choiceA = isPalindrome(s, l+1, r);
                boolean choiceB = isPalindrome(s, l, r-1);
                return choiceA || choiceB;
            }
        }

        return true;

    }

    private boolean isPalindrome(String s, int l, int r) {
        while(l<r) {
            if(s.charAt(l)!=s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}