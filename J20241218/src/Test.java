class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }
    public void eat() {
        System.out.println(this.name+"在吃东西");
    }
}
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    public void bark() {
        System.out.println(this.name+"在汪汪叫");
    }

    @Override
    public void eat() {
        System.out.println(this.name+"在吃狗粮");
    }
}
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    public void miaomiao() {
        System.out.println(this.name+"在喵喵叫");
    }
}
public class Test {
    //3.作返回值
    public static Animal buyAnimal(String var) {//这里返回类型是Animal
        if("狗".equals(var)) {
            return new Dog("狗狗");//返回一个子类对象，用父类接收
        }else {
            return null;
        }
    }
   /* public static void eatFood(Animal a) {//2.方法传参：用父类对象的引用去指向子类的对象
        a.eat();
    }
    //Animal animal = new Dog("小七");//1.直接赋值
    Dog dog = new Dog("小七");
    Animal animal = dog;
    dog = (Dog)animal;*/
   public static void main(String[] args) {
       Dog dog = new Dog("小七");
       Cat cat = new Cat("小咪");
       Animal animal = dog;//向上转型
       dog = (Dog)animal;//向上转型后向下转型
       dog.bark();//向下转型后就可以通过dog去调用Dog类中特有的方法了
       if(animal instanceof Cat) {
           cat = (Cat)animal;
           cat.miaomiao();
       }
   }

}
