package leetCode;
/*给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

        为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

        说明：不允许修改给定的链表。*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LeetCode142 {
    HashMap <Integer,Integer>mHashMap=new HashMap<>();
    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LeetCode142 leetCode142=new LeetCode142();
        ListNode listNode1=new ListNode(3);
        ListNode listNode2=new ListNode(2);
        listNode1.next=listNode2;
        ListNode listNode3=new ListNode(0);
        listNode2.next=listNode3;
        ListNode listNode4=new ListNode(4);
        listNode3.next=listNode4;
        listNode4.next=listNode2;
        ListNode listNode = leetCode142.detectCycle(listNode1);
        System.out.println(listNode.val);
    }
}
