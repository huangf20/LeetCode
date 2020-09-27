package leetCode;
/*978. 最长湍流子数组
        当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：

        若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
        或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
        也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。

        返回 A 的最大湍流子数组的长度。

         

        示例 1：

        输入：[9,4,2,10,7,8,8,1,9]
        输出：5
        解释：(A[1] > A[2] < A[3] > A[4] < A[5])
        示例 2：

        输入：[4,8,12,16]
        输出：2
        示例 3：

        输入：[100]
        输出：1*/
public class LeetCode978 {
    int start=0;
    int end=0;
    int res=1;
    public int maxTurbulenceSize(int[] A) {
        while(end<A.length){
            end++;
            if(end==A.length){
                break;
            }
            if(isTurbulence(A,start,end)){

                res=Math.max(res,end-start+1);
            }
            else{
                start=end-1;
                end=start+1;
            }
        }
        return res;
    }
    public boolean isTurbulence(int[] A,int start,int end){
        if(A[start]==A[start+1]){
            return false;
        }
        boolean turn=A[start]>A[start+1];
        for (int i = start+1; i <end; i++) {
            if(A[i]>A[i+1]==turn||A[i]==A[i+1]){
                return false;
            }
            turn=!turn;
        }
        return true;

    }

    public int maxTurbulenceSize(int[] A,int s){
        int res=1;
        int start=0;
        int length=A.length;
        for (int i = 1; i < length; i++) {
            int sign=Integer.compare(A[i-1],A[i]);
            if(i==length-1||sign*Integer.compare(A[i],A[i+1])!=-1){
                if(sign!=0){
                    res=Math.max(res,i-start+1);

                }
                start=i;
            }
        }
        return res;
    }



}
