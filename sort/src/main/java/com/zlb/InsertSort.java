package com.zlb;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @author Yuanming Tao
 * Created on 2019/4/17
 * Description
 */
public class InsertSort {


    /**
     * 从第一个元素开始，该元素可以认为已经被排序
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置，(并假设待插入元素插入该元素原来的位子)
     * 重复步骤 3，直到找到已排序的元素小于或者等于新元素的位置
     * 将新元素插入到该位置后
     * 重复步骤 2~5
     */
//    public class InsertSort {
//
//        public int[] sort(int[] sourceArray) throws Exception {
//            // 对 arr 进行拷贝，不改变参数内容
//            int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
//
//            // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
//            for (int i = 1; i < arr.length; i++) {
//
//                // 记录要插入的数据
//                int tmp = arr[i];
//
//                // 从已经排序的序列最右边的开始比较，找到比其小的数
//                int j = i;
//                while (j > 0 && tmp < arr[j - 1]) {
//                    arr[j] = arr[j - 1];
//                    j--;
//                }
//
//                // 存在比其小的数，插入
//                if (j != i) {
//                    arr[j] = tmp;
//                }
//
//            }
//            return arr;
//        }
//    }


    /**
     * 从第一个元素开始，该元素可以认为已经被排序
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 重复步骤 3，直到找到已排序的元素小于或者等于新元素的位置
     * 将新元素插入到该位置后
     * 重复步骤 2~5
     *
     * @param sourceArr
     * @return
     */
    public static int[] insertSort(int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);

        // 第一个元素可以认为已经是有序的 待插入的元素为从第二个元素到最后一个元素
        for (int i = 1, i2 = arr.length; i < i2; i++) {
            int tmp = arr[i];

            int j = i;
            //如果该元素（已排序）大于新元素，将该元素移到下一位置，(并假设待插入元素插入该已排序元素原来的位子)
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[--j];
            }

            if (j != i) {
                arr[j] = tmp;
            }
        }
        return arr;
    }


    public static void main(String[] args) {

        int[] arr = {9, 8, 7, 6, 5, 4, 3, 1, 2, 0};
        arr = insertSort(arr);
        System.out.println(JSON.toJSONString(arr));


        int[] arr2 = {9, 8, 7, 6, 5, 4, 3, 1, 2, 0};
        sort19(arr2);
        System.out.println(JSON.toJSONString(arr2));

    }


    public static void sort19(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int index = i;
            for (int j = i - 1; j >= 0; --j) {
                //从小到大排序
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                    index = j;
                } else {
                    break;
                }
            }
            if (index != i) {
                arr[index] = tmp;
            }
        }
    }

}
