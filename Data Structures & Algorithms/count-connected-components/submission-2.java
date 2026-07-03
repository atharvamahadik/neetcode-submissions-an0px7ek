class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }

        for(int[] pair : edges) {
            int node1 = pair[0];
            int node2 = pair[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        boolean[] visited = new boolean[n];
        int count= 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i]=true;
                count++;
                queue.offer(i);
                while(!queue.isEmpty()) {
                    int node = queue.poll();
                    for(int next : graph.get(node)){
                        if(!visited[next]) {
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
