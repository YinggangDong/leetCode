package cn.dyg.array;

/**
 * Solution35 类是 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author dongyinggang
 * @date 2020-08-03 15:36
 **/
public class Solution35 {

    /**
     * searchInsert1 方法是 二分解法
     *
     * @param nums   数组
     * @param target 目标值
     * @return 所在下标或要插入的下标
     * @author dongyinggang
     * @date 2020/8/3 16:26
     */
    public static int searchInsert1(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length;
        //没有目标且区间存在时,就进行二分查找
        while (start < end) {
            int mid = start + (end - start) / 2;
            //如果mid的值小于目标值,则说明目标值在左侧,否则在右侧
            //严格小于目标值的下标都不是题解,因此下一个查询区间是[mid+1,end]
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                //如果mid下标的值大于目标值,此时大于mid的值都不会是题解,
                //但mid值可能是(当nums[mid-1]<target<nums[mid]时,mid为题解)
                //因此下一个查询区间是[start,mid]
                end = mid;
            }
        }
        return start;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 5;
        System.out.println(searchInsert1(nums, target));
    }

    /**
     * searchInsert 方法是 暴力解法-遍历查找
     *
     * @param nums   数组
     * @param target 目标值
     * @return 所在下标或要插入的下标
     * @author dongyinggang
     * @date 2020/8/3 15:40
     */
    public int searchInsert(int[] nums, int target) {
        //暴力解法
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * searchInsert2 方法是 二分解法-第二种
     *
     * @param nums   数组
     * @param target 目标值
     * @return 所在下标或要插入的下标
     * @author dongyinggang
     * @date 2020/8/3 16:59
     */
    public int searchInsert2(int[] nums, int target) {

        int n = nums.length;
        int left = 0;
        int right = n - 1;
        //当right<left后,就说明查询结束了
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //如果mid下标的值 < 目标值,也就是mid及之前的下标是非题解的,因此将left+1
            //此时题解区间为[mid+1,left]
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                //当nums[mid] >= target是,mid及之前的下标(含mid)可能是题解
                //此时题解区间为[left,mid-1]
                //排除掉了mid值,如果在[left,mid-1]未找到该值,
                //则说明mid值为要target所在或需要被插入的位置
                right = mid - 1;
            }
        }
        return left;
    }


}
