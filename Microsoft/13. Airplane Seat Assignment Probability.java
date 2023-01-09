//Problem Link: https://leetcode.com/problems/airplane-seat-assignment-probability/

//Language: Java


class Solution {
    public double nthPersonGetsNthSeat(int n) {
        if(n==1)
        {
            return 1;
        }
        return 0.5;
    }
}
