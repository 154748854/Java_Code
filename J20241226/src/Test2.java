class OuterClass {
    public int data1 = 1;
    public static int data2 = 2;
    private int data3 = 3;
    class InnerClass {
        public int data1 = 111;
        public int data4;
        public static final int data5 = 5;//编译的时候就确定了
        private int data6 = 6;
        public void test() {
            System.out.println("InnerClass:: test()"+data5);
            System.out.println(data1);
            System.out.println(OuterClass.this.data1);
            System.out.println(data2);
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(data5);
            System.out.println(data6);
        }
    }
    public void test() {
        System.out.println("OuterClass: :test()");
    }
}
class Out {
    public int data1 = 10;
    public static int data2 = 2;
    private int data3 = 3;

    static class InnerClass {
        public int data4 = 4;
        public static int data5 = 5;
        private int data6 = 6;

        public void test() {
            Out out = new Out();
            System.out.println(out.data1);
            System.out.println("InnerClass");
        }
    }

    public void test() {
        System.out.println("Out");
    }
}
interface IA {
    void test();
}
public class Test2 {
    public static void main(String[] args) {
    new IA() {
        @Override
        public void test() {
            System.out.println("这是重写了接口的方法");
        }
    }.test();


    }

    public void func() {
        class AA {
            public int a;
        }
    }
    public static void main3(String[] args) {
        Out.InnerClass innerClass = new Out.InnerClass();
        innerClass.test();
    }
    public static void main1(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.test();
    }
}
