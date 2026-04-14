class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;
        while (true) {
            ListNode kth = prevGroup;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) break;
            ListNode groupStart = prevGroup.next;
            ListNode nextGroup = kth.next;
            ListNode prev = nextGroup;
            ListNode curr = groupStart;
            while (curr != nextGroup) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            prevGroup.next = kth;
            prevGroup = groupStart;
        } 
        return dummy.next;
    }
}
