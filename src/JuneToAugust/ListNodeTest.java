package JuneToAugust;

public class ListNodeTest {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) throws InterruptedException {


        ListNode pHead = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        pHead.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode listNode = deleteDuplication(pHead);
        System.out.println(listNode);
        int i=0;
        while (true) {
            System.out.println(i);
            Thread.currentThread().sleep(5000);

            i+=5;
        }
    }
    
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }


        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode preNode = head;
        ListNode curNode = head.next;
        while (curNode != null) {
            if (curNode.next != null && curNode.val == curNode.next.val) {
                while (curNode.next != null && curNode.val == curNode.next.val) {
                    curNode = curNode.next;
                }
                curNode = curNode.next;
                preNode.next = curNode;

            } else {
                preNode = curNode;
                curNode = curNode.next;
            }
        }

        return head.next;
    }
}
