// Problem Link: https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/

// Language: Java


class Solution {
    public int maxConsecutive(int x, int y, int[] a) {
        Arrays.sort(a);
        int r=Math.max(a[0]-x,y-a[a.length-1])+1;
        for (int i=0;i<a.length-1;i++)
        {
            if (a[i+1]-a[i]>r)
            {
                r=a[i+1]-a[i];
            }
        }
        return r-1;
    }
}
