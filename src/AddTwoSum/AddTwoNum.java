package AddTwoSum;

/*
 * Author: Rocky Stone
 * Date:   2019-07-31
 *
 * Description: This problem is form leetcode.
 *              The original problem is as follows:
 *
 *              You are given two non-empty linked lists representing two non-negative integers.
 *              The digits are stored in reverse order and each of their nodes contain a single digit.
 *              Add the two numbers and return it as a linked list.
 *              You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *              Example
 *              Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *              Output: 7 -> 0 -> 8
 *              Explanation: 342 + 465 = 807.
 *
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