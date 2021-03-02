package com.llvvlv00.linkedlist.abstructclass;

import com.llvvlv00.linkedlist.inter.List;

/**
 * @author lyh
 * @ClassName: AbstractList
 * @description
 * @create 2021/02/26 - 11:32
 */
public abstract class AbstractList<E> implements List<E> {

    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }
}
