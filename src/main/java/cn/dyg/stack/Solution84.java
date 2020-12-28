package cn.dyg.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * Solution84 类是 柱状图中最大的矩形
 *
 * @author dongyinggang
 * @date 2020-12-28 11:37
 **/
public class Solution84 {

    /**
     * largestRectangleArea 方法是 暴力解法
     * 时间复杂度O(N²),两次循环均是对数组的遍历
     *
     * @param heights 直方图高度
     * @return 最大矩形面积
     * @author dongyinggang
     * @date 2020/12/28 11:41
     */
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int length = heights.length;
        //left指柱体的起始位置
        for (int left = 0; left < length; left++) {
            //寻找从left到right的柱子的最低高度,其决定了矩形高度（木桶效应）
            int height = Integer.MAX_VALUE;
            for (int right = left; right < length; right++) {
                height = Math.min(height, heights[right]);
                //如果出现高度为0的情况,则这轮不需要继续遍历,直接将左游标+1,进行下一轮
                if (height == 0) {
                    break;
                }
                res = Math.max(res, (right - left + 1) * height);
            }
        }
        return res;
    }

    /**
     * largestRectangleArea1 方法是 单调栈解法
     * 通过栈来记录每个柱子能够延伸的左值和右值
     * 时间复杂度O(N),每个元素最多入栈出栈一次
     *
     * @param heights 直方图高度
     * @return 最大矩形面积
     * @author dongyinggang
     * @date 2020/12/28 14:00
     */
    public int largestRectangleArea1(int[] heights) {
        int length = heights.length;
        //定义两个数组，分别记录当前柱高度能延伸到的左右坐标,开区间,并不能实际包含该坐标
        int[] left = new int[length];
        int[] right = new int[length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            //若当前栈顶元素>=当前元素,则说明柱子可以向左延伸，将对应的栈顶元素出栈
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            //若当前柱子大于栈顶元素的高度，则当前柱子不能向左延伸,left数组写入当前的栈顶元素,即当前柱子只能延伸至该位置，若是空，则说明前面的所有元素都能有当前柱子高度
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            //将当前元素坐标写入栈顶
            stack.push(i);
        }
        stack.clear();
        for (int i = length - 1; i >= 0; i--) {
            //反着做,看当前柱子高度能向右延伸多少
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                //当栈顶元素高度大于当前柱子高度，就出栈
                stack.pop();
            }
            //栈为空说明所有的柱子都比当前柱子高，可以延伸至最右侧，否则就是栈顶的位置
            right[i] = stack.isEmpty() ? length : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < length; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    /**
     * largestRectangleArea2 方法是 单调栈+常数优化
     *
     * @param heights 直方图高度
     * @return 最大矩形面积
     * @author dongyinggang
     * @date 2020/12/28 14:41
     */
    public int largestRectangleArea2(int[] heights) {
        int length = heights.length;
        //定义两个数组，分别记录当前柱高度能延伸到的左右坐标
        int[] left = new int[length];
        int[] right = new int[length];
        Arrays.fill(right, length);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            //若当前栈顶元素>=当前元素,则说明柱子可以向左延伸，将对应的栈顶元素出栈
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            //若当前柱子大于栈顶元素的高度，则当前柱子不能向左延伸,left数组写入当前的栈顶元素,即当前柱子只能延伸至该位置，若是空，则说明前面的所有元素都能有当前柱子高度
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            //将当前元素坐标写入栈顶
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < length; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
