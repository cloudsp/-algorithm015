package test;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class binary_tree_postorder_traversal_145 {

    /**
     * 145. 二叉树的后序遍历
     * 难度中等387收藏分享切换为英文关注反馈给定一个二叉树，返回它的 后序 遍历。
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
     * 输出: [3,2,1]
     *
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     * */

    // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

      public void traversal(TreeNode root,List<Integer> result){
          if (root ==null) return;
          traversal(root.left,result);
          traversal(root.right,result);
          result.add(root.val);

      }

    public List<Integer> postorderTraversal1(TreeNode root) {
        /**
         * 递归
         * */
        List<Integer> result = new LinkedList<>();
        traversal(root,result);
        return result;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        /**
         * 迭代通过stack
         * */
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> node = new Stack<>();
        if (root==null) return res;
        node.push(root);
        while (!node.isEmpty()){
            TreeNode p =node.pop();
            if (p!=null){
                node.push(p);
                node.push(null);
                if (p.right!=null) node.push(p.right);
                if (p.left!=null) node.push(p.left);
            }else {
                res.add(node.pop().val);
            }
        }
        return res;

    }
}
