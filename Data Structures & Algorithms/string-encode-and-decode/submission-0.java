class Solution {

    public String encode(List<String> strs) {
        StringBuilder finalString = new StringBuilder();
        for(String str : strs) {
            finalString.append(str.length()).append("#").append(str);
        }
        return finalString.toString();
    }

    public List<String> decode(String str) {
        List<String> finalList = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            int dilimeterIndex = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i,dilimeterIndex));
            int wordStartIndex = dilimeterIndex + 1;
            int wordEndIndex = wordStartIndex + length;
            String word = str.substring(wordStartIndex,wordEndIndex);
            finalList.add(word);
            i = wordEndIndex;
        }

        return finalList;
    }
}

