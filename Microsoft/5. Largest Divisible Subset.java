// Problem Link: https://leetcode.com/problems/largest-divisible-subset/description/

// Language: Java


class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) 
    {
        int n = arr.length;
        Arrays.sort(arr);
        int dp[]=new int[n];
        int hash[]=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(hash,1);
        for(int i=0; i<=n-1; i++)
        {
            hash[i]= i; 
            for(int prev_index = 0; prev_index <=i-1; prev_index ++)
            {
                if(arr[i]%arr[prev_index] == 0 && 1 + dp[prev_index] > dp[i])
                {
                    dp[i] = 1 + dp[prev_index];
                    hash[i] = prev_index;
                }
            }
        }

        int ans = -1;
        int lastIndex =-1;

        for(int i=0; i<=n-1; i++)
        {
            if(dp[i]> ans)
            {
                ans = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> temp=new ArrayList<>();
        temp.add(arr[lastIndex]);
        while(hash[lastIndex] != lastIndex)
        {  
            lastIndex = hash[lastIndex];
            temp.add(arr[lastIndex]);
        }
        Collections.reverse(temp);
        return temp;
    }
}
