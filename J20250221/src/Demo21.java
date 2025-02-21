// 单例模式
class Singleton {
    private static Singleton instance = new Singleton();
    // 通过这个方法来获取到刚才的实力
    // 后续如果想使用这个类的实力,都通过getInstance 方法来获取
    public static Singleton getInstance() {
        return instance;
    }
    // 把构造方法设置成私有, 此时类外面的其它代码,就无法new这个类的对象了
    private Singleton() {}
}

public class Demo21 {
    public static void main(String[] args) {

    }
}
