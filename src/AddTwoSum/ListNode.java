package AddTwoSum;

/*
 * Author: Rocky Stone
 * Date:   2019-07-31
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int i){
        this.val = i;
    }

    public int val(){
        return val;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;

        while(p != null || q != null){
            int x = (p !=  null) ? p.val : 0;
            int y = (q !=  null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }

        if(carry > 0){
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    public static ListNode createList(int[] num){
        ListNode list = null;
        ListNode curr = null;

        for(int number : num){
            ListNode node = new ListNode(number);

            if(list == null){
                list = node;
                curr = list;
            }else{
                curr.next = node;
                curr = node;
            }
        }

        return list;
    }

    public static void printList(ListNode list) {
        if (list == null) {
            return;
        }

        ListNode curr = list;

        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

        System.out.println();
    }
}
