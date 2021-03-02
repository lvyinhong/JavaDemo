package com.llvvlv00.linkedlist.linked;

import com.llvvlv00.linkedlist.abstructclass.AbstractList;

import javax.xml.soap.Node;

/**
 * @author lyh
 * @ClassName: LinkedList
 * @description
 * @create 2021/02/26 - 11:38
 */
public class LinkedList<E> extends AbstractList<E> {

    private Node first;
    private Node last;

    private static class Node<E> {
        Node<E> next;
        Node<E> pre;
        E element;
        public Node(Node pre, Node next, E element) {
            this.pre = pre;
            this.next = next;
            this.element = element;
        }
    }

    @Override
    public void add(E emelent) {
        add(size, emelent);
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        checkPostIndex(index);
//        if(index == 0)
//            first = new Node(first, element);
//        else {
//            Node<E> pre = node(index - 1);
//            Node<E> next = pre.next;
//            pre.next = new Node<E>(next, element);
//        }
//        size++;
        if(index == size) {
            linkLast(element);
        }else {
           linkBefore(element, node(index));
        }
        size++;
    }

    // 添加到末尾或者没有元素的情况
    private void linkLast(E element) {
        // 1、拿到last节点， 2、构建node节点完成指向关系，3、将原来的last节点的next修改成新构建出来的node，4、将链表的last进行修改
        Node l = last;
        Node newNode =new Node(l, null, element);
        last = newNode;
        if (l == null) {
            first = newNode;
        }else
            l.next = newNode;
    }

    private void linkBefore(E element, Node node) {
        // 1、获得指定的index 2、前一个节点的获取 3、构建新的node指向关系 4、改变 1,2 的指向
        Node<E> pre = node.pre;
        Node<E> newNode = new Node<>(pre, node, element);
        node.pre = newNode;
        if(pre == null)
            first = newNode;
        else
            pre.next = newNode;
    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);

//        Node<E> oldNode = first;
//        if(index == 0)
//            first = first.next;
//        else {
//            Node<E> pre = node(index - 1);
//            oldNode = pre.next;
//            pre.next = oldNode.next;
//        }
//        size--;
//        return oldNode.element;
        Node<E> node = node(index);
        Node<E> pre = node.pre;
        Node<E> next = node.next;

        if(pre == null) {
            first = next;
            next.pre = null;
        }else {
            pre.next = next;
        }
        if(next == null) {
            last = pre;
        }else {
            next.pre = pre;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {

        return 0;
    }

    @Override
    public void clear() {
        size = 0;
        // 可达性算法
        // help gc
        first = null;
        last = null;
    }

    private Node<E> node(int index) {
        Node x = first;
        // 先判断要查找的index 是靠近头还是靠近尾
        if(index > size >> 1) {
            //靠近尾
            for (int i = size -1; i > index; i--) {
                x = x.pre;
            }
        }else {
            // 靠近头
        }
        for (int i=0; i < index;i++) {
            x = x.next;
        }
        return x;
    }

    private void checkElementIndex(int index)  {
        if(!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(": Index: "+index+", Size: "+size);
        }
    }

    private void checkPostIndex(int index) {
        if(!isPostIndex(index)) {
            throw new IndexOutOfBoundsException(": Index: "+index+", Size: "+size);
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPostIndex(int index) {
        return index >= 0 && index <= size;
    }



    @Override
    public String toString() {
        if(size == 0){
            return "[]";
        }
        StringBuffer sb = new StringBuffer().append("[");
        Node x = first;
        for (Node i= x; i!=null;i=i.next) {
            sb.append(i.element);
            if(i.next == null)
                return sb.append("]").toString();
            sb.append(",");
        }

        return sb.toString();
    }
}
