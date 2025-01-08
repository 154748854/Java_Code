import java.util.Random;
import java.util.Scanner;

class Base {
    int a = 1;
    int b = 2;
    public void methodA() {
        System.out.println(a);
    }
}
class Derive extends Base {
    int a = 10;
    int b = 20;
    public void methodC() {
        a = 100;
        //super获取的是子类从父类中继承下来的部分
        //并不是直接操作父类成员
        //想修改父类的成员只能用在父类中去写一些方法
        super.a = 200;
        System.out.println(this.a+" "+super.a);
    }
}

public class Test {
    public static void main(String[] args) {
        Base base = new Base();
        base.methodA();
        Derive derive = new Derive();
        derive.methodC();
    }
    public static void main4(String[] args) {
        int[] array = {1,2,34,3,4,5,6,23,12};
        boolean flg = B(array);
        System.out.println(flg);
    }
    public static boolean B(int[] array) {
        int flg = 0;
        for (int j : array) {

            if (j % 2 == 0) flg = 0;
            else flg++;
            if (flg >= 3) break;
        }
        return flg >= 3;
    }
//    public static void main3(String[] args) {
//        int[] array ={2,2,1,1,1,2,2};
//        A(array);
//    }
//    public static int A(int[] array) {
//        for (int i = 1; i < array.length; i++) {
//            int flg = 1;
//            for (int j = 0; j < array.length; j++) {
//                if(array[i] == array[j]) flg++;
//            }
//        }
//    }
    public static void main2(String[] args) {
        String password = "12345567";
        Scanner scanner = new Scanner(System.in);
        String ste = scanner.next();
        int flg = 4;
        while(flg > 0) {
            if(ste.equals(password)) {
                System.out.println("正确");
                break;
            }else flg--;
        }
    }
    public static void main1(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int to = random.nextInt(100);

        while (true) {
            //guess要写在while内部，是为了每一次进入循环都可以重新设置guess的值
            int guess = scanner.nextInt();
            if(guess > to) {
                System.out.println("大了");
            }
            else if(guess < to) {
                System.out.println("小了");
            }
            else {
                System.out.println("猜对了");
                break;
            }
        }
        scanner.close();
    }
}
