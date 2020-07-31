package cn.dyg.string;

/**
 * Solution5 类是 最长回文子串 https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author dongyinggang
 * @date 2020-06-19 14:25
 **/
public class Solution5 {

    /**
     * longestPalindromeViolence 方法是 暴力解法
     *
     * @param s 入参
     * @return  最长回文串
     * @author dongyinggang
     * @date 2020/6/19 15:43
     */
    public static String longestPalindromeViolence(String s) {
        int length = s.length();
        if(length < 2){
            return s;
        }
        char[] sChar = s.toCharArray();
        //最长长度
        int maxlen = 1;
        //开始位置
        int begin = 0;

        for(int i = 0; i< length ;i++){
            for(int j = i+1;j < length;j++){
                if(j-i+1>maxlen && isPalindrome(sChar,i,j)){
                    maxlen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }

    public static boolean isPalindrome(char[] sChar,int left,int right){
        while(left <right){
            if(sChar[left] != sChar[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * longestPalindromeDp 方法是 动态规划解法
     *
     * @param s 入参
     * @return  最长回文子串
     * @author dongyinggang
     * @date 2020/6/22 11:41
     */
    public static String longestPalindromeDp(String s) {
        int length = s.length();
        if(length < 2){
            return s;
        }
        char[] sChar = s.toCharArray();
        //最长长度
        int maxlen = 1;
        //开始位置
        int begin = 0;
        //定义动态规划的数组
        boolean[][] dp = new boolean[length][length];
        //单个字符都是回文的
        for(int i = 0;i<length;i++){
            dp[i][i] = true;
        }
        for(int i = 1;i<length;i++){
            for(int j = 0;j<i;j++){
                if(sChar[i] != sChar[j]){
                    dp[j][i] = false;
                }else{
                    if(i-j<3){
                        dp[j][i] = true;
                    }else{
                        dp[j][i] = dp[j+1][i-1];
                    }
                }
                if(dp[j][i] == true && i-j+1>maxlen){
                    maxlen = i-j+1;
                    begin = j;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }

    /**
     * longestPalindromeCenterSpread 方法是 中心拓展解法
     *
     * @param s 入参
     * @return  最长回文子串
     * @author dongyinggang
     * @date 2020/6/22 12:19
     */
    public static String longestPalindromeCenterSpread(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0,1);
        for(int i =0;i<len -1 ;i++){
            String a = centerSpread(s,i,i);
            String b = centerSpread(s,i,i+1);
            String maxRes = a.length()>b.length()?a:b;
            if(maxRes.length()>maxLen){
                maxLen = maxRes.length();
                res = maxRes;
            }
        }
        return res;
    }

    public static String centerSpread(String s,int left,int right){
        int len = s.length();
        while(left >= 0 && right <len){
            if(s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }else{
                break;
            }
        }
        return s.substring(left+1 ,right);
    }

    private int start = 0, end = 0;

    /**
     * longestPalindromeCsPlus 方法是 中心拓展改进版解法
     *
     * @param s 入参
     * @return  最长回文子串
     * @author dongyinggang
     * @date 2020/6/22 13:28
     */
    public String longestPalindromeCsPlus(String s) {
        if(s.length()<2){
            return s;
        }
        char[] schar = s.toCharArray();
        helper(schar,0);
        return s.substring(start,end+1);
    }

    private void helper(char[] cs, int index) {
        //如果index到了倒数第一位，就已经遍历结束
        if(index >= cs.length - 1){
            return;
        }
        //本次其实下标和结束下标初始化
        int cur_start = index;
        int cur_end = index;
        //如果cur_end下标的字符和cur_start一致，则不需要再从当前下标进行拓展，将cur_end向右移动
        while(cur_end < cs.length -1 && cs[cur_start] == cs[cur_end+1]){
            cur_end++;
        }
        //记录下次拓展的起始下标
        index = cur_end;

        while(cur_start >0&&cur_end<cs.length-1&&cs[cur_start-1] == cs[cur_end+1]){
            cur_start--;
            cur_end++;
        }
        if(cur_end - cur_start >end - start){
            start = cur_start;
            end = cur_end;
        }
        helper(cs,index+1);

    }

    public static void main(String[] args) {
        String exampleString = "babad";
        System.out.println(longestPalindromeViolence(exampleString));
        System.out.println(longestPalindromeDp(exampleString));
        System.out.println(longestPalindromeCenterSpread(exampleString));
    }
}
