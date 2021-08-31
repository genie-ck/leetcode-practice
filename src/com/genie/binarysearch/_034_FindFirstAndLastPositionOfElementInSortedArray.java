//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。
//
// 进阶：
//
//
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
//
//
//
//
// 示例 1：
//
//
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
//
// 示例 2：
//
//
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]
//
// 示例 3：
//
//
//输入：nums = [], target = 0
//输出：[-1,-1]
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
// nums 是一个非递减数组
// -10⁹ <= target <= 10⁹
//
// Related Topics 数组 二分查找 👍 1174 👎 0


package com.genie.binarysearch;

import java.util.Arrays;

public class _034_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new _034_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] ints = solution.searchRange(new int[]{1, 2, 2, 2, 23}, 2);
        Arrays.stream(ints).forEach(System.out::println);
    }

    public class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }
            int l = lowerBound(nums, target);
            int r = upperBound(nums, target);
            return new int[]{l, r};
        }

        public int lowerBound(int[] nums, int target) {
            int rs = -1;
            int l = 0, r = nums.length - 1, mid;
            while (l <= r) {
                mid = l + (r - l) / 2;
                if (nums[mid] == target) {
                    rs = mid;
                    r = mid - 1; // 向左移动找到左边界
                } else if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return rs;
        }

        public int upperBound(int[] nums, int target) {
            int rs = -1;
            int l = 0, r = nums.length - 1, mid;
            while (l <= r) {
                mid = l + (r - l) / 2;
                if (nums[mid] == target) {
                    rs = mid;
                    l = mid + 1; // 向右移动找到有边界
                } else if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return rs;
        }
    }
}