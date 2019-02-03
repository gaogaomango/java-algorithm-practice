import java.util.Date;

class MergeMultipleSortedList {
  public static void main(String[] args) {
    Date start = new Date();

    MergeMultipleSortedList app = new MergeMultipleSortedList();
    app.run();

    Date end = new Date();
    System.out.println(end.getTime() - start.getTime() + " ms");
  }

  private void run() {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(5);
    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);
    ListNode l3 = new ListNode(2);
    l3.next = new ListNode(6);

    ListNode expList = new ListNode(1);
    expList.next = new ListNode(1);
    expList.next.next = new ListNode(2);
    expList.next.next.next = new ListNode(3);
    expList.next.next.next.next = new ListNode(4);
    expList.next.next.next.next.next = new ListNode(4);
    expList.next.next.next.next.next.next = new ListNode(5);
    expList.next.next.next.next.next.next.next = new ListNode(6);

    ListNode[] lists = { l1, l2, l3 };
    equalsTest(1, lists, expList);

    ListNode l4 = new ListNode(2);
    ListNode l5 = null;
    ListNode l6 = new ListNode(-1);

    ListNode expList2 = new ListNode(-1);
    expList2.next = new ListNode(2);
    ListNode[] lists2 = { l4, l5, l6 };
    equalsTest(1, lists2, expList2);

  }

  public ListNode mergeKLists(ListNode[] lists) {
    // ListNode tmpList = new ListNode(Integer.MIN_VALUE);
    ListNode tmpList = null;
    for (ListNode l : lists) {
      tmpList = mergeList(tmpList, l);
    }
    return tmpList;
  }

  public ListNode mergeList(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    if (l1.val < l2.val) {
      l1.next = mergeList(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeList(l1, l2.next);
      return l2;
    }
  }

  private void equalsTest(int id, ListNode[] lists, ListNode expectation) {
    ListNode resultListNode = mergeKLists(lists);
    ListNode tmp = resultListNode;
    ListNode tmpExpectation = expectation;

    while (tmp != null || tmpExpectation != null) {
      if (tmp == null || tmpExpectation == null || tmp.val != tmpExpectation.val) {
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
        tmp = tmp.next;
        tmpExpectation = tmpExpectation.next;
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