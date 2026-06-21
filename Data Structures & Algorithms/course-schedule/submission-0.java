class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] pair : prerequisites) {
            int course = pair[0];
            int pre = pair[1];
            graph.get(pre).add(course);
        }

        int[] visited = new int[numCourses];
        int[] pathVisited = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(visited[i]==0){
                if(hasCycle(i,graph,visited,pathVisited)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCycle(int course, List<List<Integer>> graph, int[] visited, int[] pathVisited) {
        
        if(pathVisited[course]==1) {
            return true;
        }
        if(visited[course]==1){
            return false;
        }
        visited[course]=1;
        pathVisited[course]=1;

        for(int nextCourse : graph.get(course)) {
            if(hasCycle(nextCourse, graph, visited, pathVisited)) {
                return true;
            }
        }
        pathVisited[course] = 0;
        return false;
    }
}
