//Problem Link: https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/

// Language: Java


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    cur.next = head;
    int prefix =0;
    HashMap<Integer,ListNode> map = new HashMap<>();
    while(cur != null){
        prefix += cur.val;         
        if(map.containsKey(prefix)){           
            cur = map.get(prefix).next; 
            int imposters = prefix + cur.val; 
            while(imposters != prefix){   
                map.remove(imposters);
                cur = cur.next;
                imposters += cur.val;    
            }
            map.get(prefix).next = cur.next;      
        }
        else{
            map.put(prefix,cur);
        }
       cur = cur.next; 
    }
    return dummy.next;
    }
}
