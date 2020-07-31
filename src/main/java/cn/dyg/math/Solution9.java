package cn.dyg.math;

/**
 * Solution9 类是 回文数
 * <p>
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * @author dongyinggang
 * @date 2020-07-31 08:58
 **/
public class Solution9 {

    public boolean isPalindrome(int x) {
        //小于0,一定不满足回文
        if (x < 0) {
            return false;
        }
        //个位数为0且不为0时，一定不满足回文
        if (x != 0 && x % 10 == 0) {
            return false;
        }
        int reverseNum = 0;
        //不断判断,直到过了当前数的一般位数
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        return x == reverseNum || x == reverseNum / 10;
    }
}
