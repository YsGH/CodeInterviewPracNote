// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.

// Example 1:

// 11110
// 11010
// 11000
// 00000
// Answer: 1

// Example 2:

// 11000
// 11000
// 00100
// 00011
// Answer: 3

public class Solution {
    int m=0;
    int n=0;
    public int numIslands(char[][] grid) {
        m=grid.length;
        if (m==0) {
            return 0;
        }
        n=grid[0].length;
        int res=0;
        boolean[][] visited=new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j] || grid[i][j]=='0') {
                    continue;
                }
                dfs(visited, grid, i, j);
                res++;
            }
        }
        return res;
    }
    
    public void dfs(boolean[][] visited, char[][]grid, int i, int j) {
        if (i<0 || i>=m || j<0 || j>=n || visited[i][j] || grid[i][j]=='0') {
            return;
        }
        visited[i][j]=true;
        dfs(visited, grid, i+1, j);
        dfs(visited, grid, i-1, j);
        dfs(visited, grid, i, j+1);
        dfs(visited, grid, i, j-1);
    }
}