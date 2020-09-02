package test;

import java.util.ArrayList;
import java.util.List;

/**
 *22. 括号生成
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 *
 * */
public class generate_parentheses_22 {

    /**
     *
     * 四步走
     * terminator
     * process current logic
     * drill down
     * reverse status
     * */
    private ArrayList<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        _generate(0,0,n,"");
        return result;
    }

    private void _generate(int left,int right, int n, String s) {
        //terminator
        if (left == n && right == n) result.add(s);
        //process current logic
        //drill down
        if (left < n) _generate(left+1,right,n,s+"(");
        if (right<left) _generate(left,right+1,n,s+")");
        //reverse states
    }

    public static void main(String[] args) {
        generate_parentheses_22 sol = new generate_parentheses_22();
        System.out.println(sol.generateParenthesis(3));

    }

}
