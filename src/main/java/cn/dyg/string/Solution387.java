package cn.dyg.string;

/**
 * Solution387 类是  字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 示例：
 * s = "leetcode"
 * 返回 0
 * s = "loveleetcode"
 * 返回 2
 *
 * @author dongyinggang
 * @date 2020-12-24 10:39
 **/
public class Solution387 {

    public int firstUniqChar(String s) {
        //1.只考虑小写字母，所以构建一个数组记录每个字母的出现次数
        int[] arr = new int[26];
        //2.遍历字符串，将所有的字母出现次数存入数组arr
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        //3.便利字符串，首个出现次数为1的进行返回
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        //若均不为1次，则返回-1
        return -1;
    }

}
