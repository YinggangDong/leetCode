package cn.dyg.array;

/**
 * Solution28 类是 实现 strStr()
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author dongyinggang
 * @date 2020-08-03 13:26
 **/
public class Solution28 {

    /**
     * strStr 方法是 双指针解法,逐个字符比对
     *
     * @param haystack 字符串
     * @param needle 目标子串
     * @return 字符串中目标子串的开始下标
     * @author dongyinggang
     * @date 2020/8/3 14:16
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int hayLength = haystack.length();
        int needLength = needle.length();
        //haystack的指针
        int pointH = 0;

        //如果指针到结束的长度比needle短,说明不存在,不再需要比较
        while (pointH < hayLength - needLength + 1) {
            //如果当前位置的字符和needle的首字符不一致,则pointH+1,直到匹配之后才进行后续匹配
            if(haystack.charAt(pointH) != needle.charAt(0)){
                pointH++;
                continue;
            }
            //当前匹配长度,用于进行pointH指针重置
            int matchLen = 0;
            //needle的指针
            int pointN = 0;
            //逐个字符进行比对,成功则持续比对
            while (pointH < hayLength && pointN < needLength &&
                    haystack.charAt(pointH) == needle.charAt(pointN)) {
                pointH++;
                pointN++;
                matchLen++;
            }
            //如果匹配长度等于n串长度,说明匹配结束,返回开始匹配的下标
            if (matchLen == needLength) {
                return pointH - matchLen;
            }
            //如果匹配失败,则h串的指针后移一位
            pointH = pointH - matchLen + 1;

        }
        //若h串中无n串,则返回-1
        return -1;
    }

    /**
     * strStr1 方法是 子串逐一比较 - 线性时间复杂度
     *
     * @param haystack 字符串
     * @param needle 目标子串
     * @return 字符串中目标子串的开始下标
     * @author dongyinggang
     * @date 2020/8/3 14:21
     */
    public int strStr1(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int hayLength = haystack.length();
        int needLength = needle.length();
        for (int i = 0; i < hayLength - needLength + 1; i++) {
            if(haystack.substring(i,i+needLength).equals(needle)){
                return i;
            }
        }
        //若h串中无n串,则返回-1
        return -1;
    }
}
