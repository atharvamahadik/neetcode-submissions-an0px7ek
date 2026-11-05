class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) {
            return false;
        }

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for(int i = 0; i < s.length(); i++) {
            map1[s.charAt(i) - 'a']++;
            map2[t.charAt(i) - 'a']++;
        } 

        return Arrays.equals(map1,map2);




        

    }
}
