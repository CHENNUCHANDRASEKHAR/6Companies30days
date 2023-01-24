// Problem Link: https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

//Language: Java


class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list = new ArrayList<>();
        rec(root1, list);
        rec(root2, list);
        Collections.sort(list);
        return list;
    }
    public void rec(TreeNode root, ArrayList<Integer> l){
        if(root==null)
            return;
        l.add(root.val);
        rec(root.left,l);
        rec(root.right,l);
    }
}
