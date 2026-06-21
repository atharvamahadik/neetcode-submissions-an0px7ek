class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i< numCourses; i++) {
            if(indegree[i] == 0) {
            queue.offer(i);
            }
        }

        int processedCount = 0;
        List<Integer> ans = new ArrayList<>();

        while(!queue.isEmpty()) {
            processedCount++;
            int course = queue.poll();
            ans.add(course);
            for(int nextCourse: graph.get(course)) {
                indegree[nextCourse]--;
                if(indegree[nextCourse]==0) {
                    queue.offer(nextCourse);
                }
            }
        }

        
        return processedCount==numCourses;
        
    }
}
