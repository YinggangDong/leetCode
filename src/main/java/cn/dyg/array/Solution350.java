package cn.dyg.array;

import java.util.Arrays;

/**
 * Solution350 类是 两个数组的交集 II
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * @author dongyinggang
 * @date 2020-08-05 10:47
 **/
public class Solution350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        //先对数据进行排序,给指针移动创造条件
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //以较短数组长度创建新的数组用来存储相同的值
        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        //nums1的指针
        int index1 = 0;
        //nums2的指针
        int index2 = 0;
        //ans的指针,用来记录写入下标
        int index = 0;
        //如果某个数组遍历结束,就中止交集的查找
        while (index1 < nums1.length && index2 < nums2.length) {
            //相等的时候,写入ans数组,三个指针统一右移一位
            if (nums1[index1] == nums2[index2]) {
                ans[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            } else if (nums1[index1] > nums2[index2]) {
                //比较当前指针指向的值,哪个值较小,就右移继续比较
                index2++;
            } else {
                index1++;
            }
        }
        //返回ans当前写入的内容,通过copyOf将取其前index个值
        return Arrays.copyOf(ans, index);
    }
}
