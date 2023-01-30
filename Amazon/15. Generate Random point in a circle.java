// Problem Link: https://leetcode.com/problems/generate-random-point-in-a-circle/

// Language: Java



class Solution {
    
    double x;
    double y;
    double r;
    Random rand;

    public Solution(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
        
        rand = new Random(System.currentTimeMillis());
    }
    
    public double[] randPoint() {
        double[] ret = new double[2];
        do {
            ret[0] = rand.nextDouble() * 2 * r - r;
            ret[1] = rand.nextDouble() * 2 * r - r;
        } while (Math.sqrt(ret[0]*ret[0] + ret[1]*ret[1]) > r);
        
        ret[0] += x;
        ret[1] += y;
        
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
