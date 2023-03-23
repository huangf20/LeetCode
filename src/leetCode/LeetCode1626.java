package leetCode;

import java.util.Arrays;

/**
 * 假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
 *
 * 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。
 *
 * 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队中得分最高那支的分数 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：scores = [1,3,5,10,15], ages = [1,2,3,4,5]
 * 输出：34
 * 解释：你可以选中所有球员。
 * 示例 2：
 *
 * 输入：scores = [4,5,6,5], ages = [2,1,2,1]
 * 输出：16
 * 解释：最佳的选择是后 3 名球员。注意，你可以选中多个同龄球员。
 * 示例 3：
 *
 * 输入：scores = [1,2,3,5], ages = [8,9,10,1]
 * 输出：6
 * 解释：最佳的选择是前 3 名球员。
 *  
 *
 * 提示：
 *
 * 1 <= scores.length, ages.length <= 1000
 * scores.length == ages.length
 * 1 <= scores[i] <= 106
 * 1 <= ages[i] <= 1000
 */
public class LeetCode1626 {

    public static int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int [][] people = new int[n][2];
        for (int i = 0; i < n; i++) {
            people[i] = new int[]{scores[i], ages[i]};
        }

        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int res = 0;
        int [] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(people[i][1] >= people[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }

            }
            dp[i] += people[i][0];

            res = Math.max(res, dp[i]);

        }


        return res;
    }


    /**
     * 最大年龄
     */
    private int maxAge;

    /**
     * 球员二维数组{score, age}
     */
    private int [][] people;

    /**
     * 线段数组，保存最大年龄为index时，所组成球队的最高分数
     */
    private int [] t;

    public int bestTeamScore1(int[] scores, int[] ages){
        maxAge = Arrays.stream(ages).max().getAsInt();
        int n = scores.length;
        t = new int[maxAge + 1];
        people = new int[n][2];

        for (int i = 0; i < n; i++) {
            people[i] = new int[]{scores[i], ages[i]};
        }
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int res = 0;
        for (int i = 0; i < n; i++) {
            int age = people[i][1];
            int score = people[i][0];
            int cur = score + query(age);

            update(age , cur);
            res = Math.max(res, cur);
        }
        return 0;
    }

    /**
     * 在二进制下的最低为1及其后面的0构成的数
     * @param num
     * @return
     */
    private int lowBit(int num){
        return num & -num;
    }

    /**
     * 线段树更新
     * @param i
     * @param val
     */
    private void update(int i, int val){
        for (; i <= maxAge ; i += lowBit(i)) {
            t[i] = Math.max(t[i] , val);
        }
    }

    /**
     * 线段树查询
     * @param i
     * @return
     */
    private int  query(int i){
        int res = 0;
        for(; i > 0 ; i -= lowBit(i)){
            res = Math.max(res, t[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        LeetCode1626 leetCode1626 = new LeetCode1626();
        System.out.println(leetCode1626.bestTeamScore1(new int[]{4,5,6,5}, new int[]{2,1,2,1}));
    }
}
