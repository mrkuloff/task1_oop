package cs.vsu.checkedlist;

public class LinkedList<T> extends CheckedList<T> {
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
    public void add(int index, T value) {
        MyListNode newValue = new MyListNode(value);
        if (index < 0 || index >= size) {
            return;
        }
        MyListNode cur = getNode(index - 1);
        MyListNode next = getNode(index);
        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            cur.next = newValue;
            newValue.next = next;
            size++;
        }
        for (int i = 0; i < iAddHandlers.size(); i++) {
            iAddHandlers.get(i).onAdd(newValue.value);
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
            iAddHandlers.get(i).onAdd(value);
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
            iAddHandlers.get(i).onAdd(value);
        }
    }


    @Override
    public void clear() {
        for (MyListNode x = head; x != null; ) {
            MyListNode next = x.next;
            x.value = null;
            x.next = null;
            x = next;
        }
        size = 0;
        for (int i = 0; i < iDeleteHandlers.size(); i++) {
            iDeleteHandlers.get(i).onDeleteClear();
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
            iDeleteHandlers.get(i).onDelete(getFirst());
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
            iDeleteHandlers.get(i).onDelete(getLast());
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
            iDeleteHandlers.get(i).onDelete(cur);
        }
    }

    @Override
    public T get(int index) {
        if (index > size-1) {
            return null;
        }
        MyListNode cur = getNode(index - 1);
        for (int i = 0; i < iGetHandlers.size(); i++) {
            iGetHandlers.get(i).onGet(cur);
        }
        return getNode(index).value;
    }

    @Override
    public void set(int index, T value) {
        MyListNode neww = getNode(index-1);
        T oldVal = neww.value;
        neww.value = value;
        for (int i = 0; i < iSetHandlers.size(); i++) {
            iSetHandlers.get(i).onSet(oldVal, neww.value);
        }
    }

    @Override
    public T getFirst() {
        if (head.next != null) {
            for (int i = 0; i < iGetHandlers.size(); i++) {
                iGetHandlers.get(i).onGet(head.value);
            }
        }
        return head.value;
    }

    @Override
    public T getLast() {
        if (head.next != null) {
            for (int i = 0; i < iGetHandlers.size(); i++) {
                iGetHandlers.get(i).onGet(tail.value);
            }
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
