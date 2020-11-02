package leetCode;
/*
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
        将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

        示例 1:

        给定链表 1->2->3->4, 重新排列为 1->4->2->3.
        示例 2:

        给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

*/

import java.util.ArrayList;

public class LeetCode143 {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null){
            return;
        }
        ArrayList<ListNode> list=new ArrayList<>();
        while (head!=null){
            list.add(head);
            head=head.next;
        }
        int length=list.size();
        for (int i = 0; i <=(length-1)/ 2; i++) {
            if(i==(length-1)/ 2){
                ListNode node=list.get(i);
                if(length%2==0){
                    node.next.next=null;
                    break;
                }
                node.next=null;
                break;
            }
            ListNode pre=list.get(i);
            ListNode next=pre.next;
            ListNode node=list.get(length-1-i);
            insert(pre,node,next);
        }

    }

    public void insert(ListNode pre,ListNode node,ListNode next){
        pre.next=node;
        node.next=next;
    }

    public static void main(String[] args) {
        LeetCode143 leetCode143=new LeetCode143();
        ListNode head=new ListNode(1);
        ListNode node1=new ListNode(2);
        head.next=node1;
        ListNode node2=new ListNode(3);
        node1.next=node2;
        ListNode node3=new ListNode(4);
        node2.next=node3;
        /*ListNode node4=new ListNode(5);
        node3.next=node4;*/
        leetCode143.reorderList(head);
        System.out.println(head);
        String s="sb asd sb";
        CharSequence charSequence = s.subSequence(0, 2);
        System.out.println(charSequence);
        s = s.replaceAll("sb", "beauty");
        System.out.println(s);
    }

    public String replaceAll(String regex,String replacement){

        return null;
    }
}
