package linkedlist;

public class AddTwoNumbers_223 {
    public ListNode add2Numbers(ListNode one, ListNode two) {
        // corner case:
        if (one == null || two == null) {
            return one == null ? two : one;
        }
        // general case:
        int remain = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (one != null || two != null) {
            int sum = remain;
            if (one != null) {
                sum += one.value;
                one = one.next;
            }
            if (two != null) {
                sum += two.value;
                two = two.next;
            }
            cur.next = new ListNode(sum % 10);
            remain = sum / 10;
            cur = cur.next;
        }
        if (remain != 0) {
            cur.next = new ListNode(remain);
        }
        return dummy.next;

    }
//    time complexity: O(m + n)
//    space complexity: O(1)

}
