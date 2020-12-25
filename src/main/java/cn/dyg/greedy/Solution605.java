package cn.dyg.greedy;

/**
 * Solution605 类是 605. 种花问题
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * 示例 1:
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 *
 * @author dongyinggang
 * @date 2020-12-25 15:52
 **/
public class Solution605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        //连续间隔数目，除了数组头尾之外，间隔3以上开始才能种,3-1,5-2,因此可种(间隔-1)/2
        //数组头可认为是有 1,0在前,设置初始值为1，数组尾部可认为是间隔+2
        int num = 1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                //如果是0,则间隔+1
                num++;
            } else {
                //如果是1，看间隔能中几棵，能中几棵就领n-几，并且将间隔置0
                n -= (num - 1) / 2;
                num = 0;
            }
            //如果n减为0或负数，则直接返回true,否则继续循环
            if (n <= 0) {
                return true;
            }
        }
        //最后的位置单独处理，剩下两个就可以种一个
        return n <= (num) / 2;
    }

    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        //只需要考虑0旁边是否都是0，如果是两头只需要判断一侧是0
        int length = flowerbed.length;
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0
                    && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == length - 1 || flowerbed[i + 1] == 0)) {
                //将种花位置设置为1，然后将n进行-1，后一个位置一定不能种花，直接跳过
                flowerbed[i++] = 1;
                n--;
            }
            //如果n小于0，说明花已经种完了，则直接返回true，注意用例[0],0,不能用==,会产生-1
            if (n <= 0) {
                return true;
            }
        }
        //若遍历完成后没有return，说明还有花每种下去
        return false;
    }

}
