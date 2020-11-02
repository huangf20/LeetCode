package leetCode;
/*
给定两个数组，编写一个函数来计算它们的交集。
        示例 1：

        输入：nums1 = [1,2,2,1], nums2 = [2,2]
        输出：[2]
        示例 2：

        输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        输出：[9,4]

*/

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[length1 + length2];
        int index = 0, index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2) {
                // 保证加入元素的唯一性
                if (index == 0 || num1 != intersection[index - 1]) {
                    intersection[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }


    public static void main(String[] args) {
        LeetCode349 leetCode349=new LeetCode349();
        int[] intersection = leetCode349.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        for (int i :
                intersection) {
            System.out.println(i);
        }
    }
}
