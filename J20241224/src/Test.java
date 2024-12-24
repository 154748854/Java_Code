interface Usb {
    public abstract void method1();
    void method2();
}
abstract class Shape {//抽象类
    abstract public void draw();
    //被abstract修饰的方法没有方法体
}

interface Test1 {
    double brand = 3.0;//默认被public static final修饰
}
public class Test {
    public static void main(String[] args) {
        System.out.println(Test1.brand);//可以通过接口名访问，说明是static的
        //Test1.brand = 4.0;//是final修饰的
    }
}
