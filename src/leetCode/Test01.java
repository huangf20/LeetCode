package leetCode;

public class Test01 {
    public static void main(String args[]){
        ListNode listNode1=new ListNode(2);
        ListNode listNode2=new ListNode(4);
        listNode1.next=listNode2;
        ListNode listNode3=new ListNode(3);
        listNode2.next=listNode3;

        ListNode listNode4=new ListNode(5);
        ListNode listNode5=new ListNode(6);
        listNode4.next=listNode5;
        ListNode listNode6=new ListNode(4);
        listNode5.next=listNode6;

        ListNode listNodeone=new ListNode(0);
        ListNode listNodetwo=new ListNode(0);
        LeetCode2 leetCode2=new LeetCode2();
        ListNode x = leetCode2.addTwoNumbers(listNodeone, listNodetwo);
        System.out.println(x);
    }
}
