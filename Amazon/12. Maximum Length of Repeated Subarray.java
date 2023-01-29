// Problem Link: https://leetcode.com/problems/maximum-length-of-repeated-subarray/

// Language: Java



class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        
        int dp[][] = new int [m + 1][n + 1];
        int result = 0;
        
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    result = Math.max(result, dp[i][j]);   
                }
            }
        }
        
        return result;
    }
}
