package cs.vsu.handlers;

public class AddPrintHandler<T> implements IAddHandler<T> {

    private String text = "Добавлен элемент";

    public AddPrintHandler(String text) {
        this.text = text;
    }

    public AddPrintHandler() {
        this.text = text;
    }

    @Override
    public void onAdd(T value) {
        System.out.printf(text + " "  +  value + "\n");
    }


}
