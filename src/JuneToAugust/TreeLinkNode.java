package JuneToAugust;

public class TreeLinkNode {
    public static class TreeLinkNodeB {
        int val;
        TreeLinkNodeB left = null;
        TreeLinkNodeB right = null;
        TreeLinkNodeB next = null;

        TreeLinkNodeB(int val) {
            this.val = val;
        }
    }
    public static void main(String args[]){
        TreeLinkNodeB tree1=new TreeLinkNodeB(1);
        TreeLinkNodeB tree2=new TreeLinkNodeB(2);
        TreeLinkNodeB tree3=new TreeLinkNodeB(3);
        TreeLinkNodeB tree4=new TreeLinkNodeB(4);
        TreeLinkNodeB tree5=new TreeLinkNodeB(5);
        TreeLinkNodeB tree6=new TreeLinkNodeB(6);
        TreeLinkNodeB tree7=new TreeLinkNodeB(7);
        tree6.left=tree2;
        tree6.right=tree7;
        tree2.next=tree6;
        tree7.next=tree6;
        tree2.left=tree1;
        tree1.next=tree2;
        tree2.right=tree5;
        tree5.next=tree2;
        tree5.left=tree3;
        tree3.next=tree5;
        tree3.right=tree4;
        tree4.next=tree3;

        TreeLinkNodeB next=GetNext(tree5);
        System.out.println(next);

    }
    public static TreeLinkNodeB GetNext(TreeLinkNodeB pNode)
    {
        if(pNode==null){
            return pNode;
        }
        if(pNode.right!=null){
            pNode=pNode.right;
            while(pNode.left!=null){
                pNode=pNode.left;
            }
            return pNode;
        }
        while(pNode.next!=null){
            TreeLinkNodeB root=pNode.next;
            if(root.left==pNode){
                return root;
            }
            pNode=pNode.next;
        }
        return pNode;
    }
}
