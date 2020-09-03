package JuneToAugust;

import java.util.ArrayList;

public class Binaryree {
    ArrayList<TreeNode> mTreeNodes=new ArrayList<>();
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String args[]){

        TreeNode treeNodeRoot=new TreeNode(5);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        TreeNode treeNode4=new TreeNode(4);
        TreeNode treeNode6=new TreeNode(6);
        TreeNode treeNode7=new TreeNode(7);
        TreeNode treeNode8=new TreeNode(8);
        treeNodeRoot.left=treeNode3;
        treeNodeRoot.right=treeNode7;
        treeNode3.left=treeNode2;
        treeNode3.right=treeNode4;
        treeNode7.left=treeNode6;
        treeNode7.right=treeNode8;
        Binaryree binaryree=new Binaryree();
        TreeNode treeNode=binaryree.KthNode(treeNodeRoot,5);
        System.out.println(treeNode.val);

    }

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        inorderTraversal(pRoot);
        return mTreeNodes.get(k-1);
    }

    void inorderTraversal(TreeNode pRoot){
        if(pRoot.left!=null){
            inorderTraversal(pRoot.left);
        }
        mTreeNodes.add(pRoot);
        if(pRoot.right!=null){
            inorderTraversal(pRoot.right);
        }
    }
}
