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

        int[] arr2 = {9, 8, 7, 6, 5, 4, 3, 1, 2, 0};
        System.out.println(JSON.toJSONString(sort21(arr2)));

    }


    /**
     * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止
     *
     * 选择增量gap=length/2，缩小增量继续以gap = gap/2的方式，这种增量选择我们可以用一个序列来表示，{n/2,(n/2)/2...1}，称为增量序列 也称为希尔增量
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


    public static int[] sort21(int[] arr2) {
        int[] arr = Arrays.copyOf(arr2, arr2.length);

        for (int gap = arr.length / 2; gap >= 1; gap = gap / 2) {

            for (int i = 0; i < gap; i++) {

                for (int j = i + gap; j < arr.length; j += gap) {
                    int index = j;
                    int tmp = arr[j];
                    while (index >= i + gap && arr[index - gap] > tmp) {
                        arr[index] = arr[index - gap];
                        index -= gap;
                    }

                    if (index != j) {
                        arr[index] = tmp;
                    }
                }
            }
        }

        return arr;
    }

}


