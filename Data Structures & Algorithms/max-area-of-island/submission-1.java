class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 1) {
                    int[] currentArea = new int[1];
                    dfs(currentArea, r, c, rows, cols, grid);
                    maxArea = Math.max(currentArea[0], maxArea);
                }
            }
        }

        return maxArea;
    }

    private void dfs(int[] currentArea, int r, int c, int rows, int cols, int[][] grid) {

        if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) {
            return;
        }
        currentArea[0]++;
        grid[r][c] = 0;
        dfs(currentArea, r + 1, c, rows, cols, grid);
        dfs(currentArea, r - 1, c, rows, cols, grid);
        dfs(currentArea, r, c + 1, rows, cols, grid);
        dfs(currentArea, r, c - 1, rows, cols, grid);
    }
}
