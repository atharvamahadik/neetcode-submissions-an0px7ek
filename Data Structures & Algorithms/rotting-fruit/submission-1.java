class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c]==1){
                    freshCount++;
                }
                if(grid[r][c]==2){
                    queue.offer(new int[]{r,c});
                }
            }
        }

        if(freshCount == 0) return 0;

        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

        int minutes = 0;

        while(!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            minutes++;
            for(int i = 0; i < size; i++) {
                int[] fruit = queue.poll();
                int currRow = fruit[0];
                int currCol = fruit[1];
                for(int[] direction : directions) {
                    int nextRow = direction[0] + currRow;
                    int nextCol = direction[1] + currCol;
                    if(nextRow >=0 && nextCol >= 0 && nextRow < rows && nextCol < cols && grid[nextRow][nextCol] == 1) {
                        grid[nextRow][nextCol] = 2;
                        freshCount--;
                        queue.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
        }

        if(freshCount==0) {
            return minutes;
        }
        else {
            return -1;
        }
    }
}
