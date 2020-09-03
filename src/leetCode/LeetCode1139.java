package leetCode;

/*给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。*/
public class LeetCode1139 {

    public int largest1BorderedSquare(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int height = grid.length;
        int width = grid[0].length;
        int res = 0;

        int[][][] dp = new int[height + 1][width + 1][2];
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (grid[i - 1][j - 1] == 1) {
                    dp[i][j][0] = 1 + dp[i][j - 1][0];
                    dp[i][j][1] = 1 + dp[i - 1][j][1];

                }
            }
        }

        for (int i = 1; i <=height; i++) {
            for (int j = 1; j <=width; j++) {
                int lenLeft = dp[i][j][0];
                int lenTop = dp[i][j][1];
                if(lenLeft >0&& lenTop >0){
                    for (int len = Math.min(lenLeft,lenTop); len>0; len--) {
                        if(dp[i][j+1-len][1]>=len&&dp[i+1-len][j][0]>=len){
                            res=Math.max(res,len);
                            break;
                        }
                    }

                }
            }
        }

        return res;
    }
}
