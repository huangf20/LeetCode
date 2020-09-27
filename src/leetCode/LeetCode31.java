package leetCode;

import java.util.Arrays;

/*下一个排列
        实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

        如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

        必须原地修改，只允许使用额外常数空间。

        以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
        1,2,3 → 1,3,2
        3,2,1 → 1,2,3
        1,1,5 → 1,5,1*/
public class LeetCode31 {
      public void nextPermutation(int[] nums) {
          int length=nums.length;
          int i=length-2;
          while(i>=0&&nums[i]>=nums[i+1]){
              i--;
          }
          if (i==-1){
              reverse(nums,0,length-1);
              return;
          }
          int j=nums.length-1;
          while (nums[j]<=nums[i]){
              j--;
          }
          int temp=nums[i];
          nums[i]=nums[j];
          nums[j]=temp;
          reverse(nums,i+1,length-1);


      }
      private void reverse(int[] nums,int start,int end){
          while (start<end){
              int temp=nums[start];
              nums[start]=nums[end];
              nums[end]=temp;
              start++;
              end--;
          }
      }

      public static void main(String[] args) {
          LeetCode31 leetCode31=new LeetCode31();
          int[] nums = {2,4,6,5,3,2,1};
          int[] nums1= {1,2,2,3,4,5,6};

            while (!Arrays.equals(nums,nums1)){
                leetCode31.nextPermutation(nums);
                for (int j = 0; j < nums.length; j++) {
                    System.out.print(nums[j]+"   ");
                }
                System.out.println();
            }



      }
}
