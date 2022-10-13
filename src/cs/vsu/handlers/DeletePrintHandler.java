package cs.vsu.handlers;

public class DeletePrintHandler<T> implements IDeleteHandler<T> {

    private String text = "Удален элемент";

    public DeletePrintHandler() {
        this.text = text;
    }

    public DeletePrintHandler(String text) {
        this.text = text;
    }

    @Override
    public void onDelete(T value) {
        System.out.printf(text + " "  +  value + "\n");
    }

    @Override
    public void onDeleteClear() {
        System.out.printf("Удалены все элементы" + "\n");
    }
}