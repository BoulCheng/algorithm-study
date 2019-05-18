package com.zlb;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @author Yuanming Tao
 * Created on 2019/4/11
 * Description
 */
public class BubbleSort implements ArraySort {

    /**
     * 从小到大排序
     * @param original
     * @return
     */
    @Override
    public int[] sort(int[] original) {

        int[] arr = Arrays.copyOf(original, original.length);

        //需要进行排序的最大元素个数为数组元素总数减一 假如有三个数 3 1 2 那么仅剩最后两个元素待排序时 其中一个元素排序了 那么最后一个元素自然而然被排序
        for (int i = 1, i2 = arr.length; i < i2; i++) {

            //是否已经全部有序
            boolean sorted = true;

            //每个元素需要进行相邻两个元素比较的最大次数为待排序元素总数减一 假如两个元素 4 5 那么只需要相邻比较一次
            //外层循环一次 待排序元素少一
            for (int j = 0, j2 = arr.length; j < j2 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    //如果对某个元素进行排序的过程中 没有任何相邻的元素交换过 则表明已经全部都有序
                    sorted = false;
                }
            }

            if (sorted) {
                break;
            }
        }
        return arr;
    }


    public static void main(String[] args) {

        int[] arr = new int[]{3, 4, 5, 1, 2, 7, 8, 0, 9, 10};
        boolean allSorted;
        for (int i = 1; i < arr.length; i++) {
            allSorted = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    allSorted = false;
                }
            }
            if (allSorted) {
                break;
            }
        }
        System.out.println(JSON.toJSONString(arr));


        //18
        int[] arr2 = new int[]{3, 4, 5, 1, 2, 7, 8, 0, 9, 10};
        sort18(arr2);
        System.out.println(JSON.toJSONString(arr2));

    }

    public static void sort18(int[] arr) {

        boolean allSorted;
        for (int i = 1; i < arr.length; i++) {
            allSorted = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    allSorted = false;
                }
            }
            if (allSorted) {
                break;
            }
        }
    }

}
