package AddTwoSum;

/*
 * Author: Rocky Stone
 * Date:   2019-07-31
 */

public class AddTwoNum {
    public static void main(String[] args){

        ListNode list1 = ListNode.createList(new int[]{1,2,3,4,5,6,7,8,9});
        ListNode list2 = ListNode.createList(new int[]{9,8,7,6,5,4,3,2,1});


        ListNode.printList(list1);
        ListNode.printList(list2);
        ListNode.printList(ListNode.addTwoNumbers(list1, list2));
    }
}