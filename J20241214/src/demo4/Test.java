package demo4;

import sun.awt.HeadlessToolkit;

abstract class Animal {
    public String name;
    public int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public abstract void eat();

}
interface IFly {
    void fly();
}
interface IRun {
    void run();
}
interface ISwim {
    void swim();
}
class Dog extends Animal implements IRun {
    @Override
    public void eat() {
        System.out.println(this.name+"在吃饭");
    }

    public Dog(String name, int age) {
        super(name,age);
    }
    @Override
    public void run() {
        System.out.println(this.name+"正在跑");
    }
}
class Frog extends Animal implements ISwim,IRun {
    @Override
    public void eat() {
        System.out.println(this.name+"在吃饭");
    }
    public Frog(String name, int age) {
        super(name, age);
    }

    @Override
    public void run() {
        System.out.println(this.name+"正在用两个腿跳着跑");
    }

    @Override
    public void swim() {
        System.out.println(this.name+"正在蛙泳");
    }
}
class Duck extends Animal implements IRun,IFly,ISwim {
    @Override
    public void eat() {
        System.out.println(this.name+"在吃饭");
    }

    public Duck(String name, int age) {
        super(name, age);
    }

    @Override
    public void fly() {
        System.out.println(this.name+"正在用翅膀飞");
    }

    @Override
    public void run() {
        System.out.println(this.name+"正在摇着屁股跑");
    }

    @Override
    public void swim() {
        System.out.println(this.name+"正在划着游泳");
    }
}
public class Test {
    public static void func1(Animal animal) {
        animal.eat();
    }
    public static void running(IRun iRun) {
        iRun.run();
    }
    public static void flying(IFly iFly) {
        iFly.fly();
    }

    public static void main(String[] args) {
        running(new Duck("唐老鸭",3));//Duck实现了IFLY这个接口
    }
    public static void main1(String[] args) {
        func1(new Duck("唐老鸭",12));
        func1(new Dog("二狗子",3));
        func1(new Frog("红烧的",1));
    }
}
