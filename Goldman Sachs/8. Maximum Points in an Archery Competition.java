//Problem Link: https://leetcode.com/problems/maximum-points-in-an-archery-competition/

//Language: Java



class Solution {
    int max=0;
    int[] res=new int[12];
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        backtracker(new int[12],aliceArrows,0,0,numArrows);
        return this.res;
    }
    
    public void backtracker(int[] b, int[] a,int start,int curscore, int total)
    {
        if(total<=0||start>11)
        {
            if(curscore>max)
            {
                max=curscore;
                for(int i=0;i<12;i++) 
                {
                    this.res[i]=b[i];
                }
                if(total>0) res[0]+=total;
            }
            return;
        }
        for(int i=start;i<12;i++)
        {
            b[i]=Math.min(a[i]+1,total);
            total-=b[i];
            curscore+=b[i]>a[i]?i:0;
            backtracker(b,a,i+1,curscore,total);
            total+=b[i];
            curscore-=b[i]>a[i]?i:0;
            b[i]=0;
        }
    }
}
