package cn.dyg.array;

import java.util.Arrays;

/**
 * Solution4 类是 leetCode第四题 寻找两个正序数组的中位数 https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 *
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author dongyinggang
 * @date 2020-06-19 13:26
 **/
public class Solution4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m+n];
        for(int i = 0; i<m+n;i++){
            if(i<m){
                nums[i] = nums1[i];
            }else{
                nums[i] = nums2[i-m];
            }
        }
        Arrays.sort(nums);
        if((m+n)%2 == 0){
            return (nums[(m+n)/2-1]+nums[(m+n)/2])/2.0;
        }else{
            return nums[(m+n)/2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
