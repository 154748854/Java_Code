class Person implements Cloneable{
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Money {
    

}
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException{
        Person person = new Person("张三",10);
        Person person2 = (Person)person.clone();//clone
    }
}
