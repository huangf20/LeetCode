package leetCode;
/*给定一个二叉树

        struct Node {
        int val;
        Node *left;
        Node *right;
        Node *next;
        }
        填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

        初始状态下，所有 next 指针都被设置为 NULL。
        进阶：

        你只能使用常量级额外空间。
        使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。*/

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class LeetCode117Other{
    Node last = null, nextStart = null;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    public void handle(Node p) {
        if (last != null) {
            last.next = p;
        }
        if (nextStart == null) {
            nextStart = p;
        }
        last = p;
    }


}
public class LeetCode117 {
    public Node connect(Node root) {
        Queue<Node> queue=new LinkedList<Node>();
        queue.offer(root);
        Node last = null;
        while (!queue.isEmpty()){
            int n=queue.size();
            for (int i = 1; i <= n; i++) {
                Node node=queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                if (i!=1){
                    last.next=node;
                }
                last=node;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        LeetCode117Other leetCode117=new LeetCode117Other();
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        node1.left=node2;
        node1.right=node3;
        Node node4=new Node(4);
        Node node5=new Node(5);
        node2.left=node4;
        node2.right=node5;
        Node node7=new Node(7);
        node3.right=node7;

        Node connect = leetCode117.connect(node1);
        System.out.println(connect);

    }
}
