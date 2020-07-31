package cn.dyg.string;

import java.util.HashMap;
import java.util.Stack;

/**
 * Solution20 类是 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author dongyinggang
 * @date 2020-07-31 13:25
 **/
public class Solution20 {

    public boolean isValid(String s) {
        if(s == null || s.length()==0){
            return true;
        }
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果是闭括号,则获取栈中的top元素,判断是否和闭括号匹配
            if(map.containsKey(c)){
                char topElement = stack.isEmpty()?'#':stack.pop();
                //如果不匹配,直接返回false
                if(topElement!=c){
                    return false;
                }
            }else {
                //如果是开括号,则向栈中push该元素
                stack.push(c);
            }
        }
        //全部完成后,如果匹配成功,且栈已经空,则返回true,若不为空,则说明开括号多了
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        if(s == null || s.length()==0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果是开括号,则向栈中push其对应的闭括号
            if(c=='('){
                stack.push(')');
            }else if(c=='[') {
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }else {
                //如果是闭括号,则从栈中pop出来比较是否对应,不对应返回false
                if(stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }
        }
        //全部完成后,如果匹配成功,且栈已经空,则返回true,若不为空,则说明开括号多了
        return stack.isEmpty();
    }
}
