//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 深度优先搜索 二叉树 👍 784 👎 0


package com.genie.binarytree;

public class _543_DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new _543_DiameterOfBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        int ans;

        public int diameterOfBinaryTree(TreeNode root) {
            //根节点的最大路径就等于 左最大深度+右最大深度
            ans = 1;
            depth(root);
            return ans;
        }

        public int depth(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int l = depth(node.left);
            int r = depth(node.right);
            ans = Math.max(ans, l + r);
            return Math.max(l, r) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}