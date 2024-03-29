package TwoSum;

import java.util.HashMap;
import java.util.Map;

/*
 * @Author: Rocky Stone
 * @Date: 2019-08-01
 *
 * @Descriptoin: This problem is from leetcode
 *               The original problem is as follows:
 *
 *               给定一个整数数组 nums 和一个目标值 target，
 *               请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *               你可以假设每种输入只会对应一个答案。
 *               但是，你不能重复利用这个数组中同样的元素。
 *               示例:
 *               给定 nums = [2, 7, 11, 15], target = 9
 *               因为 nums[0] + nums[1] = 2 + 7 = 9
 *               所以返回 [0, 1]
 *
 */

public class TwoSum {
    public static void main(String[] args) {
        //int[] result = twoSum(new int[]{3, 7, 2, 8, 10, 6}, 4);

        int[] result = twoSumByBruteForce(new int[]{3, 7, 2, 8, 10, 6}, 10);

        System.out.println("i = " + result[0] + ", complement = " + result[1]);
    }

    public static int[] twoSumByBruteForce(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] == target - nums[i]){
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[]{i, map.get(complement)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSumByOnePassHashTable(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("no two sum solution");
    }
}