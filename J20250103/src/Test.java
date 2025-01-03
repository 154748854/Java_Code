/*class MyArray <T> {
    //<T> 代表当前类是一个泛型类，<T>只是一个占位符
    //将来我们传类型的时候，就可以用它来接收
    //public T[] array = new T[10];不能new泛型对象
    public Object[] array = new Object[10];
    public void setValue(int pos, T val) {
        array[pos] = val;
    }
    public T getValue(int pos) {
        return (T)array[pos];
        //把返回的类型强转为 指定类型
    }
}
class TestGeneric<T extends Number> {

}
class Person {

}
class Student extends Person {

}
class TestGeneric2<T extends Person> {

}*/


public class Test {
    /*public static void main(String[] args) {
        TestGeneric2<Student> testGeneric2 = new TestGeneric2<>();
        //Student 属于 （Person类 或者 Person的子类）
    }
    public static void main2(String[] args) {
        TestGeneric<Number> testGeneric1 = new TestGeneric<>();
        TestGeneric<Integer> testGeneric2 = new TestGeneric<>();
        TestGeneric<Double> testGeneric3 = new TestGeneric<>();

        TestGeneric<String> testGeneric4 = new TestGeneric<>();//报错
    }
    public static void main1(String[] args) {
        //通过尖括号去传类型
        MyArray<Integer> myArray = new MyArray<>();
        myArray.setValue(0,1);
        int a = myArray.getValue(0);
        System.out.println(a);

        //想传String类型，我们再新建一个MyArray对象即可
        MyArray<String> myArray1 = new MyArray<>();
        myArray1.setValue(0,"hello");
        String ret = myArray1.getValue(0);
        System.out.println(ret);
        //我们之所以学包装类的原因就是泛型传类型的时候不能传基本数据类型，需要传包装类型或引用类型
    }*/
}
