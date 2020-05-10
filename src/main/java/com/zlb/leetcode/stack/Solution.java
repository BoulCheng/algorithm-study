package com.zlb.leetcode.stack;


import java.util.LinkedList;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);

            while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            }
        }

        return stack.isEmpty() && j == popped.length;
    }


    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        Solution solution = new Solution();
        System.out.println(solution.validateStackSequences(pushed, popped));
    }
}