package leetCode;
/*给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

        例如，从根到叶子节点路径 1->2->3 代表数字 123。

        计算从根到叶子节点生成的所有数字之和。

        说明: 叶子节点是指没有子节点的节点。

        示例 1:

        输入: [1,2,3]
        1
        / \
        2   3
        输出: 25
        解释:
        从根到叶子节点路径 1->2 代表数字 12.
        从根到叶子节点路径 1->3 代表数字 13.
        因此，数字总和 = 12 + 13 = 25.
        示例 2:

        输入: [4,9,0,5,1]
        4
        / \
        9   0
         / \
        5   1
        输出: 1026
        解释:
        从根到叶子节点路径 4->9->5 代表数字 495.
        从根到叶子节点路径 4->9->1 代表数字 491.
        从根到叶子节点路径 4->0 代表数字 40.
        因此，数字总和 = 495 + 491 + 40 = 1026.*/


public class LeetCode129 {
    int res =0;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return  res;
    }

    private void dfs(TreeNode root,int sum){
        boolean hasLeft=root.left!=null;
        boolean hasRight=root.right!=null;
        sum=sum*10+root.val;
        if(!hasLeft&&!hasRight){
            res+=sum;
            return;
        }
        if(hasLeft){
            dfs(root.left,sum);
        }
        if(hasRight){
            dfs(root.right,sum);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(0);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(1);
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
//        TreeNode treeNode5 = new TreeNode(7);
//        TreeNode treeNode6 = new TreeNode(9);
//        treeNode2.left = treeNode5;
//        treeNode2.right = treeNode6;
//        TreeNode treeNode7 = new TreeNode(3);
//        TreeNode treeNode8 = new TreeNode(5);
//        treeNode4.left = treeNode7;
//        treeNode4.right = treeNode8;
        LeetCode129 leetCode129=new LeetCode129();
        System.out.println(leetCode129.sumNumbers(treeNode));
    }
}
