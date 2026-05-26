class KthLargest {

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for(int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        
        minHeap.offer(val);

        if(minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
        
    }
}



// 3 rd largest integer

// priority queue is created


// 5
// 6
// 7
// 8
