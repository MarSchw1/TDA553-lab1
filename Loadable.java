public interface Loadable<T> {
    void load(T t);
    void unload();
}
