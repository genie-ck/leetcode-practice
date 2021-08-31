//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 👍 754 👎 0


package com.genie.binarysearch;

public class _069_MySqrt {
    public static void main(String[] args) {
        Solution solution = new _069_MySqrt().new Solution();
    }

    /**
     * 注意溢出 m*m
     * <=x 时  需要找到最大的 接着将l+1;
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            if (x < 2)
                return x;
            int l = 0, r = x, ans = -1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if ((long) m * m <= x) {
                    ans = m;
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}