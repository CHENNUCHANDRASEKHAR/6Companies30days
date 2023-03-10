// Problem Link: https://leetcode.com/problems/maximum-matrix-sum/

// Language: Java


class Solution {
    public long maxMatrixSum(int[][] matrix) {
	    long sum = 0, count = 0, min = Integer.MAX_VALUE;
	    for(int i=0;i<matrix.length;i++)
	    	for(int j=0;j<matrix[0].length;j++) {
	    		if(matrix[i][j] < 0) {
	    			count++;
	    			matrix[i][j] *= -1;
	    		}
	    		min = Math.min(min, matrix[i][j]);
	    		sum += matrix[i][j];
	    	}
	    return count%2!=0 ? sum-min*2 : sum;
    }
}
