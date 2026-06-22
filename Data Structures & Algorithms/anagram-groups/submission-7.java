class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String stringKey = new String(temp);
            if(!map.containsKey(stringKey)) {
                map.put(stringKey, new ArrayList<>());
            }
            map.get(stringKey).add(s);
        }
        return new ArrayList<>(map.values());
    }
}




