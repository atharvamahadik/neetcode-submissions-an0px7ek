class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        for(int i = 0; i < tasks.length; i++) {
            freq[tasks[i] - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0){
                maxHeap.offer(freq[i]);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            if(!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.offer(queue.poll()[0]);
            }

            if(!maxHeap.isEmpty()) {
                int remainingCount = maxHeap.poll() - 1;
                if(remainingCount > 0) {
                    queue.offer(new int[]{remainingCount, time+n+1});
                }
            }

        }
        return time;
    }
}