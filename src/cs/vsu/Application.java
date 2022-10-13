package cs.vsu;

import cs.vsu.checkedlist.LinkedList;
import cs.vsu.handlers.*;

public class Application {
    public static void main(String[] args) {
        LinkedList<Integer> values = new LinkedList<>();

        IAddHandler<Integer> addHandler = new AddPrintHandler<>("Добавлен элементище");
        IDeleteHandler<Integer> deleteHandler = new DeletePrintHandler<>();
        IGetHandler<Integer> getHandler = new GetPrintHandler<>();
        ISetHandler<Integer> setHandler = new SetPrintHandler<>();
        values.addAddHandler(addHandler);
        values.addDeleteHandler(deleteHandler);
        values.addGetHandler(getHandler);
        values.addSetHandler(setHandler);

        values.addFirst(0);
        values.addFirst(1);
        values.addFirst(2);
        values.addLast(43434);

        values.removeFirst();

        values.get(2);

        values.set(0, 3);

        values.getFirst();

        values.add(0, 5);

        values.getFirst();

        values.clear();
        values.getFirst();
    }
}

