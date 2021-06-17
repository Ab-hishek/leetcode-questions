/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Constraints:

1. The number of nodes in each linked list is in the range [1, 100].
2. 0 <= Node.val <= 9
3. It is guaranteed that the list represents a number that does not have leading zeros.
*/

// Definition for singly-linked list.
public class ListNode {

  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class AddTwoNumbers {

  ListNode head;

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int len1 = 0, len2 = 0;
    len1 = getLength(l1);
    len2 = getLength(l2);
    ListNode maxNode = getMax(l1, l2, len1, len2);
    ListNode minNode = getMin(l1, l2, len1, len2);
    int carry = 0, sum = 0;

    for (ListNode i = maxNode; i != null; i = i.next) {
      if (minNode != null) {
        sum = i.val + minNode.val + carry;
        minNode = minNode.next;
      } else {
        sum = i.val + carry;
      }

      carry = sum / 10;
      append(sum % 10);
    }
    if (carry != 0) {
      append(carry);
    }
    return head;
  }

  public void append(int new_data) {
    ListNode new_node = new ListNode(new_data);

    if (head == null) {
      head = new ListNode(new_data);
      return;
    }

    new_node.next = null;

    ListNode last = head;
    while (last.next != null) last = last.next;

    last.next = new_node;
    return;
  }

  int getLength(ListNode l) {
    int len = 0;
    if (l.next == null) {
      len = 1;
    } else {
      while (l.next != null) {
        len += 1;
        l = l.next;
      }
      len += 1;
    }
    return len;
  }

  ListNode getMax(ListNode l1, ListNode l2, int len1, int len2) {
    if (len1 >= len2) {
      return l1;
    } else {
      return l2;
    }
  }

  ListNode getMin(ListNode l1, ListNode l2, int len1, int len2) {
    if (len1 < len2) {
      return l1;
    } else {
      return l2;
    }
  }
}
