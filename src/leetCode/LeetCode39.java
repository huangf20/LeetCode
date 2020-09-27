package leetCode;
/*给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

        candidates 中的数字可以无限制重复被选取。

        说明：

        所有数字（包括 target）都是正整数。
        解集不能包含重复的组合。 
        示例 1：

        输入：candidates = [2,3,6,7], target = 7,
        所求解集为：
        [
        [7],
        [2,2,3]
        ]
        示例 2：

        输入：candidates = [2,3,5], target = 8,
        所求解集为：
        [
          [2,2,2,2],
          [2,3,3],
          [3,5]
        ]*/


import java.util.*;

public class LeetCode39 {
    List<List<Integer>>res=new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    HashSet<List<Integer>>set=new HashSet<>();
    int mTarget;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length==0){
            return res;
        }
        mTarget=target;
        Arrays.sort(candidates);
        dfs(0,candidates,0);
        return res;
    }
    private void dfs(int addSum,int[] candidates,int start){
        if(addSum==mTarget){
            if(!set.contains(path)){
                res.add(new ArrayList<>(path));
                set.add(path);
            }

            return;
        }
        if(addSum>mTarget){
            return;
        }
        for (int i = start; i <candidates.length ; i++) {
            if(candidates[i]>mTarget-addSum){
                break;
            }
            path.add(candidates[i]);
            dfs(addSum+candidates[i],candidates,i+1);
            path.remove((Integer) candidates[i]);

        }
    }
}
