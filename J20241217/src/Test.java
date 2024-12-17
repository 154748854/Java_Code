/*class Tyre {

}
class Car {
    private Tyre tyre;//组合
}
class Benz extends Car {

}*/

import java.sql.SQLOutput;

class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }
    public void eat() {
        System.out.println(this.name+"吃饭");
    }
}
class Dog extends Animal{
    public Dog(String name) {
        super(name);//子类对象构造时，需要先调用父类构造方法
    }
    @Override
    public void eat() {//子类必须对父类中的方法进行重写
        System.out.println(this.name+"吃狗粮");
    }
}
public class Test {
    public static void eat(Animal a) {
        a.eat();//通过父类Animal对象的引用a
        //调用子类Dog中重写的方法(传过来的是Dog类对象dog)
    }

    public static void main(String[] args) {
        Dog dog = new Dog("小七");
        eat(dog);
    }
}
