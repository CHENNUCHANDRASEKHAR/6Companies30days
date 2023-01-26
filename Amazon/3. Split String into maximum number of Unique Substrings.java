// Problem Link: https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/

// Language: Java


class Solution {
    public int maxUniqueSplit(String s) {
        backtracking(s, new HashSet(), 0);
        return max;
    }
    
    int max = 0;
    private void backtracking(String s, Set<String> set, int curPos) {
        if (curPos == s.length()) {
            max = Math.max(max, set.size());
            return;
        }
        
        for (int i = curPos + 1; i <= s.length(); ++i) {
            String substring = s.substring(curPos, i);
            if (!set.contains(substring)) {
                set.add(substring);
                backtracking(s, set, i);
                set.remove(substring);
            }
        }
    }
}
