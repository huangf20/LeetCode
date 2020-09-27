package practice;

import java.util.Arrays;

public class Test {
    public static void main(String []args){
        int[] stocks = stocks(new int[]{ 11, 15, 16, 12, 8, 16, 18, 17, 11, 10});
        for (int i :stocks){
            System.out.println(i);
        }
        System.out.println(stocks);
        System.out.println(maxArea(new int[]{3,4,5,6}));
    }

    static int[] stocks(int[] stocks) {
        int length=stocks.length;
        int [] res=new int[length];
        for (int i = 0; i < length; i++) {
            if(i==length-1){
                res[i]=0;
            }
            else {
                int end=i+1;
                while (stocks[end]<=stocks[i]){
                    end++;
                    if(end>=length-1){
                        if(end==length-1&&stocks[end]>=stocks[i]){
                            res[i]=end-i;
                        }
                        break;
                    }
                }
                if (end!=length&&stocks[end]>stocks[i]){
                    res[i]=end-i;
                }
            }
        }
        return res;
    }
    static int[] mArray;
    static int[]mPath;
    static int mDiff=Integer.MAX_VALUE;
    static int maxArea(int[] array) {
        mArray=array;
        mPath=new int[array.length];
        int [] path=new int[array.length];
        dfs(path,0,1);
        dfs(path,0,-1);
        int lengthOne=0;
        int lengthTwo=0;
        for (int i = 0; i < array.length; i++) {
            if(mPath[i]==1){
                lengthOne+=array[i];
            }
            if(mPath[i]==-1){
                lengthTwo+=array[i];
            }
        }
        return lengthOne*lengthTwo;
    }

    static void dfs(int path[],int num,int addOr){
        path[num]=addOr;
        if (num==mArray.length-1){
            int abs = Math.abs(diff(path));
            if(abs <mDiff){
                mPath=Arrays.copyOf(path,path.length);
                mDiff=abs;
            }
            return;
        }
        dfs(path,num+1,1);
        dfs(path,num+1,-1);
    }

    static int diff(int[] path){
        int diff=0;
        for (int i=0;i<mArray.length;i++){
            diff+=mArray[i]*path[i];
        }
        return diff;
    }

}
