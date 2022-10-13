package cs.vsu.handlers;

public class GetPrintHandler<T> implements IGetHandler<T> {
    @Override
    public void onGet(T value) {
        System.out.printf("\nПолучен элемент " + value);
    }
}
