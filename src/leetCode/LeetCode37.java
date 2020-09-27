package leetCode;
/*编写一个程序，通过已填充的空格来解决数独问题。

        一个数独的解法需遵循如下规则：

        数字 1-9 在每一行只能出现一次。
        数字 1-9 在每一列只能出现一次。
        数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
        空白格用 '.' 表示。*/


public class LeetCode37 {
    int rowPut[][]=new int[9][10];
    int colPut[][]=new int[9][10];
    char mBoard[][];
    int endRow;
    int endCol;


    public void solveSudoku(char[][] board) {
        int firstRow=0;
        int firstCol=0;

        mBoard=board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char temp=board[i][j];
                if (temp!='.'){
                    int anInt = Integer.parseInt(temp + "");
                    rowPut[i][anInt]=1;
                    colPut[j][anInt]=1;
                }
                else {
                    endRow=i;
                    endCol=j;
                }
            }
        }
        while (board[firstRow][firstCol]!='.'){
            firstCol++;
            if(firstCol==9){
                firstCol=0;
                firstRow++;
            }
        }
        dfs(firstRow,firstCol);

    }

    private boolean dfs(int row,int col){
        boolean isTruePath=false;
        for (int i = 1; i <=9; i++) {
            if(isCanPut(row,col,i)){
                put(row,col,i);
                if(row==endRow&&col==endCol){
                    return true;
                }else {
                    int nextRow=row;
                    int nextCol=col;
                    while (mBoard[nextRow][nextCol]!='.'){
                        nextCol++;
                        if(nextCol==9){
                            nextCol=0;
                            nextRow++;
                        }
                    }
                    isTruePath=dfs(nextRow,nextCol);
                }
                if(!isTruePath){
                    back(row, col,i);
                }

            }
        }
        return isTruePath;
    }

    private boolean isCanPut(int row,int col,int num){
        if(rowPut[row][num]==1||colPut[col][num]==1){
            return false;
        }
        int matrixRow=row/3*3;
        int matrixCol=col/3*3;
        for (int i=matrixRow;i<matrixRow+2;i++){
            for (int j = matrixCol; j < matrixCol+3; j++) {
                if(mBoard[i][j]==num+48){
                    return false;
                }
            }
        }
        return true;
    }

    private void back(int row,int col,int num){
        mBoard[row][col]='.';
        rowPut[row][num]=0;
        colPut[col][num]=0;
    }

    private void put(int row,int col,int num){
        mBoard[row][col]=(char)(num+48);
        rowPut[row][num]=1;
        colPut[col][num]=1;
    }
}
