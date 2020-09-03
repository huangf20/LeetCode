package leetCode;

import java.util.HashMap;
import java.util.Map;

/*给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

        示例 1:

        输入: "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        示例 2:

        输入: "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        示例 3:

        输入: "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
            请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。*/



public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer>map=new HashMap<>();
        int left=0,res=0;
        for (int right=0;right<s.length();right++){
            if (map.containsKey(s.charAt(right))){
                left=Math.max(map.get(s.charAt(right)),left);
            }
            res=Math.max(res,right-left+1);
            map.put(s.charAt(right),right+1);
        }

        return  res;
    }

    public int lengthOfLongestSubstringBy(String s) {
        int n = s.length();
        int result = 0;
        int[] charIndex = new int[258];
        for (int left = 0, right = 0; right < n; right++) {
            char c = s.charAt(right);
            left = Math.max(charIndex[c], left);
            result = Math.max(result, right - left + 1);
            charIndex[c] = right + 1;
        }

        return result;
    }


}
