import java.util.*;

class Solution {
    ListNode head;
    Random rand;
    int keep;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode h) {
        head = h;
        rand = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int i = 1;
        keep = head.val;
        ListNode curr = head;
        while (curr != null) {
            if (rand.nextInt(i) == 0) {
                keep = curr.val;
            }
            curr = curr.next;
            i++;
        }
        return keep;
    }
}