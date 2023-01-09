//Problem Link: https://leetcode.com/problems/split-array-into-consecutive-subsequences/

// Language: Java


class Solution {
    public boolean isPossible(int[] nums) {
        List<List<Integer>> listMain = new ArrayList<>();
        List<Integer> firstStack = new ArrayList<>();
        firstStack.add(nums[0]);
        listMain.add(firstStack);
        for (int i = 1; i < nums.length; i++) {
            boolean sticksNowhere = true;
            for (int j = listMain.size() - 1; j >= 0 ; j--) 
            {
                List<Integer> stackCurrent = listMain.get(j);
                if (nums[i] == stackCurrent.get(stackCurrent.size() - 1) + 1) 
                {
                    stackCurrent.add(nums[i]);
                    sticksNowhere = false;
                    break;
                }
            }
            if (sticksNowhere) 
            {
                List<Integer> stack = new ArrayList<>();
                stack.add(nums[i]);
                listMain.add(stack);
            }
        }

        for (int i = 0; i < listMain.size(); i++) 
        {
            if (listMain.get(i).size() < 3) 
            {
                return false;
            }
        }
        return true;
    }
}
