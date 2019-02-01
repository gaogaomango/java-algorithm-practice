import java.util.Date;

class RemoveNthFromEnd {
  public static void main(String[] args) {
    Date start = new Date();

    RemoveNthFromEnd app = new RemoveNthFromEnd();
    app.run();

    Date end = new Date();
    System.out.println(end.getTime() - start.getTime() + " ms");
  }

  private void run() {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(3);
    node.next.next.next = new ListNode(4);
    node.next.next.next.next = new ListNode(5);

    int target = 2;
    ListNode expNode = new ListNode(1);
    expNode.next = new ListNode(2);
    expNode.next.next = new ListNode(3);
    expNode.next.next.next = new ListNode(5);
    equalsTest(1, node, target, expNode);
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
      return null;
    }
    if (n < 0) {
      return null;
    }

    ListNode start = new ListNode(0);
    ListNode slow = start;
    ListNode fast = start;
    start.next = head;
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }
    System.out.println("break");
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return start.next;
  }

  private void equalsTest(int id, ListNode head, int n, ListNode expectationList) {
    ListNode result = removeNthFromEnd(head, n);
    ListNode tmpResult = result;
    ListNode tmpExpectationList = expectationList;

    while (tmpResult != null) {
      System.out.println("tmpResult.val:" + tmpResult.val + ", tmpExpectationList.val" + tmpExpectationList.val);
      if (tmpResult.val != tmpExpectationList.val) {
        System.out.print("error! ");
        StringBuilder headSb = new StringBuilder();
        while (head != null) {
          if (headSb.length() != 0) {
            headSb.append(",");
          }
          headSb.append("head.val: " + head.val);
          head = head.next;
        }
        StringBuilder expectationSb = new StringBuilder();
        while (expectationList != null) {
          if (expectationSb.length() != 0) {
            expectationSb.append(",");
          }
          expectationSb.append("expectationList.val: " + expectationList.val);
          expectationList = expectationList.next;
        }

        System.out.println("head: " + headSb.toString());
        System.out.println("tmpExpectationList: " + expectationSb.toString());
        return;
      }
      try {
        tmpResult = tmpResult.next;
        tmpExpectationList = tmpExpectationList.next;
      } catch (NullPointerException e) {
        System.out.println("error! wrong size list at test id = " + id);
        return;
      }
    }
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
