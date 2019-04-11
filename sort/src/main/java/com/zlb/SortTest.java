package com.zlb;

import com.alibaba.fastjson.JSON;

/**
 * @author Yuanming Tao
 * Created on 2019/4/11
 * Description
 */
public class SortTest {

    public static void main(String[] args) {

        int[] original = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        BubbleSort bubbleSort = new BubbleSort();
        int[] bubbleSortedArr = bubbleSort.sort(original);
        System.out.println(JSON.toJSONString(bubbleSortedArr));

    }
}
