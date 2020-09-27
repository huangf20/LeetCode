package leetCode;

import java.util.*;

public class Test {
    public static void main(String args[]){
        /*LeetCode51 leetCode51=new LeetCode51();
        int n=4;
        List<List<String>> lists = leetCode51.solveNQueens(n);
        for(List<String> list :lists){
            for(String s: list){
                System.out.println(s);
            }
            for (int i = 0; i <n+(n-1)*3 ; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println(lists.size());*/

        /*LeetCode1143 leetCode1143=new LeetCode1143();
        System.out.println(leetCode1143.longestCommonSubsequence("abcde","ace"));*/

        /*LeetCode1139 leetCode1139=new LeetCode1139();
        int [][]test={{1,1,1},{1,0,0},{1,1,1},{1,1,1}};
        System.out.println(leetCode1139.largest1BorderedSquare(test));*/

        /*LeetCodeCion leetCodeCion=new LeetCodeCion();
        System.out.println(leetCodeCion.waysToChange(6));*/

        /*LeetCode1402 leetCode1402=new LeetCode1402();
        int []test=new int[]{-2,5,-1,0,3,-3};
        System.out.println(leetCode1402.maxSatisfaction(test));*/

        /*LeetCode956 leetCode956=new LeetCode956();
        int[]test=new int[]{1,2,3};
        System.out.println(leetCode956.tallestBillboard(test));*/
        /*LeetCode1320 leetCode1320=new LeetCode1320();
        System.out.println(leetCode1320.minimumDistance("CA"));*/

        /*LeetCode300 leetCode300=new LeetCode300();
        int []test=new int[]{10,9,2,5,3,7,101,18};
        System.out.println(leetCode300.lengthOfLIS(test));*/

        /*LeetCode841 leetCode841=new LeetCode841();

        List<List<Integer>>lists=new LinkedList<>();
        List<Integer>list1=new LinkedList<>();
        list1.add(1);
        list1.add(3);
        lists.add(list1);

        List<Integer>list2=new LinkedList<>();
        list2.add(3);
        list2.add(0);
        list2.add(1);
        lists.add(list2);

        List<Integer>list3=new LinkedList<>();
        list3.add(2);
        lists.add(list3);

        List<Integer>list4=new LinkedList<>();
        list4.add(0);
        lists.add(list4);

        System.out.println(leetCode841.canVisitAllRooms(lists));*/

        /*LeetCode486 leetCode486=new LeetCode486();
        int []test=new int[]{1,5,2};
        System.out.println(leetCode486.PredictTheWinner(test));*/

        /*LeetCode978 leetCode978 = new LeetCode978();
        int []test=new int []{0,1,1,0,1,0,1,1,0,0};
        System.out.println(leetCode978.maxTurbulenceSize(test,1));*/

        /*LeetCode257.TreeNode treeNode1=new LeetCode257.TreeNode(1);
        LeetCode257.TreeNode treeNode2=new LeetCode257.TreeNode(2);
        LeetCode257.TreeNode treeNode3=new LeetCode257.TreeNode(3);
        LeetCode257.TreeNode treeNode4=new LeetCode257.TreeNode(5);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.right=treeNode4;
        LeetCode257 leetCode257=new LeetCode257();
        System.out.println(leetCode257.binaryTreePaths(treeNode1));
        String s="->123456";
        System.out.println(s.substring(2,s.length()));*/

        /*LeetCode347 leetCode347=new LeetCode347();
        int[] frequent = leetCode347.topKFrequent(new int[]{1, 1, 1, 2, 2, 3,3,3,3,4,4,4,4,4}, 3);*/

        /*LeetCode77 leetCode77 = new LeetCode77();
        List<List<Integer>> combine = leetCode77.combine(4, 2);
        System.out.println(combine);*/

        /*LeetCode39 leetCode39=new LeetCode39();
        List<List<Integer>> lists = leetCode39.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(lists);*/


        /*LeetCode37 leetCode37=new LeetCode37();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        leetCode37.solveSudoku(board);
        int[][] colPut = leetCode37.colPut;
        int[][] rowPut = leetCode37.rowPut;
        System.out.println(colPut);
        System.out.println(rowPut);
        for (char[] a:leetCode37.mBoard) {
            for (char c :a) {
                System.out.print(c+"  ");
            }
            System.out.println();
        }*/

        LeetCode42 leetCode42=new LeetCode42();
        System.out.println(leetCode42.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

        int []test=new int[]{1,2,3,4,5};
        int[] copy = Arrays.copyOfRange(test, 0, 3);
        System.out.println(test);
        System.out.println(copy);


        LeetCode106 leetCode106=new LeetCode106();
        LeetCode106.TreeNode treeNode = leetCode106.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(treeNode);
    }


}
