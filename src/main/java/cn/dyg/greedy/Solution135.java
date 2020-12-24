package cn.dyg.greedy;

import java.util.Arrays;

/**
 * Solution135 类是 分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 * <p>
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 *
 * @author dongyinggang
 * @date 2020-12-24 08:35
 **/
public class Solution135 {

    public int candy(int[] ratings) {
        //问题被拆解为以下两个
        //从左至右情况下，若右侧评分>左侧评分,则右侧糖果数=左侧糖果数+1
        //从右至左情况下，若左侧评分>右侧评分，则左侧糖果数=右侧糖果数+1
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        //向left和right中填充初始值1
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        //从左向右遍历，若ratings[i]>ratings[i-1]，则使其值等于左侧元素值+1
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        //最右侧的一个糖果数在完成上述遍历后已经被决定，记录下来
        int count = left[ratings.length - 1];
        //从右向左遍历，若ratings[j]>ratings[j+1]，则说明左侧需要比右侧多分配一个糖果
        for (int j = ratings.length - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1]) {
                right[j] = right[j + 1] + 1;
            }
            //取两个数组中每个位置的最大值，就能同时满足相邻的孩子中，评分高的孩子必须获得更多的糖果的条件
            count += Math.max(left[j], right[j]);
        }
        return count;

    }
}
