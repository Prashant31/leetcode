public class MergeSortedLinkedList {

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode pointer1 = l1;
    ListNode pointer2 = l2;
    ListNode zeroNode = new ListNode(0, null);
    ListNode tail = zeroNode;
    while (true) {
      if (pointer1 == null) {
        tail.next = pointer2;
        break;
      }

      if (pointer2 == null) {
        tail.next = pointer1;
        break;
      }

      if (pointer1.val <= pointer2.val) {
        tail.next = pointer1;
        pointer1 = pointer1.next;
      } else {
        tail.next = pointer2;
        pointer2 = pointer2.next;
      }
      tail = tail.next;
    }
    return zeroNode.next;
  }

  public static void main(String[] args) {
    ListNode n11 = new ListNode(1, null);
    ListNode n12 = new ListNode(2, null);
    ListNode n13 = new ListNode(4, null);
    n11.next = n12;
    n12.next = n13;

    ListNode n21 = new ListNode(1, null);
    ListNode n22 = new ListNode(3, null);
    ListNode n23 = new ListNode(4, null);
    n21.next = n22;
    n22.next = n23;

    ListNode current = mergeTwoLists(n11, n21);
    while (current != null) {
      System.out.println(current.val);
      current = current.next;
    }
  }


  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
