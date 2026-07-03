class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0 ; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }

        for(int[] pair : edges) {
            int node1 = pair[0];
            int node2 = pair[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                count++;
                queue.offer(i);
                visited[i] = true;
                while(!queue.isEmpty()){
                    int curr = queue.poll();
                    for(int next : graph.get(curr)) {
                        if(!visited[next]){
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }
                }
            }
        }

        return count;

        

    }

}
