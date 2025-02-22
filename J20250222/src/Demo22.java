import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

class SingletonLazy {
    private static volatile SingletonLazy instance = null;
    public static SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

    private SingletonLazy() {};
}
public class Demo22 {
    public static void main(String[] args) {

    }
}

