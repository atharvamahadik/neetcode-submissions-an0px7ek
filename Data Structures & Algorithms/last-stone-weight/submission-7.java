class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: stones) {
            maxHeap.offer(i);
        }

        while(maxHeap.size() > 1) {
            int y = maxHeap.isEmpty() ? 0 : maxHeap.poll();
            int x = maxHeap.isEmpty() ? 0 : maxHeap.poll();
            if(x < y) {
                maxHeap.offer(y-x);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();

    }
}
