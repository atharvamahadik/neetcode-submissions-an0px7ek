class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> outer = new ArrayList<>();
        List<String> inner = new ArrayList<>();
        sub(0, outer, inner, s);
        return outer;
    }

    private void sub(int index, List<List<String>> outer, List<String> inner, String s) {
        
        if(index==s.length()) {
            outer.add(new ArrayList<>(inner));
            return;
        }

        for(int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);

            if(isPalindrome(substring)) {
                inner.add(substring);
                sub(i+1,outer,inner,s);
                inner.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
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
