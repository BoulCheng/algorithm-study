package com.zlb;

import com.alibaba.fastjson.JSON;

/**
 * @author Yuanming Tao
 * Created on 2019/5/28
 * Description
 */
public class QuickSort {


    private static int patition(int[] arr, int left, int right, int pivot) {

        int pivotValue = arr[pivot];
        arr[pivot] = arr[right];
        arr[right] = pivotValue;

        int index = left;
        for (int i = left; i <= right - 1; i++) {
            if (arr[i] < pivotValue) {
                if (i != index) {
                    int tmp = arr[i];
                    arr[i] = arr[index];
                    arr[index] = tmp;
                }
                ++index;
            }
        }

        arr[right] = arr[index];
        arr[index] = pivotValue;

        return index;
    }


    public static void quickSort(int[] arr, int left, int right) {

        if (right <= left) {
            return;
        }

        int pivot = patition(arr, left, right, right);

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);

    }

    public static void main(String[] args) {
//        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] arr = new int[]{9, 5, 7, 1, 0, 55, 88, 0, 87, 103, 555, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(JSON.toJSONString(arr));
    }
}
