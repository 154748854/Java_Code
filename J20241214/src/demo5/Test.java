package demo5;

import java.util.Comparator;

class Student{//表示当前的类是可以进行比较的
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //@Override
    /*public int compareTo(Student o) {
        if(this.age > o.age) {
            return 1;
        }else if(this.age == o.age) {
            return 0;
        }else {
            return -1;
        }

    }*/

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

//比较器
class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}
class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}
public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("张三",10);
        Student student2 = new Student("李四",4);
       // System.out.println(student1.compareTo(student2));

        AgeComparator ageComparator = new AgeComparator();
        System.out.println(ageComparator.compare(student1, student2));

        NameComparator nameComparator = new NameComparator();
        System.out.println(nameComparator.compare(student1, student2));
    }

}
