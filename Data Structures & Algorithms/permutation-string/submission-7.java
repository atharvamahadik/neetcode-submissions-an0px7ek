class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];

        if(s1.length() > s2.length()) {
            return false;
        }
        for(int i = 0; i<s1.length(); i++) {
            map1[s1.charAt(i) - 'a']++;
        }
        for(int i = 0; i<s1.length(); i++) {
            map2[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(map1,map2)) {
            return true;
        }
        int l = 0;
        int r = s1.length();
        while(r < s2.length()) {
            map2[s2.charAt(r) - 'a']++;
            map2[s2.charAt(l) - 'a']--;
            if(Arrays.equals(map1,map2)) {
                return true;
            }
            l++;
            r++;
        }
        return false;
    }
}





// a b c
// 1 1 1
 

// l e c a b e e
// 0 1 2 3 4 5 6
//   l
//         r