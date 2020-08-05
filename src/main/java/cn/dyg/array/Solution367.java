package cn.dyg.array;

/**
 * Solution367 类是 有效的完全平方数
 * <p>
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * <p>
 * 示例 1：
 * <p>
 * 输入：16
 * 输出：True
 * 示例 2：
 * <p>
 * 输入：14
 * 输出：False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author dongyinggang
 * @date 2020-08-05 11:27
 **/
public class Solution367 {

    /**
     * isPerfectSquare 方法是 二分法求解
     *
     * @param num 待判断是否完美平方数的值
     * @return 判断结果
     * @author dongyinggang
     * @date 2020/8/5 11:27
     */
    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num / 2 + 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num >= mid * mid) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (num == ans * ans);
    }

    /**
     * isPerfectSquare1 方法是 牛顿迭代法
     *
     * @param num 待判断是否完美平方数的值
     * @return 判断结果
     * @author dongyinggang
     * @date 2020/8/5 11:39
     */
    public boolean isPerfectSquare1(int num) {
        int x = num;
        //牛顿迭代法 x = (x+num/x)/2
        while ((long) x * x > num) {
            x = (x + num / x) / 2;
        }
        return num == (x * x);
    }
}
