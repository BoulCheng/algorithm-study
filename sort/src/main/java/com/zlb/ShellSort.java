package com.zlb;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @author Yuanming Tao
 * Created on 2019/4/17
 * Description
 */
public class ShellSort {


    public static void main(String[] args) {


        int[] arr = {9, 8, 7, 6, 5, 4, 3, 1, 2, 0};
        arr = shellSort(arr);
        System.out.println(JSON.toJSONString(arr));

    }


    /**
     * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止
     * @param sourceArr
     * @return
     */
    public static int[] shellSort(int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        for (int i = arr.length / 2; i > 0; i /= 2) {
            for (int j = 0; j < i; j++) {
                for (int k = j + i; k < arr.length; k += i) {
                    int tmp = arr[k];
                    int l = k;
                    while (l > j && tmp < arr[l - i]) {
                        arr[l] = arr[l = l - i];
                    }
                    if (l != k) {
                        arr[l] = tmp;
                    }
                }
            }
        }
        return arr;
    }
}


