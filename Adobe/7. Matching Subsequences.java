// Problem Link: https://leetcode.com/problems/number-of-matching-subsequences/

// Langauge: Java


class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int i,j,k;
        int n = s.length();
        int w = words.length;
        int count = 0;
        HashMap<Character, Queue<String>> map = new HashMap<>();
        for(i=0;i<w;i++){
            if(map.containsKey(words[i].charAt(0)) == false){
                Queue<String> q = new LinkedList<String>();
                q.offer(words[i]);
                map.put(words[i].charAt(0), q);
            }
            else{
                map.get(words[i].charAt(0)).offer(words[i]);
            }
        }
        
        for(i=0;i<n;i++){
            Queue<String> q = map.get(s.charAt(i));
            Queue<String> q2 = new LinkedList<String>();
            while(q != null && q.isEmpty() == false){
                String temp = q.poll();
                if(temp.length() == 1){
                    count++;
                }
                else{
                    String substring = temp.substring(1, temp.length());
                    if(substring.charAt(0) != s.charAt(i)){
                        if(map.containsKey(substring.charAt(0)) == false){
                            Queue<String> q1 = new LinkedList<String>();
                            q1.offer(substring);
                            map.put(substring.charAt(0), q1);
                        }
                        else{
                            map.get(substring.charAt(0)).offer(substring);
                        }
                    }
                    else{
                        q2.offer(substring);
                    }
                }
            }
            
            while(q2.isEmpty() == false){
                if(map.containsKey(s.charAt(i)) == false){
                    Queue<String> q1 = new LinkedList<String>();
                    q1.offer(q2.poll());
                    map.put(s.charAt(i), q1);
                }
                else{
                    map.get(s.charAt(i)).offer(q2.poll());
                }
            }
        }        
        return count;
    }
}
