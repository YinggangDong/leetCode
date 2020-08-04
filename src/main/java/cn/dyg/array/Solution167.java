package cn.dyg.array;

/**
 * Solution167 类是 两数之和 II - 输入有序数组
 * <p>
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author dongyinggang
 * @date 2020-08-04 13:31
 **/
public class Solution167 {
    /**
     * twoSum 方法是 二分法解法
     *
     * @param numbers 数组
     * @param target  目标值
     * @return 结果值
     * @author dongyinggang
     * @date 2020/8/4 13:32
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] == target - numbers[i]) {
                    //如果相等直接返回该值
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    //如果mid值大了,则继续看左侧值
                    right = mid - 1;
                } else {
                    //如果mid值小了,继续看右侧值
                    left = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * twoSum1 方法是 双指针解法
     *
     * @param numbers 数组
     * @param target  目标值
     * @return 结果值
     * @author dongyinggang
     * @date 2020/8/4 14:29
     */
    public int[] twoSum1(int[] numbers, int target) {
        //慢指针
        int i = 0;
        int right = numbers.length;
        //当i<快指针的右边界时,可以继续改变i值
        while (i < right) {
            //快指针进行循环
            for (int j = i + 1; j < right; j++) {
                if (numbers[j] == target - numbers[i]) {
                    return new int[]{i + 1, j + 1};
                }
                if (numbers[j] > target - numbers[i]) {
                    //如果两数之和大于target了,则快指针的右侧范围就缩小为j
                    right = j + 1;
                }
            }
            //当前i无对应解时,将i进行+1
            i++;
        }

        return new int[]{-1, -1};
    }

    /**
     * twoSum2 方法是 双指针优化版-只需要遍历一次
     *
     * @param numbers 数组
     * @param target  目标值
     * @return 结果值
     * @author dongyinggang
     * @date 2020/8/4 14:39
     */
    public int[] twoSum2(int[] numbers, int target) {
        //左指针
        int left = 0;
        //右指针
        int right = numbers.length - 1;
        //双指针未交汇时,left右移,会让和变大,right左移,会让和变小,所以有以下逻辑
        while (left < right) {
            if (target == numbers[left] + numbers[right]) {
                return new int[]{left + 1, right + 1};
            } else if (target > numbers[left] + numbers[right]) {
                left++;
            } else {
                right--;
            }
        }
        //未找到解时,返回{-1, -1}
        return new int[]{-1, -1};
    }
}
