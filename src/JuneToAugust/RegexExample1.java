package JuneToAugust;

import leetCode.LeetCode130;
import leetCode.LeetCode3;

public class RegexExample1 {
    public static void main(String args[]) {
        RobotMovingCount robotMovingCount = new RobotMovingCount();
        int count = robotMovingCount.movingCount(5, 5, 5);
        System.out.println(count);
        char[][] chars = {{'X', 'O', 'X', 'X'}, {'O', 'X', 'O', 'X'}, {'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X'}};
        LeetCode130 leetCode130 = new LeetCode130();
        leetCode130.solve(chars);

        LeetCode3 leetCode3 =new LeetCode3();
        System.out.println(leetCode3.lengthOfLongestSubstring("abdcabcaa"));
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }

    }
}
