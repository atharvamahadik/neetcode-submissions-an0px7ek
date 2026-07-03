class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            graph.add(i, new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i]==0) {
                queue.offer(i);
            }
        }

        int[] ans = new int[numCourses];
        int count = 0;

        while(!queue.isEmpty()) {
            int course = queue.poll();
            ans[count] = course;
            for(int nextCourse : graph.get(course)) {
                indegree[nextCourse]--;
                if(indegree[nextCourse]==0) {
                    queue.offer(nextCourse);
                }
            }
            count++;
        }

        if(count==numCourses){
            return ans;
        } else {
            return new int[0];
        }
        
    }
}
