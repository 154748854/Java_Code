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

import java.util.Arrays;

class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name+" "+this.age;
    }
}
public class Test {
    public static void main(String[] args) {
        String str = "ababc";
        //写两个参数就是左闭右开区间
        String ret = str.substring(0,3);// [0.3)
        System.out.println(ret);//aba

        //写一个参数就是从下标几开始截取
        String ret2 = str.substring(3);
        System.out.println(ret2);//bc
    }
    public static void main8(String[] args) {
        String s = "name=lisi&age=12";
        String[] ret = s.split("=|&");
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }
    }
    public static void main7(String[] args) {
        String str = "hello 123 world";
        String[] ret1 = str.split(" ");//按照什么划分，这里就写什么
        for (int i = 0; i < ret1.length; i++) {
            System.out.println(ret1[i]);
        }

        String[] ret2 = str.split(" ",2);//加上后面的数字就是拆分为几组；
        for (int i = 0; i < ret2.length; i++) {
            System.out.println(ret2[i]);
        }
    }
    public static void main6(String[] args) {
        String s = "abcdeabfabpi";
        String ret = s.replace("ab","ooo");
        System.out.println(ret);

        String ret2 = s.replace('a','8');
        System.out.println(ret2);

        //替换收个位置
        String ret3 = s.replaceFirst("ab","ppp");
        System.out.println(ret3);

        String ret4 = s.replaceAll("ab","123");
        System.out.println(ret4);
       /* String s = String.format("%d-%d-%d", 2025, 1, 4);
        System.out.println(s);*/
        //字符串转数组
        /*String s = "hello";
        char[] ch = s.toCharArray();
        System.out.println(Arrays.toString(ch));

        //数组转字符串
        char[] s1 = {'a','b','c'};
        String s2 = new String(s1);
        System.out.println(s2);*/
    }
    public static void main5(String[] args) {
        String s = "hello";
        //转变为大写不是在原来的基础上转变，而是转变成大写后是一个新的对象
        String ret = s.toUpperCase();
        System.out.println(ret);

        String s1 = "HELLO";
        //转变为小写也是同理
        String ret2 = s1.toLowerCase();
        System.out.println(ret2);
       /* int data = Integer.parseInt("198");
        System.out.println(data);*/
       /* String s = String.valueOf(19.9);
        System.out.println(s);

        String s1 = String.valueOf(new Student("Hanmeimei", 18));
        System.out.println(s1);*/
    }
    /*public static void main(String[] args) {
        String s2 = "hello";
        int index1 = s2.lastIndexOf('l');
        System.out.println(index1);//3

        int index2 = s2.lastIndexOf('l',2);
        System.out.println(index2);//2

        String s1 = "acabcbcabc";
        int index3 = s1.lastIndexOf("abc");
        System.out.println(index3);//7

        int index4 = s1.lastIndexOf("abc",4);
        System.out.println(index4);//2


    }*/
    public static void main3(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("acd");
        System.out.println(s1 == s2);
        //== 比较的是两个变量中存放的地址，所以结果是false

        //要比较值一不一样，使用的是equals方法
        System.out.println(s1.equals(s2));//比较内容，true

        //equals返回值是boolean类型的，如果我们想比较两个字符串的大小呢
        //String是实现了comparable接口的，它重写了compareTo方法

        /**
         * s1和s2 进行比较
         * 如果s1大于s2，则返回正数
         * 如果s1等于s2，返回0
         * 如果s1小于s2，返回负数
         */
        System.out.println(s1.compareTo(s2));

        /**
         * 忽略大小写进行比较
         */
        System.out.println(s1.compareToIgnoreCase(s2));
    }
    public static void main1(String[] args) {
        String str4 = "";
        String str5 = null;
    }
    public static void main2(String[] args) {
        //1. 使用常量串构造
        String str1 = "hello";
        System.out.println(str1);

        //2. 直接new String 对象
        String str2 = new String("pppp");
        System.out.println(str2);

        //3. 使用字符数组进行构造
        char[] array = {'a', 'b', 'c'};
        String str3 = new String(array);
        System.out.println(str3);

        String str4 = new String(array,0,1);
        //从0位置拿1个
        System.out.println(str4);


    }
    /*public static void main(String[] args) {
        //"hello" 就是字符串常量, 没有\0 标记结尾
        String str = "hello";
        //这里之所以不输出str的地址是因为String重写了toString方法
        System.out.println(str);
    }*/
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
    //头好痛。学太久了，好痛苦
}
