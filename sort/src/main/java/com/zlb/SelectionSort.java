package com.zlb;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @author Yuanming Tao
 * Created on 2019/4/11
 * Description
 */
public class SelectionSort implements ArraySort {

    /**
     * 从小到大排序 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾
     * @param original
     * @return
     */
    @Override
    public int[] sort(int[] original) {

        int[] arr = Arrays.copyOf(original, original.length);

        int minIndex;
        //需要进行排序的元素个数为总数减一 选择排序最后一个元素自然而然排序
        for (int i = 0, i2 = arr.length - 1; i < i2; i++) {

            minIndex = i;
            //待排序的元素从已排序元素的最后一个元素的下一个元素开始，每次排序需要进行比较的次数其实是待排序元素的总数减一 可以理解为待排序元素中其中一个元素与所有其他元素依次进行比较
            for (int j = i, j2 = arr.length - 1; j < j2; j++) {

//                从大到小排序
//                if (arr[j + 1] > arr[minIndex]) {
//                    minIndex = j + 1;
//                }
                if (arr[minIndex] > arr[j + 1]) {
                    minIndex = j + 1;
                }

            }

            //应该放在for循环外面 在一轮比较完再更新值 而不是每次比较更新值
            if (minIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] original = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        sort18(original);
        System.out.println(JSON.toJSONString(original));

    }

    public static void sort18(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }

}
