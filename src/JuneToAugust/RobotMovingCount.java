package JuneToAugust;

public class RobotMovingCount {
    int [][] mMatrix;
    int mRes=0;
    int mRow,mCol;
    public int movingCount(int threshold, int rows, int cols)
    {
        mMatrix =new int[rows][cols];
        mRow=rows;
        mCol=cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mMatrix[i][j]=0;
            }
        }
        findAllAble(threshold,0,0);

        return mRes;
    }

    void findAllAble(int threshold,int x,int y){
        if(x<0||x>=mCol||y<0||y>=mRow){
            return;
        }
        if(mMatrix[y][x]==-1||parse(x)+parse(y)>threshold){
            return;
        }
        mRes++;
        mMatrix[y][x]=-1;
        findAllAble(threshold,x-1,y);
        findAllAble(threshold,x+1,y);
        findAllAble(threshold,x,y-1);
        findAllAble(threshold,x,y+1);
    }
    int parse(int n){
        int sum=0;
        while(n>0)
        {
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}
