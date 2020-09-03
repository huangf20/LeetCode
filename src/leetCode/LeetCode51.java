package leetCode;
import java.util.ArrayList;
import java.util.List;
/*n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



        上图为 8 皇后问题的一种解法。

        给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

        每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
        示例：

        输入：4
        输出：[
         [".Q..",  // 解法 1
          "...Q",
          "Q...",
          "..Q."],

         ["..Q.",  // 解法 2
          "Q...",
          "...Q",
          ".Q.."]
        ]
        解释: 4 皇后问题存在两个不同的解法。
*/





public class LeetCode51 {
    public List<List<String>>res=new ArrayList<>();
    int []isColAttack;
    int mNum;
    int []mainDiagonal;
    int []secondaryDiagonal;
    int []queen;
    public List<List<String>> solveNQueens(int n) {
        isColAttack=new int[n];
        this.mNum =n;
        mainDiagonal=new int[2*n-1];
        secondaryDiagonal=new int[2*n-1];
        queen=new int[n];
        findAllByBacktrack(0);
        return res;
    }
    private void findAllByBacktrack(int row){
        if(row>=mNum){
            return;
        }
        for (int col = 0; col < mNum; col++) {
            if(isNotAttacked(row,col)){
                putQueen(row,col);
                if(row==mNum-1){
                    addSolution();
                }else{
                    findAllByBacktrack(row+1);
                }

                removeQueen(row,col);
            }
        }
    }

    private boolean isNotAttacked(int y,int x){
        int res=isColAttack[x]+mainDiagonal[y-x+mNum-1]+secondaryDiagonal[y+x];
        return res==0;
    }
    private void putQueen(int y,int x){
        isColAttack[x]=1;
        queen[y]=x;
        mainDiagonal[y-x+mNum-1]=1;
        secondaryDiagonal[x+y]=1;
    }

    private void removeQueen(int y,int x){
        isColAttack[x]=0;
        queen[y]=0;
        mainDiagonal[y-x+mNum-1]=0;
        secondaryDiagonal[x+y]=0;
    }

    private void addSolution(){
        List<String>one=new ArrayList<>();
        for (int i = 0; i < mNum; i++) {
            int pos=queen[i];
            String s=new String("");
            for (int j = 0; j < mNum; j++) {
                if(j==pos){
                    s+="Q   ";
                }else {
                    s+=".   ";
                }
            }
            one.add(s);

        }
        res.add(one);
    }
}
