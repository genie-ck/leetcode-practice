//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics 数组 排序 👍 1075 👎 0


package com.genie.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _056_MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new _056_MergeIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            //先按int[0] 排序
            //定义一个链表，然后如果为空往里添加第一个，如果链表最后的r小于当前的l 也加
            //否则更新链表最后的r,取链表中r和当前r中大的那个
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            List<int[]> list = new ArrayList<int[]>();
            for (int i = 0; i < intervals.length; i++) {
                int l = intervals[i][0], r = intervals[i][1];
                if (list.size() == 0 || list.get(list.size() - 1)[1] < l) {
                    list.add(new int[]{l, r});
                } else {
                    list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], r);
                }
            }
            return list.toArray(new int[list.size()][2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}