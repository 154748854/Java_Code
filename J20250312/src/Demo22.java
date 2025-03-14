class SingletonLazy {
    private static volatile SingletonLazy instance = null;
    private SingletonLazy() {};
    public static SingletonLazy getInstance() {
        synchronized (SingletonLazy.class) {
            if (instance == null) {
                instance = new SingletonLazy();
            }
        }
        return instance;

    }
}
public class Demo22 {
}
