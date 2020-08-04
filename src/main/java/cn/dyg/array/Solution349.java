package cn.dyg.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Solution349 类是
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
