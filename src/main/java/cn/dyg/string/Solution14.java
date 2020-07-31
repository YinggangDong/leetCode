package cn.dyg.string;

/**
 * Solution14 类是 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author dongyinggang
 * @date 2020-07-31 10:44
 **/
public class Solution14 {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length==0){
            return "";
        }
        String first = strs[0];
        //进行纵向扫描,按所有字符串的第i位是否相等逻辑来判断是否公共前缀串
        for(int i = 0;i<first.length();i++){
            //首个String的第i位字符
            char c = first.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                //如果i和除strs[0]之外字符串的长度一样,说明该字符串就是最长公共前缀
                if(i == strs[j].length()){
                    return strs[j];
                }
                //如果c和某字符串第i位的字符不一致,则说明0,i的字符串就是最长公共前缀
                if(c!=strs[j].charAt(i)){
                    return first.substring(0,i);
                }
            }
        }
        //循环结束后,如果没有进行return,说明strs[0]是最长公共前缀,进行返回
        return strs[0];
    }
}
