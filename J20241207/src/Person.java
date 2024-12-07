public class Person {
    private String name;
    private int age;

    public Person() {
        System.out.println("不带参数的构造方法");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("带两个参数的构造方法");
    }
    public String gerName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sleep() {
        System.out.println(this.name+"在睡觉");
    }

}
