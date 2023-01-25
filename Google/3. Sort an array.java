// Problem Link: https://leetcode.com/problems/sort-an-array/

// Language: Java


class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            pq.add(nums[i]);
        }
        int sorted[]=new int[n];
        for(int i=0;i<n;i++)
        {
            sorted[i]=pq.poll();
        }
        return sorted;
    }
}
