package leetCode;

/*硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)*/
public class LeetCodeCion {
    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        int[] coins = new int[]{1, 5, 10, 25};
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                if (i < coin) {
                    break;
                }
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[n]%1000000007;
    }
}
