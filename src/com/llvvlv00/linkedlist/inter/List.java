package com.llvvlv00.linkedlist.inter;

/**
 * @author lyh
 * @InterfaceName: List
 * @description
 * @create 2021/02/26 - 11:29
 */
public interface List<E> {
    int size();
    boolean isEmpty();
    boolean contains(E element);
    void add(E emelent);
    E get(int index);
    E set(int index, E element);
    void add(int index, E element);
    E remove(int index);
    int indexOf(E element);
    void clear();
    String toString();
}
