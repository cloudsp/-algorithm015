package test;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class binary_tree_inorder_traversal_94 {
    /**
     * 94. 二叉树的中序遍历
     *
     * 给定一个二叉树，返回它的中序 遍历。
     *
     * 示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,3,2]
     *
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     *
     * */

    //Definition for a binary tree node.
     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    public void reversal(TreeNode root,List<Integer> result){
         if (root ==null) return;
         reversal(root.left,result);
         result.add(root.val);
         reversal(root.right,result);
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        /**
         * 递归
         * */
         List<Integer> result = new LinkedList<>();
         reversal(root,result);
         return result;

    }
    public List<Integer> inorderTraversal2(TreeNode root) {
        /**
         * 迭代通过stack
         * */
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> node = new Stack<>();
        if (root==null) return res;
        node.push(root);
        while (!node.isEmpty()) {
            TreeNode p = node.pop();
            if (p != null) {
                if (p.right != null) node.push(p.right);
                node.push(p);
                node.push(null);
                if (p.left != null) node.push(p.left);
            } else {
                res.add(node.pop().val);
            }
        }
        return res;

    }
}
