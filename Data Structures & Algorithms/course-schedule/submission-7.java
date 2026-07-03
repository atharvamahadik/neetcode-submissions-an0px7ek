class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            graph.add(i, new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] pair : prerequisites) {
            int course = pair[1];
            int prereq = pair[0];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;

        while(!queue.isEmpty()) {
                int course = queue.poll();
                count++;
                for(int nextCourse : graph.get(course)) {
                    indegree[nextCourse]--;
                    if(indegree[nextCourse]==0) {
                        queue.offer(nextCourse);
                    }
                }
        }

        return count == numCourses;


        
    }
}
