class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 1) {
                    freshCount++;
                }
                if(grid[r][c] == 2) {
                    queue.offer(new int[]{r,c});
                }
            }
        }

        int minutes = 0;
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

        while(!queue.isEmpty() && freshCount > 0) {
            minutes++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] fruit = queue.poll();
                int row = fruit[0];
                int col = fruit[1];
                for(int[] dir : directions) {
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];
                    if(nextRow >= 0 && nextCol >= 0 && nextRow < rows && nextCol < cols && grid[nextRow][nextCol] == 1) {
                        freshCount--;
                        grid[nextRow][nextCol] = 2;
                        queue.offer(new int[]{nextRow,nextCol});
                    }
                }
            }
        }

        if(freshCount==0) {
            return minutes;
        } else {
            return -1;
        }
    }
}
