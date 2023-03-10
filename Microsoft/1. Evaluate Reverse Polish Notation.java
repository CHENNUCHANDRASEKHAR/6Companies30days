//Problem link: https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

// Language:Java


class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s=new Stack<Integer>();
        for(int i=0;i<tokens.length;i++)
        {
            String ch=tokens[i];
            if(ch.equals("+"))
            {
                int a=s.pop();
                int b=s.pop();
                int sum=a+b;
                s.add(sum);
            }
            else if(ch.equals("-"))
            {
                int a=s.pop();
                int b=s.pop();
                int diff=b-a;
                s.add(diff);
            }
            else if(ch.equals("*"))
            {
                int a=s.pop();
                int b=s.pop();
                int mul=a*b;
                s.add(mul);
            }
            else if(ch.equals("/"))
            {
                int a=s.pop();
                int b=s.pop();
                int div=b/a;
                s.add(div);
            }
            else
            {
                int num=Integer.valueOf(ch);
                s.push(num);
            }
        }
        return s.pop();
    }
}
