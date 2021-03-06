package leetCode;
/*给定一个无序的整数数组，找到其中最长上升子序列的长度。

        示例:

        输入: [10,9,2,5,3,7,101,18]
        输出: 4
        解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
        说明:

        可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
        你算法的时间复杂度应该为 O(n2) 。*/


import java.util.Arrays;

public class LeetCode300 {
        
    public int lengthOfLIS(int[] nums) {
        int []maxLen=new int[nums.length];
        int max=0;
        Arrays.fill(maxLen,1);
        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    maxLen[i]=Math.max(maxLen[i],maxLen[j]+1);
                    max=Math.max(maxLen[i],max);
                }
            }
        }
        return max;
    }
}
