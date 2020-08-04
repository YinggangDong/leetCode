package cn.dyg.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Solution349 类是 两个数组的交集
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author dongyinggang
 * @date 2020-08-04 15:38
 **/
public class Solution349 {

    /**
     * intersection 方法是 转化为set通过contains实现
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集数组
     * @author dongyinggang
     * @date 2020/8/4 15:48
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        //通过set去重
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer i : nums1) {
            set1.add(i);
        }
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer i : nums2) {
            set2.add(i);
        }
        int[] res = new int[set1.size()];
        int index = 0;
        //通过set的contains方法进行判断,写入均存在的值
        for (Integer i : set1) {
            if (set2.contains(i)) {
                res[index] = i;
                index++;
            }
        }
        //仅获取res的被写入的几位
        return Arrays.copyOf(res, index);
    }

    /**
     * intersection1 方法是 通过containsAll取交集
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集数组
     * @author dongyinggang
     * @date 2020/8/4 15:50
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        //通过set去重
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer i : nums1) {
            set1.add(i);
        }
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer i : nums2) {
            set2.add(i);
        }
        //调用retainAll函数获取交集
        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        int index = 0;
        //写入交集的值
        for (Integer i : set1) {
            res[index] = i;
            index++;
        }
        //仅获取res的被写入的几位
        return res;
    }
}
