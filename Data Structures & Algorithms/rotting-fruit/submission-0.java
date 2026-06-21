class Solution {
    public int orangesRotting(int[][] grid) {

        if(grid==null || grid.length==0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int freshFruits = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c]==1){
                    freshFruits++;
                }
                if(grid[r][c]==2){
                    queue.offer(new int[]{r,c});
                }
            }
        }

        if(freshFruits == 0) return 0;

        int minutes = 0;
        
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        
        while(!queue.isEmpty() && freshFruits > 0) {
            int size = queue.size();
            minutes++;

            for(int i = 0; i < size; i++) {
                int[] fruit = queue.poll();
                int currRow = fruit[0];
                int currCol = fruit[1];

                for(int[] dir : directions) {
                    int nextRow = currRow + dir[0];
                    int nextCol = currCol + dir[1];

                    if(nextRow >= 0 && nextRow<rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol]==1){
                        
                        grid[nextRow][nextCol]=2;
                        freshFruits--;
                        queue.offer(new int[]{nextRow,nextCol});
                        
                    }
                }
            }

        }

        if(freshFruits==0){
            return minutes;
        } else {
            return -1;
        } 
    }
}
