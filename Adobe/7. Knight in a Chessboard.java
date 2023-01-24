// Problem Link: https://leetcode.com/problems/knight-probability-in-chessboard/

// Language: Java


class Solution {
    private int[][] DIRECTIONS = new int[][]{{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
    
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[N][N][K + 1];
        return helper(N, K, r, c, dp);
    }
    
    private double helper(int N, int K, int r, int c, double[][][] dp) {
        if (r < 0 || r >= N || c < 0 || c >= N) return 0;
        if (K == 0) return 1;
        if(dp[r][c][K] != 0) return dp[r][c][K];
        
        double probability = 0.0;
        for (int[] d : DIRECTIONS) {
            probability += (1.0 / 8) * helper(N, K - 1, r + d[0], c + d[1], dp);
        }
        
        dp[r][c][K] = probability;
        return probability;
    }
}
