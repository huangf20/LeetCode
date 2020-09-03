package leetCode;

/*
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

        找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
        示例:
        X X X X
        X O O X
        X X O X
        X O X X
        运行你的函数后，矩阵变为：
        X X X X
        X X X X
        X X X X
        X O X X
        解释:

        被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
*/





public class LeetCode130 {
    int length,width;
    public void solve(char[][] board) {
        width=board.length;
        if(width==0){
            return;
        }
        length=board[0].length;
        for (int i = 0; i < length; i++) {
            dfsFind(board,i,0);
            dfsFind(board,i,width-1);
        }
        for (int j = 0; j < width; j++) {
            dfsFind(board,0,j);
            dfsFind(board,length-1,j);
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }

            }
        }
    }

    void dfsFind(char[][] board,int x,int y){
        if(x<0||x>=length||y<0||y>=width||board[y][x]!='O'){
            return ;
        }
        board[y][x]='#';
        dfsFind(board,x,y+1);
        dfsFind(board,x,y-1);
        dfsFind(board,x-1,y);
        dfsFind(board,x+1,y);
    }
}
