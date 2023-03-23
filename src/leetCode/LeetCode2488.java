package leetCode;

import java.util.*;

/**
 * 给你一个长度为 n 的数组 nums ，该数组由从 1 到 n 的 不同 整数组成。另给你一个正整数 k 。
 * <p>
 * 统计并返回 nums 中的 中位数 等于 k 的非空子数组的数目。
 * <p>
 * 注意：
 * <p>
 * 数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，如果数组长度为偶数，则中位数是位于中间靠 左 的那个元素。
 * 例如，[2,3,1,4] 的中位数是 2 ，[8,4,3,5,1] 的中位数是 4 。
 * 子数组是数组中的一个连续部分。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,1,4,5], k = 4
 * 输出：3
 * 解释：中位数等于 4 的子数组有：[4]、[4,5] 和 [1,4,5] 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,1], k = 3
 * 输出：1
 * 解释：[3] 是唯一一个中位数等于 3 的子数组。
 *  
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i], k <= n
 * nums 中的整数互不相同
 * <p>
 */
public class LeetCode2488 {
    public int countSubarrays(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        int kIndex = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == k){
                kIndex = i;
                break;
            }
        }

        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sign(nums[i] - k);
            if(i < kIndex){
                count.put(sum, count.getOrDefault(sum, 0) + 1);
            } else {
                int pre0 = count.getOrDefault(sum, 0);
                int pre1 = count.getOrDefault(sum - 1, 0);
                res += pre0 + pre1;
            }

        }


        return res;
    }


    /**
     * 返回所有子数组
     * @param nums
     * @param k
     * @return
     */
    public static List<List<Integer>> countSubarray(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        int kIndex = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == k){
                kIndex = i;
                break;
            }
        }

        Map<Integer, Integer> count = new HashMap<>();


        Map<Integer, List<Integer>> countIndex = new HashMap<>();

        count.put(0, 1);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sign(nums[i] - k);
            if(i < kIndex){
                count.put(sum, count.getOrDefault(sum, 0) + 1);
                List<Integer> list = countIndex.getOrDefault(sum, new ArrayList<>());
                list.add(i);
                countIndex.put(sum, list);

            } else {
                int pre0 = count.getOrDefault(sum, 0);
                int pre1 = count.getOrDefault(sum - 1, 0);
                res += pre0 + pre1;

                if(pre0 != 0){
                    List<Integer> list = countIndex.get(sum);
                    for (int index: list) {
                        int[] subArray = Arrays.copyOfRange(nums, index + 1, i + 1);
                        System.out.println(Arrays.toString(subArray));
                    }
                }

                if(pre1 != 0){
                    List<Integer> list = countIndex.get(sum - 1);
                    for (int index: list) {
                        int[] subArray = Arrays.copyOfRange(nums, index + 1, i + 1);
                        System.out.println(Arrays.toString(subArray));
                    }
                }
            }

        }


        return null;
    }

    static int sign(int num){
        if(num == 0) return 0;

        return num > 0 ? 1 : -1;
    }


    public static void main(String[] args) {
        countSubarray(new int[]{3,2,1,4,5}, 4);
    }
}
