/*class Animal {
    String name;
    int age;

}
class Cat extends Animal {
    void bark() {
        System.out.println(this.name + "喵喵");
    }
}*/

/*class Base {
    int a;
}
class Derived extends Base {
    int c;
    public void meth0d() {//JAVA所有的除定义或声明语句之外的任何语句都必须在方法内部
        // (而方法又必须在某个类内部,不存在游离于类外部的方法或成员)
        a = 10;//访问从父类中继承下来的成员变量a
        c = 30;//访问子类自己的c
    }
}*/

/*class Base {
    int a;
    public void method() {
        System.out.println("Base");
    }
}
class Derived extends Base {
    int a;//与父类成员变量同名
    public void method(int a) {//参数列表不同，构成重载
        System.out.println("Derived");
    }
    public void method2() {
        a = 100;//this.a = 100;
        super.a = 200;
        method();
        method(20);//根据参数列表去选择合适的成员方法
    }

}*/

class Father {
    String name;
    public Father(String name) {//父类的带一个参数的构造方法
        this.name = name;
        System.out.println("父类的构造方法");
    }
    {
        System.out.println("父类实例代码块");
    }
    static {
        System.out.println("父类静态代码块");
    }
}
class Son extends Father {
    public Son(String name) {//父类构造方法带参数
        //需要在子类显式定义构造方法，并且在子类构造方法中
        // 选择那个带一个参数的父类构造方法调用
        super(name);
    }
    {
        System.out.println("子类的实例代码块");
    }
    static {
        System.out.println("子类的静态代码块");
    }
}
public class Test {
    public static void main(String[] args) {
        Son son1 = new Son("张三");
        System.out.println("======第二次new子类对象=====");
        Son son2 = new Son("李四");
    }

   /* public static void main(String[] args) {
        Cat cat = new Cat();
        cat.name;
    }*/
}
