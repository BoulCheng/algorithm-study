package com.zlb.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 汉诺塔问题：
 * 1. 分治思想，既然一个盘子 两个盘子 三个盘子可以处理 那么大于三个盘子的情况就都能处理
 * 2. 能处理的原因是 只要三个柱子上的盘子的大小大于剩余需要移动的盘子大小 那么理论上就可以当作柱子上没有任何盘子来处理
 * 3. 采用递归处理
 */
class HanotaSolution {

    public void hanota(LinkedList<Integer> A, LinkedList<Integer> B, LinkedList<Integer> C) {
        hanota(A.size(), A, B, C);
    }

    public void hanota(int size, LinkedList<Integer> A, LinkedList<Integer> B, LinkedList<Integer> C) {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            C.push(A.pop());
            return;
        }

        hanota(size - 1, A, C, B);
        C.push(A.pop());
        hanota(size - 1, B, A, C);
    }



    /************************************************************************************************************************************/

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanota(A.size(), A, B, C);
    }

    public void hanota(int size, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }

        hanota(size - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        hanota(size - 1, B, A, C);
    }



//
//
//
//
//    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
//        move(A.size(),A, B, C,0);
//    }
//
//
//    public void move(int n, List<Integer> A, List<Integer> B, List<Integer> C, int depth){
//        if(n == 1){
//            C.add(A.remove(A.size() - 1));
//            return;
//        }
//        move(n-1,A,C,B,depth+1);
//        if (depth == 0) {
//            System.out.println(depth);
//        } else if (depth == 1) {
//            System.out.println(depth);
//
//        } else if (depth == 2){
//            System.out.println(depth);
//
//        } else if (depth == 3) {
//            System.out.println(depth);
//
//        } else if (depth == 4) {
//            System.out.println(depth);
//
//        } else if (depth == 5) {
//            System.out.println(depth);
//
//        } else if (depth == 6) {
//            System.out.println(depth);
//
//        }
//        C.add(A.remove(A.size() - 1));
//        move(n - 1, B, A, C,depth+1);
//    }
//
//    public static void main(String[] args) {
//
//        List<Integer> A = new ArrayList<>();
//
//        A.add(5);
//        A.add(4);
//        A.add(3);
//        A.add(2);
//        A.add(1);
//
//        List<Integer> B = new ArrayList<>();
//        List<Integer> C = new ArrayList<>();
//        HanotaSolution hanotaSolution = new HanotaSolution();
//
//        hanotaSolution.hanota(A, B, C);
//    }


    public static void main(String[] args) {

        LinkedList<Integer> A = new LinkedList<>();
        A.add(5);
        A.add(4);
        A.add(3);
        A.add(2);
        A.add(1);

        LinkedList<Integer> B = new LinkedList<>();
        LinkedList<Integer> C = new LinkedList<>();

        HanotaSolution solution = new HanotaSolution();
        solution.hanota(A, B, C);

        System.out.println(C);

    }
}
