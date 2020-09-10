package test;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class binary_tree_preorder_traversal_144 {
    /**
     * 144. 二叉树的前序遍历
     *
     * 难度中等359收藏分享切换为英文关注反馈给定一个二叉树，返回它的 前序 遍历。
     *
     *  示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,2,3]
     *
     *
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     * */


     //Definition for a binary tree node.
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
        TreeNode(int x) { val = x; }
     }


    public void  traversalPre (TreeNode root, List<Integer> result ){
        if (root ==null) return;
        result.add(root.val);
        traversalPre(root.left,result);
        traversalPre(root.right,result);
    }

    public List<Integer> preorderTraversal1(TreeNode root) {

        /**
         * 递归
         * */
            List<Integer> result = new LinkedList();
            traversalPre(root,result);
            return result;
    }
    /**
     * 迭代通过stack
     * */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> node = new Stack<>();
        if (root == null) return res;
        node.push(root);
        while (!node.empty()){
            TreeNode p = node.pop();
            if (p != null){
                if (p.right!=null) node.push(p.right);
                if (p.left!=null) node.push(p.left);
                node.push(p);
                node.push(null);
            }else {//栈为空，说明遇到标记，执行方法内部的访问节点操作
                res.add(node.pop().val);
            }
        }
        return res;


    }


}
