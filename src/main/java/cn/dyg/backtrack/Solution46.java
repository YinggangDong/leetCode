package cn.dyg.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution46 类是 46. 全排列
 * <p>
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 回溯算法
 *
 * @author dongyinggang
 * @date 2021-04-03 21:40
 **/
public class Solution46 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, track);
        return res;
    }

    public void backTrack(int[] nums, LinkedList<Integer> track) {
        //如果track中满了所有的数字,就加入res，返回继续的回溯过程
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }
        //如果没有满,就继续进行数字选择
        for (int i = 0; i < nums.length; i++) {
            //如果当前排列已经含该元素,则继续选择其他元素
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            //继续选择下一个数字加入track
            backTrack(nums, track);
            track.removeLast();
        }
    }

}
