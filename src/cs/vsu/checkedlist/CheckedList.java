package cs.vsu.checkedlist;

import cs.vsu.handlers.IAddHandler;
import cs.vsu.handlers.IDeleteHandler;
import cs.vsu.handlers.IGetHandler;

import java.util.LinkedList;
import java.util.List;

public abstract class CheckedList<T> {
    protected List<IDeleteHandler> iDeleteHandlers;
    protected List<IAddHandler> iAddHandlers;
    protected List<IGetHandler> iGetHandlers;

    public CheckedList() {
        iDeleteHandlers = new LinkedList<>();
        iAddHandlers = new LinkedList<>();
        iGetHandlers = new LinkedList<>();
    }

    public void addAddHandler(IAddHandler addHandler) {
        iAddHandlers.add(addHandler);
    }

    public void addDeleteHandler(IDeleteHandler deleteHandler) {
        iDeleteHandlers.add(deleteHandler);
    }

    public void addGetHandler(IGetHandler getHandler) {
        iGetHandlers.add(getHandler);
    }

    public void removeAddHandler(IAddHandler addHandler) {
        iAddHandlers.remove(addHandler);
    }

    public void removeDeleteHandler(IDeleteHandler deleteHandler) {
        iDeleteHandlers.remove(deleteHandler);
    }

    public void removeGetHandler(IGetHandler getHandler) {
        iGetHandlers.remove(getHandler);
    }

    public abstract void add(int index, T value);

    public abstract void addFirst(T value);

    public abstract void addLast(T value);

    public abstract void removeFirst();

    public abstract void removeLast();

    public abstract int size();

    public abstract void remove(int index);

    public abstract T get(int index);

    public abstract T getFirst();

    public abstract T getLast();
}
