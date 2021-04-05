package cn.dyg.array;

/**
 * Solution88 类是 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 *  
 *
 * @author dongyinggang
 * @date 2021-04-05 22:20
 **/
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //设置两个指向当前数组最后一个值的指针 p1,p2
        int p1 = m - 1, p2 = n - 1;
        int cur = 0;
        //当前已经赋值的坐标
        int curIndex = m + n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2];
                p2--;
            } else if (p2 == -1) {
                cur = nums1[p1];
                p1--;
            } else if (nums1[p1] > nums2[p2]) {
                //如果nums1的值大于nums2的当前只想知值,则需要将nums1的值写入
                cur = nums1[p1];
                p1--;
            } else {
                cur = nums2[p2];
                p2--;
            }
            nums1[curIndex--] = cur;
        }
    }
}
