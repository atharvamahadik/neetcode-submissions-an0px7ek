class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1) return intervals;
        Arrays.sort(intervals, ((a,b) -> Integer.compare(a[0], b[0])));
        List<int[]> merged = new ArrayList<>();
        int[] active = intervals[0];
        merged.add(active);

        for(int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if(current[0] <= active[1]) {
                active[1] = Math.max(active[1], current[1]);
            } else {
                merged.add(current);
                active = current;
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}




