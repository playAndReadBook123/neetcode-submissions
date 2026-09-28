class Solution {

    int rows = 0;
    int cols = 0;
    int[][] grid;
    boolean[][] visited;
    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        visited = new boolean[rows][cols];
        int res = 0;

        for(int i = 0 ; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    res += dfs(i, j);
                }
            }
        }

        return res;
    }

    int dfs(int r, int c){

        if(r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0){
            return 1;
        }

        if(visited[r][c]){
            return 0;
        }

        visited[r][c] = true;

        return dfs(r+1, c) + dfs(r, c+1) + dfs(r-1, c) + dfs(r, c-1);
    }
}