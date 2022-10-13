package cs.vsu.handlers;


public interface IDeleteHandler<T> {
    void onDelete(T index);
    void onDeleteClear();
}
