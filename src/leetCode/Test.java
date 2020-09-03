package leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String args[]){
        LeetCode51 leetCode51=new LeetCode51();
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
        System.out.println(lists.size());

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

    }


}
