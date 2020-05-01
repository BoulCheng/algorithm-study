package com.zlb.leetcode;

/***
 *
 *
 * class TripleInOne {
 *
 *         private int[] arr;
 *         private int[] stackTop; // 每个栈当前可push的索引（对应到arr中的索引）
 *         private int stackSize;
 *
 *         public TripleInOne(int stackSize) {
 *             this.stackSize = stackSize;
 *             arr = new int[stackSize * 3];
 *             stackTop = new int[]{0, 1, 2};
 *         }
 *
 *         public void push(int stackNum, int value) {
 *             int curStackTop = stackTop[stackNum];
 *             if (curStackTop / 3 == stackSize) {
 *                 // 栈已满
 *                 return;
 *             }
 *
 *             arr[curStackTop] = value;
 *             stackTop[stackNum] += 3;
 *         }
 *
 *         public int pop(int stackNum) {
 *             if (isEmpty(stackNum)) {
 *                 return -1;
 *             }
 *
 *
 *             int value = arr[stackTop[stackNum] - 3];
 *             stackTop[stackNum] -= 3;
 *             return value;
 *         }
 *
 *         public int peek(int stackNum) {
 *             if (isEmpty(stackNum)) {
 *                 return -1;
 *             }
 *
 *             return arr[stackTop[stackNum] - 3];
 *         }
 *
 *         public boolean isEmpty(int stackNum) {
 *             return stackTop[stackNum] < 3;
 *         }
 *     }
 *
 * 作者：yuruiyin
 * 链接：https://leetcode-cn.com/problems/three-in-one-lcci/solution/java-shu-zu-wei-zhi-fen-pei-by-npe_tle/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class TripleInOne {

    private int stackTotal = 3;
    private int firstHead = 0 - stackTotal;
    private int secondHead = 1 - stackTotal;
    private int thirdHead = 2 - stackTotal;

    private int[] arr;
    private int singleStackSize;

    public TripleInOne(int stackSize) {
        arr = new int[stackSize * stackTotal];
        singleStackSize = stackSize;
    }

    /**
     * @param stackNum 0 1 2
     * @param value
     */
    public void push(int stackNum, int value) {
        int head = getHead(stackNum);
        if (singleStackSize == 0 || (head >= stackNum && head / stackTotal + 1 == singleStackSize)) {
            // full
            return;
        }
        head = addHead(stackNum);
        arr[head] = value;
    }


    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            // empty
            return -1;
        }
        int ret = arr[getHead(stackNum)];
        subHead(stackNum);
        return ret;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            // empty
            return -1;
        }
        return arr[getHead(stackNum)];
    }

    public boolean isEmpty(int stackNum) {
        return getHead(stackNum) < stackNum;
    }

    private int getHead(int stackNum) {
        if (stackNum == 0) {
            return firstHead;
        } else if (stackNum == 1) {
            return secondHead;
        } else if (stackNum == 2) {
            return thirdHead;
        } else {
            throw new IllegalArgumentException();
        }

    }

    private int addHead(int stackNum) {
        if (stackNum == 0) {
            return (firstHead += stackTotal);
        } else if (stackNum == 1) {
            return (secondHead += stackTotal);
        } else if (stackNum == 2) {
            return (thirdHead += stackTotal);
        } else {
            throw new IllegalArgumentException();
        }

    }


    private void subHead(int stackNum) {
        if (stackNum == 0) {
            firstHead -= stackTotal;
        } else if (stackNum == 1) {
            secondHead -= stackTotal;
        } else if (stackNum == 2) {
            thirdHead -= stackTotal;
        } else {
            throw new IllegalArgumentException();
        }

    }


    public static void main(String[] args) {
        TripleInOne tripleInOne = new TripleInOne(3);
        int index = 0;
        tripleInOne.push(index, 1);
        tripleInOne.push(index, 2);
        tripleInOne.push(index, 3);
        tripleInOne.push(index, 4);
        tripleInOne.peek(index);
        tripleInOne.pop(index);
        tripleInOne.pop(index);
        tripleInOne.pop(index);
        tripleInOne.pop(index);

        index = 1;
        tripleInOne.push(index, 1);
        tripleInOne.push(index, 2);
        tripleInOne.push(index, 3);
        tripleInOne.push(index, 4);
        tripleInOne.peek(index);
        tripleInOne.pop(index);
        tripleInOne.pop(index);
        tripleInOne.pop(index);
        tripleInOne.pop(index);

        index = 2;
        tripleInOne.push(index, 1);
        tripleInOne.push(index, 2);
        tripleInOne.push(index, 3);
        tripleInOne.push(index, 4);
        tripleInOne.peek(index);
        tripleInOne.pop(index);
        tripleInOne.pop(index);
        tripleInOne.pop(index);
        tripleInOne.pop(index);


    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */