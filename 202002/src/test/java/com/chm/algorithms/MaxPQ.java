package com.chm.algorithms;

/**
 * Author:meice Huang
 * Time: 2020/3/21 下午10:18
 * <p>
 * 基于堆的优先队列
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;//基于堆的完全二叉树
    private int N = 0; //存储与pq[1 .. N ]中，pq[0]没有使用

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];//从根节点得到最大元素
        exch(1, N--);//和最后一个节点交换
        pq[N + 1] = null;//防止对象游离
        sink(1);//恢复堆的有序性
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 1;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    /**
     * 堆排序
     */

    public void sort(Comparable[] a) {
        int N = a.length;
        for (int k = N / 2; k >= 1; k--) {
//            sink(a,k,N);
            while (N > 1) {
                Example.exch(a, 1, N--);
//              sink(a,1,N);

            }
        }
    }

}
