package leetCode;
/*根据一棵树的中序遍历与后序遍历构造二叉树。

        注意:
        你可以假设树中没有重复的元素。

        例如，给出

        中序遍历 inorder = [9,3,15,20,7]
        后序遍历 postorder = [9,15,7,20,3]
        返回如下的二叉树：
           3
          / \
         9  20
           /  \
          15   7*/


import java.util.Arrays;

public class LeetCode106 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {



        return buildTree1(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }

    private TreeNode buildTree1(int[] inorder, int[] postorder,int inorderStart,int inorderEnd,int postorderStart,int postorderEnd){
        int length=inorderEnd-inorderStart+1;
        int val=postorder[postorderEnd];
        TreeNode root=new TreeNode(val);
        if(length>1){
            int i=inorderStart;
            while(i<inorderEnd&&inorder[i]!=val){
                i++;
            }
            if(i>inorderStart){
                root.left=buildTree1(inorder,postorder,inorderStart,i-1,postorderStart,postorderStart+i-inorderStart-1);
            }
            if(i<inorderEnd){
                root.right=buildTree1(inorder,postorder,i+1,inorderEnd,postorderStart+i-inorderStart,postorderEnd-1);
            }

        }

        return root;
    }
}
