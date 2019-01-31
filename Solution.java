import java.util.*;

class Solution {

  public static void main(String[] args) {

    ListNode l11 = new ListNode(2);
    ListNode l12 = new ListNode(4);
    ListNode l13 = new ListNode(3);
    l11.next = l12;
    l11.next.next = l13;

    ListNode l21 = new ListNode(5);
    ListNode l22 = new ListNode(6);
    ListNode l23 = new ListNode(4);
    l21.next = l22;
    l21.next.next = l23;

    // ListNode l11 = new ListNode(9);

    // ListNode l21 = new ListNode(1);
    // ListNode l22 = new ListNode(9);
    // ListNode l23 = new ListNode(9);
    // l21.next = l22;
    // l21.next.next = l23;

    ListNode result = addTwoNumber(l11, l21);

  }

  public static ListNode addTwoNumber(ListNode l1, ListNode l2) {
    // int l1Length = 1;
    // ListNode tmpList1 = l1;
    // while (true) {
    // if (tmpList1.next == null) {
    // break;
    // } else {
    // tmpList1 = tmpList1.next;
    // }
    // l1Length++;
    // }

    // System.out.println("l1Length: " + l1Length);

    // int l2Length = 1;
    // ListNode tmpList2 = l2;
    // while (true) {
    // if (tmpList2.next == null) {
    // break;
    // } else {
    // tmpList2 = tmpList2.next;
    // }
    // l2Length++;
    // }
    // System.out.println("l2Length: " + l2Length);

    // List<Integer> reverseL1 = new ArrayList<>();
    // for (int i = l1Length - 1; i >= 0; i--) {
    // ListNode tmpLN = l1;
    // int val = tmpLN.val;
    // for (int j = 0; j < i; j++) {
    // tmpLN = tmpLN.next;
    // val = tmpLN.val;
    // }
    // reverseL1.add(val);
    // }

    // List<Integer> reverseL2 = new ArrayList<>();
    // for (int i = l2Length - 1; i >= 0; i--) {
    // ListNode tmpLN = l2;
    // int val = tmpLN.val;
    // for (int j = 0; j < i; j++) {
    // tmpLN = tmpLN.next;
    // val = tmpLN.val;
    // }
    // reverseL2.add(val);
    // }

    // double l1Total = 0;
    // for (int i = reverseL1.size(); i > 0; i--) {
    // l1Total += reverseL1.get(reverseL1.size() - i) * Math.pow(10, i - 1);
    // }
    // double l2Total = 0;
    // for (int i = reverseL2.size(); i > 0; i--) {
    // l2Total += reverseL2.get(reverseL2.size() - i) * Math.pow(10, i - 1);
    // }

    // double total = l1Total + l2Total;

    // System.out.println(l1Total);
    // System.out.println(l2Total);
    // System.out.println(total);

    // String totalStr = String.valueOf(Math.round(total));
    // System.out.println(totalStr);
    // List<String> newTotal = new ArrayList<>();
    // for (int i = 0; i < totalStr.length(); i++) {
    // // newTotal[i] = totalStr.charAt(i) - '0';
    // newTotal.add(String.valueOf(totalStr.charAt(i) - '0'));
    // }

    // // List<Integer> totalList = new ArrayList<>();
    // ListNode resultDummy = new ListNode(0);
    // ListNode tmp = resultDummy;

    // for (int i = newTotal.size(); i > 0; i--) {
    // // totalList.add(newTotal[i - 1]);
    // // for (int i = 0; i < newTotal.length; i++) {
    // tmp.next = new ListNode(Integer.parseInt(newTotal.get(i - 1)));
    // tmp = tmp.next;
    // }

    ListNode resultDummy = new ListNode(0);
    ListNode p = l1, q = l2, curr = resultDummy;
    int carryOver = 0;

    while (p != null || q != null) {
      int x = (p != null) ? p.val : 0;
      int y = (q != null) ? q.val : 0;
      int sum = carryOver + x + y;
      carryOver = sum / 10;
      curr.next = new ListNode(sum % 10);
      curr = curr.next;
      if (p != null)
        p = p.next;
      if (q != null)
        q = q.next;
    }

    if (carryOver > 0) {
      curr.next = new ListNode(carryOver);
    }

    return resultDummy.next;
  }

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}