//Problem Link: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

//Language: Java


class Solution {
    public int numberOfSubstrings(String s)
    {
        int[] letters = new int[3];
        int ans =0;
        int start =0;
        
        for(int i=0; i<s.length();i++)
        {
            letters[s.charAt(i) - 'a']++;
            
            while(letters[1] > 0 && letters[2] > 0 && letters[0] > 0)
            {
                ans = ans + s.length()-i;
                letters[s.charAt(start++) - 'a']--;
            }
        }
        return ans;
    }
}
