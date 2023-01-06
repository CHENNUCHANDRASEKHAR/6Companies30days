// Problem Link: https://leetcode.com/problems/combination-sum-iii/description/

//Language: Java

class Solution {

    public void f(int start,int end,int k,int sum,List<List<Integer>> comb,List<Integer> subset)
    {
        if(k==0)
        {
            if(sum==0)
            {
                comb.add(new ArrayList<>(subset));
            }
        }
        else 
        {
            for(int i=start;i<=end;i++)
            {
                if(sum-i>=0)
                {
                    subset.add(i);
                    f(i+1,end,k-1,sum-i,comb,subset);
                    subset.remove(subset.size()-1);
                }
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> comb=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        int sum=n;
        f(1,9,k,n,comb,subset);
        return comb;
    }
}
