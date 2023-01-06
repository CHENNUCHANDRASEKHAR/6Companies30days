//Problem link: https://leetcode.com/problems/bulls-and-cows/description/

// Language: Java


class Solution {
    public String getHint(String secret, String guess) {
        int cows=0,bulls=0;
        HashMap<Character,Integer> secretHash=new HashMap<>();
        HashMap<Character,Integer> guessHash=new HashMap<>();
        for(int i=0;i<secret.length();i++)
        {
            char s=secret.charAt(i);
            char g=guess.charAt(i);
            if(s==g)
            {
                bulls+=1;
            }
            else
            {
                secretHash.put(s,secretHash.getOrDefault(s,0)+1);
                guessHash.put(g,guessHash.getOrDefault(g,0)+1);
            }
        }
        for(char ch:secretHash.keySet())
        {
            if(guessHash.containsKey(ch))
            {
                cows+=Math.min(secretHash.get(ch),guessHash.get(ch));
            }
        }
        return bulls+"A"+cows+"B";
    }
}
