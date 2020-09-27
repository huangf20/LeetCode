package leetCode;
/*给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

        百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

        例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]

        [LeetCode235]

         

        示例 1:

        输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        输出: 6
        解释: 节点 2 和节点 8 的最近公共祖先是 6。
        示例 2:

        输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
        输出: 2
        解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。*/

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class LeetCode235 {
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res=root;
        while(true){
            if(p.val<res.val&&q.val<res.val){
                res=res.left;
            }
            else if(p.val>res.val&&q.val>res.val){
                res=res.right;
            }
            else {
                break;
            }

        }

        return res;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res=root;
        List<TreeNode> path1 = getPath(root, p);
        List<TreeNode> path2 = getPath(root, q);
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) == path2.get(i)) {
                res = path1.get(i);
            } else {
                break;
            }
        }

        return res;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode treeNode = root;
        list.add(treeNode);
        while (treeNode != target) {
            if (treeNode.val > target.val) {
                treeNode = treeNode.left;
                list.add(treeNode);
            }
            if (treeNode.val < target.val) {
                treeNode = treeNode.right;
                list.add(treeNode);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(6);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(8);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        TreeNode treeNode3 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(9);
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        TreeNode treeNode7 = new TreeNode(3);
        TreeNode treeNode8 = new TreeNode(5);
        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;

        LeetCode235 leetCode235=new LeetCode235();
        TreeNode treeNode9 = leetCode235.lowestCommonAncestor1(treeNode, treeNode3, treeNode8);
        System.out.println(treeNode9.val);
    }


}


