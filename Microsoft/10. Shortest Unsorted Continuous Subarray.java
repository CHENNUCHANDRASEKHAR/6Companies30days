//Problem Link: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/

//Language: Java


class Solution {
    public int findUnsortedSubarray(int[] nums) {
		int[] array = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			array[i] = nums[i];
		}
		Arrays.sort(array);
		int end = 0;
		int start = nums.length;
		for(int i = 0; i < nums.length; i++) {
			if(array[i] != nums[i]) {
				start = Math.min(start, i);
				end = Math.max(end, i);
			}
		}
		if (end-start > 0) {
			return end-start+1;
		}
		else {
			return 0;
		}
    }
}
