import java.util.Date;

class ReverseKGroup {
  public static void main(String[] args) {
    Date start = new Date();
    ReverseKGroup app = new ReverseKGroup();
    app.run();

    Date end = new Date();
    System.out.println("Time: " + (end.getTime() - start.getTime()));
  }

  private void run() {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(3);
    node.next.next.next = new ListNode(4);
    node.next.next.next.next = new ListNode(5);

    ListNode expNode1 = new ListNode(2);
    expNode1.next = new ListNode(1);
    expNode1.next.next = new ListNode(4);
    expNode1.next.next.next = new ListNode(3);
    expNode1.next.next.next.next = new ListNode(5);
    test(1, node, 2, expNode1);

    ListNode node2 = new ListNode(1);
    node2.next = new ListNode(2);
    node2.next.next = new ListNode(3);
    node2.next.next.next = new ListNode(4);
    node2.next.next.next.next = new ListNode(5);

    ListNode expNode2 = new ListNode(3);
    expNode2.next = new ListNode(2);
    expNode2.next.next = new ListNode(1);
    expNode2.next.next.next = new ListNode(4);
    expNode2.next.next.next.next = new ListNode(5);
    test(2, node2, 3, expNode2);

    ListNode node3 = new ListNode(1);
    node3.next = new ListNode(2);

    ListNode expNode3 = new ListNode(2);
    expNode3.next = new ListNode(1);
    test(3, node3, 2, expNode3);
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode tmpFastHead = head;
    ListNode tmpSlowHead = head;
    int[] tmpValList = new int[k];

    while (tmpFastHead != null) {
      for (int i = k - 1; i >= 0; i--) {
        try {
          tmpValList[i] = tmpFastHead.val;
          tmpFastHead = tmpFastHead.next;
        } catch (NullPointerException e) {
          // TODO: handle exception
          return head;
        }
      }
      for (int i = 0; i < k; i++) {
        tmpSlowHead.val = tmpValList[i];
        tmpSlowHead = tmpSlowHead.next;
      }
    }
    return head;
  }

  private void test(int testId, ListNode head, int k, ListNode expectation) {

    ListNode result = reverseKGroup(head, k);
    ListNode tmpResult = result;
    ListNode tmpExp = expectation;

    while (tmpResult != null || tmpExp != null) {

      if (tmpResult == null || tmpExp == null || tmpResult.val != tmpExp.val) {
        System.out.println("Error!!");
        System.out.print("id: " + testId + ", result: ");
        while (result != null) {
          System.out.print(result.val);
          result = result.next;
          if (result != null) {
            System.out.print("->");
          }
        }
        System.out.println("");
        System.out.print("expeectation: ");
        while (expectation != null) {
          System.out.print(expectation.val);
          expectation = expectation.next;
          if (expectation != null) {
            System.out.print("->");
          }
        }
        System.out.println("");
        break;
      }
      tmpResult = tmpResult.next;
      tmpExp = tmpExp.next;
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