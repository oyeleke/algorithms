package LeetCode;

import static LeetCode.LeetListCode.*;

public class PartitionList {
    class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head == null) return head;
            ListNode lessThanPivot = new ListNode(0, null);
            ListNode equalsOrGreaterThanPivot = new ListNode(0, null);
            ListNode lessThanPivotIter = lessThanPivot;
            ListNode equalsOrGreaterThanPivotIter = equalsOrGreaterThanPivot;
            ListNode iter = head;

            while(iter != null){
                if (iter.val < x){
                    lessThanPivotIter.next = iter;
                    lessThanPivotIter = iter;
                } else {
                    equalsOrGreaterThanPivotIter.next = iter;
                    equalsOrGreaterThanPivotIter = iter;
                }
                iter = iter.next;
            }

            equalsOrGreaterThanPivotIter.next = null;
            lessThanPivotIter.next = equalsOrGreaterThanPivot.next;
            return lessThanPivot.next;
        }
    }
}
