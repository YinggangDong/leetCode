package cn.dyg.array;

import java.util.HashMap;

/**
 * Solution1 类是  两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author dongyinggang
 * @date 2020-07-31 08:53
 **/
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        //用来存储已经遍历的数组数据,key为值,value为下标
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int targetNum = target - nums[i];
            if(map.containsKey(targetNum)){
                return new int[]{map.get(targetNum),i};
            }
            //不是的就把其值作为key,数组中的下标作为value
            map.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}
