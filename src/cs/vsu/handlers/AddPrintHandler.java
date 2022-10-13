package cs.vsu.handlers;

public class AddPrintHandler<T> implements IAddHandler<T> {
    @Override
    public void onAdd(T value) {
        System.out.printf("\nДобавлен элемент " +  value);
    }
}
