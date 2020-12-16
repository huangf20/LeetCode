package leetCode;
/*
给定一种规律 pattern和一个字符串str，判断 str 是否遵循相同的规律。

        这里的遵循指完全匹配，例如，pattern里的每个字母和字符串str中的每个非空单词之间存在着双向连接的对应规律。

        示例1:

        输入: pattern = "abba", str = "dog cat cat dog"
        输出: true
        示例 2:

        输入:pattern = "abba", str = "dog cat cat fish"
        输出: false
        示例 3:

        输入: pattern = "aaaa", str = "dog cat cat dog"
        输出: false
        示例4:

        输入: pattern = "abba", str = "dog dog dog dog"
        输出: false
        说明:
        你可以假设pattern只包含小写字母，str包含了由单个空格分隔的小写字母。 

*/

import java.util.HashMap;
import java.util.Map;

public class LeetCode290 {
    public boolean wordPattern(String pattern, String str) {
        Map<String, Character> str2ch = new HashMap<String, Character>();
        Map<Character, String> ch2str = new HashMap<Character, String>();
        int m = str.length();
        int i = 0;
        for (int p = 0; p < pattern.length(); ++p) {
            char ch = pattern.charAt(p);
            if (i >= m) {
                return false;
            }
            int j = i;
            while (j < m && str.charAt(j) != ' ') {
                j++;
            }
            String tmp = str.substring(i, j);
            if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                return false;
            }
            if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(tmp, ch);
            ch2str.put(ch, tmp);
            i = j + 1;
        }
        return i >= m;
    }

}
