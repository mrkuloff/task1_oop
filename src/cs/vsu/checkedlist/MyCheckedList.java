package cs.vsu.checkedlist;

import cs.vsu.handlers.IAddHandler;

public class MyCheckedList<T> extends CheckedList<T> {
    private MyListNode head = null;
    private MyListNode tail = null;
    private int size = 0;

    private class MyListNode {
        public T value;
        public MyListNode next;

        public MyListNode(T value, MyListNode next) {
            this.value = value;
            this.next = next;
        }

        public MyListNode(T value) {
            this(value, null);
        }
    }

    @Override
    public void addFirst(T value) {
        head = new MyListNode(value, head);
        if (size == 0) {
            tail = head;
        }
        size++;
        for (int i = 0; i < iAddHandlers.size(); i++) {
            iAddHandlers.get(i).add(value);
        }
    }

    @Override
    public void addLast(T value) {
        if (size == 0) {
            head = tail = new MyListNode(value);
        } else {
            tail.next = new MyListNode(value);
            tail = tail.next;
        }
        size++;
        for (int i = 0; i < iAddHandlers.size(); i++) {
            iAddHandlers.get(i).add(value);
        }
    }

    @Override
    public void removeFirst() {
        head = head.next;
        if (size == 1) {
            tail = null;
        }
        size--;
        for (int i = 0; i < iDeleteHandlers.size(); i++) {
            iDeleteHandlers.get(i).delete(getFirst());
        }
    }

    @Override
    public void removeLast() {
        if (size == 1) {
            head = tail = null;
        } else {
            tail = getNode(size - 2);
            tail.next = null;
        }
        size--;
        for (int i = 0; i < iDeleteHandlers.size(); i++) {
            iDeleteHandlers.get(i).delete(getLast());
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        MyListNode cur = getNode(index - 1);
        if (index == 0) {
            removeFirst();
        } else {
            MyListNode prev = getNode(index - 1);
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
            size--;
        }
        for (int i = 0; i < iDeleteHandlers.size(); i++) {
            iDeleteHandlers.get(i).delete(cur);
        }
    }

    @Override
    public T get(int index) {
        if (index > size-1) {
            return null;
        }
        MyListNode cur = getNode(index - 1);
        for (int i = 0; i < iGetHandlers.size(); i++) {
            iGetHandlers.get(i).get(cur);
        }
        return getNode(index).value;
    }

    @Override
    public T getFirst() {
        for (int i = 0; i < iGetHandlers.size(); i++) {
            iGetHandlers.get(i).get(head.value);
        }
        return head.value;
    }

    @Override
    public T getLast() {
        for (int i = 0; i < iGetHandlers.size(); i++) {
            iGetHandlers.get(i).get(tail.value);
        }
        return tail.value;
    }

    private MyListNode getNode(int index) {
        MyListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

}
