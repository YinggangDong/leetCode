package cn.dyg.array;

/**
 * Solution374 类是 猜数字大小
 * <p>
 * 猜数字游戏的规则如下：
 * <p>
 * 每轮游戏，系统都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，系统会告诉你这个数字比系统选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 * <p>
 * -1 : 系统选出的数字比你猜测的数字小
 * 1 : 系统选出的数字比你猜测的数字大
 * 0 : 恭喜！你猜对了！
 *  
 * <p>
 * 示例 :
 * <p>
 * 输入: n = 10, pick = 6
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author dongyinggang
 * @date 2020-08-05 13:35
 **/
public class Solution374 {

    /**
     * guessNumber 方法是 二分法解法
     *
     * @param n n是范围上限
     * @return 系统选择的数字
     * @author dongyinggang
     * @date 2020/8/5 13:39
     */
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //系统选出的数字=mid
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                //系统选出的数字>mid,所以解只可能在mid右侧,left重新赋值
                left = mid + 1;
            } else {
                //系统选出的数字<mid,所以解只可能在mid左侧,right重新赋值
                right = mid - 1;
            }
        }
        return -1;
    }

    private int guess(int n) {
        return (Integer.compare(4, n));
    }
}
