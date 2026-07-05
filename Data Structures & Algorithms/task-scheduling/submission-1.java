class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqMap = new int[26];

        for(char c : tasks) {
            freqMap[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for(int i : freqMap) {
            if(i > 0) {
                maxHeap.offer(i);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int time = 0;

        while(!queue.isEmpty() || !maxHeap.isEmpty()) {
            time++;

            if(!queue.isEmpty() && time==queue.peek()[1]) {
                maxHeap.offer(queue.poll()[0]);
            }
        
            if(!maxHeap.isEmpty()) {
                int remainingCount = maxHeap.poll() - 1;
                if(remainingCount > 0) {
                    queue.offer(new int[]{remainingCount, time + n + 1});
                }
            }
        }

        return time;

    }
}


