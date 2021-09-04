//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 2613 👎 0


package com.genie.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _020_ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new _020_ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            //先处理掉字符串空或者单数的情况，然后把键值对塞入map中，
            // 遍历字符串，如果是左括弧加入栈，如果是右括弧，判断栈是否空或者栈顶是否匹配当前字符，是的话弹出
            //最后走完的话，判断栈是不是空
            if (s == null || s.length() % 2 == 1) {
                return false;
            }
            Map<Character, Character> map = new HashMap<>();
            map.put('}', '{');
            map.put(']', '[');
            map.put(')', '(');
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char a = s.charAt(i);
                if (!map.containsKey(a)) {
                    stack.push(a);
                } else {
                    if (stack.isEmpty() || stack.peek() != map.get(a)) {
                        return false;
                    }
                    stack.pop();
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}