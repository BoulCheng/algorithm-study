package com.zlb;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @author Yuanming Tao
 * Created on 2019/4/19
 * Description
 */
public class HeapSort {


    /**
     * 最大堆排序
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        int[] heap = buildMaxHeap(arr);
        System.out.println(JSON.toJSONString(heap));

        heapSort(heap);
        System.out.println(JSON.toJSONString(heap));
    }

    public static void heapSort(int[] arr) {
        int heapSize = arr.length;
        int tmp;
        for (int heapIndex = heapSize - 1; heapIndex > 0; heapIndex--) {
            tmp = arr[0];
            arr[0] = arr[heapIndex];
            arr[heapIndex] = tmp;
            maxHeapify(arr, --heapSize, 0);
        }

    }


    /**
     * 标示堆的数组，那么该数组下标为 数组长度n/2 到 n-1 的元素为叶节点
     *
     * @param arr
     * @return
     */
    public static int[] buildMaxHeap(int[] arr) {
        int[] heap = Arrays.copyOf(arr, arr.length);
        int heapSize = heap.length;
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            maxHeapify(heap, heapSize, i);
        }
        return heap;
    }

    public static void maxHeapify(int[] arr, int heapSize, int index) {
        index += 1;
        int largest = index;
        int left = index << 1;
        int right = (index << 1) + 1;

        if (left <= heapSize && arr[left - 1] > arr[largest - 1]) {
            largest = left;
        }

        //从左向右填充
        if (right <= heapSize && arr[right - 1] > arr[largest - 1]) {
            largest = right;
        }

        if (largest != index) {
            int tmp = arr[index - 1];
            arr[index - 1] = arr[largest - 1];
            arr[largest - 1] = tmp;
            maxHeapify(arr, heapSize, --largest);
        }
    }
}
