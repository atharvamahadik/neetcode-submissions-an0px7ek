class Solution {
    public String minWindow(String s, String t) {
        int[] targetCount = new int[126];
        int[] windowCount = new int[126];
        int need = 0;

        for(char c : t.toCharArray()) {
            if(targetCount[c]==0) {
                need++;
            }
            targetCount[c]++;
        }

        int l = 0;
        int minLeft = 0;
        int minLength = Integer.MAX_VALUE;
        int have = 0;

        for(int r = 0; r < s.length(); r++) {
            char rightChar = s.charAt(r);

            windowCount[rightChar]++;
            if(targetCount[rightChar] > 0 && windowCount[rightChar]==targetCount[rightChar]) {
                have++;
            }

            while(have == need) {
                char leftChar = s.charAt(l);
                if((r-l+1) < minLength) {
                    minLength = r-l+1;
                    minLeft = l;
                }
                windowCount[leftChar]--;
                if(targetCount[leftChar]>0 && windowCount[leftChar] < targetCount[leftChar]) {
                    have--;
                }
                l++;
            }

        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLength + minLeft);

    }
}
