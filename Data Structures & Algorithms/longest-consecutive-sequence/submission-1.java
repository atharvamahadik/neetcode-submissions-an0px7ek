class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;

        for(int num : set) {
            if(!set.contains(num - 1)) {
                int currentStreak = 1;
                int currentNum = num;
                while(set.contains(currentNum+1)) {
                    currentStreak++;
                    currentNum++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
