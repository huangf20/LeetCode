package leetCode;
/*给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

        示例:

        输入: n = 4, k = 2
        输出:
        [
        [2,4],
        [3,4],
        [2,3],
        [1,2],
        [1,3],
        [1,4],
        ]*/


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import java.util.List;

public class LeetCode77 {

    List<List<Integer>> res = new ArrayList<>();
    int mN;
    int mK;
    public List<List<Integer>> combine(int n, int k) {
        if (k<=0||n<k) {
            return res;
        }
        mN=n;
        mK=k;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(1,path);
        return res;

    }

    private void dfs(int begin, Deque<Integer> path){
        if(path.size()==mK){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <=mN; i++) {
            path.add(i);
            dfs(i+1,path);
            path.removeLast();
        }
    }
}
