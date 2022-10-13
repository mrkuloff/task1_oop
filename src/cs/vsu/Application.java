package cs.vsu;

import cs.vsu.checkedlist.LinkedList;
import cs.vsu.handlers.*;

public class Application {
    public static void main(String[] args) {
        LinkedList values = new LinkedList();

        IAddHandler addHandler = new AddPrintHandler();
        IDeleteHandler deleteHandler = new DeletePrintHandler();
        IGetHandler getHandler = new GetPrintHandler();
        values.addAddHandler(addHandler);
        values.addDeleteHandler(deleteHandler);
        values.addGetHandler(getHandler);

        values.addFirst(0);
        values.addFirst(1);
        values.addFirst("Куку");

        values.removeFirst();

        values.add(1, 44);

        values.size();
        values.getFirst();
    }
}

