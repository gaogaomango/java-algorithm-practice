import java.util.Date;

class SwapPairs {
  public static void main(String[] args) {
    Date start = new Date();
    SwapPairs app = new SwapPairs();
    app.run();

    Date end = new Date();
    System.out.println("Time: " + (end.getTime() - start.getTime()));
  }

  private void run() {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(3);
    node.next.next.next = new ListNode(4);

    ListNode expNode = new ListNode(2);
    expNode.next = new ListNode(1);
    expNode.next.next = new ListNode(4);
    expNode.next.next.next = new ListNode(3);
    test(node, expNode);
  }

  private ListNode swapPairs(ListNode head) {
    ListNode tmpHead = head;
    int tmp = 0;

    while (tmpHead != null && tmpHead.next != null) {
      tmp = tmpHead.val;
      tmpHead.val = tmpHead.next.val;
      tmpHead.next.val = tmp;
      tmpHead = tmpHead.next.next;
    }

    return head;
  }

  private void test(ListNode head, ListNode expectation) {

    ListNode result = swapPairs(head);
    ListNode tmpResult = result;
    ListNode tmpExp = expectation;

    while (tmpResult != null || tmpExp != null) {

      if (tmpResult == null || tmpExp == null) {
        System.out.println("Error!!");
        System.out.print("result: ");
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

        break;
      }

      tmpResult = tmpResult.next;
      tmpExp = tmpExp.next;
    }

  }

  // Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

}