public class Test {
    public static void main(String[] args) {
        int a = 10;
        Integer aa = a;
        System.out.println(a);
    }
    public static void main2(String[] args) {
        Integer a = 10;
        int aa = a.intValue();//显式拆箱
        System.out.println(aa);

        Integer b = 20;
        int bb = b;
        System.out.println(b);

    }
    public static void main1(String[] args) {
        int i = 10;
        Integer aa = Integer.valueOf(10);//显式装箱


    }
    //学了sql，发现要学B+树，还是先补数据结构吧
}
