package leetCode;
/*给定一个链表，判断链表中是否有环。

        如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

        如果链表中存在环，则返回 true 。 否则，返回 false 。*/

import java.util.HashSet;
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set=new HashSet<>();
        while (head!=null){
            if(!set.contains(head)){
                set.add(head);
            }
            else{
                return true;
            }
            head=head.next;
        }

        return false;

    }
    public boolean hasCycleBetter(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow.equals(fast)) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }


    public static void main(String[] args) {
        ListNode listNode1=new ListNode(3);
        ListNode listNode2=new ListNode(2);
        listNode1.next=listNode2;
        ListNode listNode3=new ListNode(0);
        listNode2.next=listNode3;
        ListNode listNode4=new ListNode(4);
        listNode3.next=listNode4;
        /*listNode4.next=listNode2;*/
        LeetCode141 leetCode141=new LeetCode141();
        System.out.println(leetCode141.hasCycle(listNode1));
    }
}


