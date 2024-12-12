class Animal {
    public String name;
    public int age;

    public void eat() {
        System.out.println(this.name+"在吃饭");
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
class Dog extends Animal {
    public Dog(String name,int age) {
        //帮助初始化了子类从父类继承下来的成员
        super(name,age);
    }
    public void bark() {
        System.out.println(this.name+"汪汪叫");
    }
}
public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog("圆圆",19);
    }
}
