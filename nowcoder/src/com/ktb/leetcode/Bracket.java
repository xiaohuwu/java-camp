package com.ktb.leetcode;

import com.ktb.leetcode.otherlinklist.Solution;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-parentheses/
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 */
public class Bracket {


    public boolean isValid(String s) {
        Stack<String> stack = new Stack<String>();
        String[] split = s.split("");
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("(") || split[i].equals("{") || split[i].equals("[")) {
                stack.push(split[i]);
            } else {
                if(stack.isEmpty())
                    return false;
                String pop = stack.pop();
                if ((pop.equals("(") && split[i].equals(")")) || (pop.equals("{") && split[i].equals("}")) || (pop.equals("[") && split[i].equals("]"))) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println((new Bracket()).isValid("()[]{}"));
        System.out.println((new Bracket()).isValid("([)]"));
    }

}
