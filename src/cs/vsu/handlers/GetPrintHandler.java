package cs.vsu.handlers;

public class GetPrintHandler<T> implements IGetHandler<T> {

    private String text = "Получен элемент";

    public GetPrintHandler() {
        this.text = text;
    }

    public GetPrintHandler(String text) {
        this.text = text;
    }

    @Override
    public void onGet(T value) {
        System.out.printf("\n" + text + " "  +  value);
    }
}
