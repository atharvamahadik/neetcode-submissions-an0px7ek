class Solution {
    public int rob(int[] nums) {
        int lootTwoHousesAgo = 0;
        int lootOneHouseAgo = 0;

        for(int currentHouse : nums) {
            int currentMax = Math.max(currentHouse + lootTwoHousesAgo, lootOneHouseAgo);
            lootTwoHousesAgo = lootOneHouseAgo;
            lootOneHouseAgo = currentMax;
        }

        return lootOneHouseAgo;
    }
}

