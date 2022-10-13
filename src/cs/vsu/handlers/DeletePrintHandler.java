package cs.vsu.handlers;

public class DeletePrintHandler<T> implements IDeleteHandler<T> {
    @Override
    public void onDelete(T value) {
        System.out.printf("\nУдален элемент " +  value);
    }
}