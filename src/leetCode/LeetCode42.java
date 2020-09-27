package leetCode;
/*给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

图片见LeetCode42Rainwatertrap.png

上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6*/


public class LeetCode42 {
    public int trap(int[] height) {
        int res=0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 1; j <= height[i]; j++) {
                int cur=i+1;
                if(i!=height.length-1&&height[i+1]<height[i]){
                    while (height[cur]<j&&cur<height.length-1){
                        cur++;
                    }
                    int temp=0;
                    if(height[cur]>=j&&cur-i>1){
                        temp=cur-i-1;
                    }

                    res+=temp;
                }
            }

        }
        return res;
    }
}
