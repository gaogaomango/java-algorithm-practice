import java.util.Date;

class MergeTwoSortedLists {
  public static void main(String[] args) {
    Date start = new Date();

    MergeTwoSortedLists app = new MergeTwoSortedLists();
    app.run();

    Date end = new Date();
    System.out.println(end.getTime() - start.getTime() + " ms");
  }

  private void run() {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(4);
    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);

    ListNode expList = new ListNode(1);
    expList.next = new ListNode(1);
    expList.next.next = new ListNode(2);
    expList.next.next.next = new ListNode(3);
    expList.next.next.next.next = new ListNode(4);
    expList.next.next.next.next.next = new ListNode(4);
    equalsTest(1, l1, l2, expList);
  }

  public ListNode recurciveMergeTwoSortedList(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    if (l1.val < l2.val) {
      l1.next = recurciveMergeTwoSortedList(l1.next, l2);
      return l1;
    } else {
      l2.next = recurciveMergeTwoSortedList(l1, l2.next);
      return l2;
    }
  }

  public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(0);
    ListNode tmpResult = result;

    while (l1 != null || l2 != null) {
      if (l1 == null) {
        tmpResult.next = new ListNode(l2.val);
        l2 = l2.next;
      } else if (l2 == null) {
        tmpResult.next = new ListNode(l1.val);
        l1 = l1.next;
      }
      if (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
          tmpResult.next = new ListNode(l1.val);
          l1 = l1.next;
        } else {
          tmpResult.next = new ListNode(l2.val);
          l2 = l2.next;
        }
      }
      tmpResult = tmpResult.next;
    }

    return result.next;
  }

  private void equalsTest(int id, ListNode l1, ListNode l2, ListNode expectation) {
    // ListNode resultListNode = mergeTwoSortedLists(l1, l2);
    ListNode resultListNode = recurciveMergeTwoSortedList(l1, l2);

    ListNode tmp1 = l1, tmp2 = l2;

    while (tmp1 != null && tmp2 != null) {
      if (tmp1.val != tmp2.val) {
        System.out.println("Error! Test id: " + id);
        System.out.print("result: ");
        // error!
        while (resultListNode != null) {
          System.out.print(resultListNode.val);
          try {
            resultListNode = resultListNode.next;
            if (resultListNode != null) {
              System.out.print("->");
            }
          } catch (NullPointerException e) {
            // TODO: handle exception
            break;
          }
        }

        System.out.println("");
        System.out.print("expectation: ");
        while (expectation != null) {
          System.out.print(expectation.val);
          try {
            expectation = expectation.next;
            if (expectation != null) {
              System.out.print("->");
            }
          } catch (NullPointerException e) {
            // TODO: handle exception
            break;
          }
        }
        System.out.println("");
        break;
      }

      try {
        tmp1 = tmp1.next;
        tmp2 = tmp2.next;
      } catch (NullPointerException e) {
        // TODO: handle exception
        break;
      }
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