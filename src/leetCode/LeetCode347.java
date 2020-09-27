package leetCode;
/*给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

         

        示例 1:

        输入: nums = [1,1,1,2,2,3], k = 2
        输出: [1,2]
        示例 2:

        输入: nums = [1], k = 1
        输出: [1]
         

        提示：

        你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
        你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
        题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
        你可以按任意顺序返回答案。*/

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return  map.get(o2)-map.get(o1);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                int temp=map.get(nums[i]);
                map.put(nums[i],temp+1);
            }
            else {
                map.put(nums[i],1);
            }
        }
        for (Integer key : map.keySet()) {
            priorityQueue.offer(key);
        }
        int[]res=new int [k];
        for (int i = 0; i < k; i++) {
            res[i]=priorityQueue.poll();
        }
        return res;
    }
}
