// Problem Link: https://leetcode.com/problems/maximum-sum-of-an-hourglass/

// Language: Java



class Solution {
    public int maxSum(int[][] grid) {
        int[][] sum = new int[grid.length + 1][grid[0].length + 1];
        for(int i=1;i<=grid.length;i++){
            for(int j=1;j<=grid[0].length;j++){
                sum[i][j] = sum[i][j-1] + grid[i-1][j-1];
            }
        }
        int res = 0;
        for(int i=1;i<grid.length - 1;i++){
            for(int j=1;j<grid[0].length - 1;j++){
                int n = grid[i][j] + sum[i][j+2] - sum[i][j-1] + sum[i+2][j+2] - sum[i+2][j-1];
                res = Math.max(res, n);
            }
        }
        return res;
    }
}
