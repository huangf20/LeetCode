package JuneToAugust;

public class HasPathInMatrix {
    char[][] mMatrix;
    char[] mStr;
    int mRow;
    int mCol;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        mMatrix=new char[rows][cols];
        mStr=str;
        mRow=rows;
        mCol=cols;
        boolean res=false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mMatrix[i][j]=matrix[i*cols+j];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(mMatrix[i][j]==str[0]){
                    char[][]temp=newChar(mMatrix);
                    res=res||moveToEnd(temp,0,j,i);
                }

            }
        }



        return res;
    }

    boolean moveToEnd(char[][] matrix,int n,int x,int y){
        if(x<0||x>=mCol||y<0||y>=mRow){
            return false;
        }
        if(matrix[y][x]=='#'||matrix[y][x]!=mStr[n]){
            return false;
        }
        if(matrix[y][x]==mStr[n]&&n==mStr.length-1){
            return true;
        }
        matrix[y][x]='#';
        return moveToEnd(matrix,n+1,x,y-1)||moveToEnd(matrix,n+1,x,y+1)||moveToEnd(matrix,n+1,x+1,y)||moveToEnd(matrix,n+1,x-1,y);

    }
    char[][] newChar(char[][]chars){
        char[][]a=new char[chars.length][chars[0].length];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                a[i][j]=chars[i][j];
            }
        }
        return a;
    }
}
