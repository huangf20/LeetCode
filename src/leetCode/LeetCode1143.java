package leetCode;
/*给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。

        一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
        例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。

        若这两个字符串没有公共子序列，则返回 0。*/


public class LeetCode1143 {
    int [][] mData;
    public int longestCommonSubsequence(String text1, String text2) {
        int row=text1.length();
        int col=text2.length();
        mData =new int[row+1][col+1];
        int res=0;
        /*for(int i=0;i<=row;i++){
            int[i][0]=0;
        }
        for(int i=0;i<=col;i++){
            int[0][i]=0;
        }*/

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                char a1=text1.charAt(i);
                char a2=text2.charAt(j);
                if(a1==a2){
                    mData[i+1][j+1]= mData[i][j]+1;
                    res=Math.max(res, mData[i+1][j+1]);
                }
                else{
                    mData[i+1][j+1]= Math.max(mData[i+1][j],mData[i][j+1]);

                }
            }
        }
        return mData[row][col];
    }
}
