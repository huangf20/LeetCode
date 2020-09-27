package leetCode;
/*给定一个二叉树，返回所有从根节点到叶子节点的路径。

        说明: 叶子节点是指没有子节点的节点。

        示例:

        输入:

        1
        /   \
        2     3
        \
        5

        输出: ["1->2->5", "1->3"]

        解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3*/


import java.util.LinkedList;
import java.util.List;

public class LeetCode257 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<String> res =new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        String temp="";
        findAllPaths(temp,root);
        return res;
    }
    public void findAllPaths(String s,TreeNode root){

        s+="->"+root.val;
        if(root.left==null&&root.right==null){

            res.add(s.substring(2,s.length()));
        }
        if(root.left!=null){
            findAllPaths(s,root.left);
        }
        if(root.right!=null){
            findAllPaths(s,root.right);
        }

    }
}
