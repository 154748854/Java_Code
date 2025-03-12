class Singleton1 {
    // 类加载的同时,创建出一个实例
    private static Singleton1 instance = new Singleton1();
    // 只能通过这个方法来获取刚才的实例
    public static Singleton1 getInstance() {
        return instance;
    }
    // 将构造方法设为私有的,此时类外面的代码,就无法new出Singleton对象了
    private Singleton1() {};
}
public class Demo21 {
}
