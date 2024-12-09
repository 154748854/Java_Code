package demo1;

public class Test {
    public static void main(String[] args) {
        Derived derived = new Derived();
        //test();
    }
}

class Base {
    public void method() {
        System.out.println("B:method");
    }
}

class Derived extends Base {
    public void method2() {
        System.out.println("Derived:method");
    }



    public void test() {
        method();
        method2();
    }
}
