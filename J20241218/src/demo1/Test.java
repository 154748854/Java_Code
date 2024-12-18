package demo1;

class A {
    public A() {
        fun();
    }
    public void fun() {
        System.out.println("A.fun");
    }
}
class B extends A {
    private int num = 1;

    public void fun() {
        System.out.println(this.num+"Bfun");
    }
}
public class Test {
    public static void main(String[] args) {
        B b = new B();//运行结果为0Bfun
    }
}
