// Problem Link: https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/

// Language: Java



class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> hashset=new HashSet();
        int n=s.length();
        for(int i=0;i<=n-k;i++)
        {
            hashset.add(s.substring(i,i+k));
        }
        return hashset.size()==(1<<k);
    }
}
