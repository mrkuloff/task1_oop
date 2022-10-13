package cs.vsu.handlers;

public class SetPrintHandler<T> implements ISetHandler<T> {

    private String text = "Было и стало";

    public SetPrintHandler() {
        this.text = text;
    }

    public SetPrintHandler(String text) {
        this.text = text;
    }

    @Override
    public void onSet(T value1, T value2) {
        System.out.printf("\n" + text + " "  +  value1 + " ; " + value2);
    }
}
