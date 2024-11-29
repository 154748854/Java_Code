import java.util.Random;
import java.util.Scanner;//导包
public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        int randNum = random.nextInt(bound:100);
        Scanner scaner = new Scanner(System.in);
        while(true) {
            System.out.println();
        }
    }
    public static void main7(String[] args) {
        Scanner scaner = new Scanner(System.in);

        while(scaner.hasNextInt()) {
            int a = scaner.nextInt();
            System.out.println(a);
        }

    }
    public static void main16(String[] args) {
        Scanner scaner = new Scanner(System.in);

        System.out.println("请输入年龄");
        int age = scaner.nextInt();
        System.out.println(age);

        scaner.nextLine();

        System.out.println("清输入姓名");
        String name = scaner.nextLine();
        System.out.println(name);


       /* for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
    public static void main9(String[] args) {
        int i = 1;
        while (i <= 100) {
           if (i % 15 != 0) {
               i++;
               continue;
           }
            System.out.println(i);
           i++;
        }*/


       /* int x = 10;
        int y = 2;
        System.out.println(x/++y);*/
    }
    public static void main5(String[] args) {
        int n = 1;
        int i = 1;
        int sum = 0;
        int ret = 1;

        while (i <= 5) {
            while (n <= i) {
                ret *= n;
                n++;
            }
            sum += ret;
            i++;
        }
        System.out.println(sum);

        while (n <= 5) {
            ret *= n;
            n++;
            sum += ret;
        }
        System.out.println(sum);
    }
    public static void main6(String[] args) {
        int a = 1;
        int sum = 0;
        while (a <= 100) {
            sum += a;
            a++;
        }
        System.out.println(sum);

        //1~100奇数的和
        int sumOdd = 0;
        a = 1;
        while (a <= 100) {
            sumOdd += a;
            a += 2;
        }
        System.out.println(sumOdd);


        //1~100偶数的和





        /*int x = 10;
        if(x == 10) {
            //语句
        }else {
            //语句
        }*/
    }
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        if(year % 100 == 0) {
            if(year % 400 == 0) {
                System.out.println("世纪闰年");

            }else {
                System.out.println("不是闰年");
            }
        }else{
            if(year % 4 == 0) {
                System.out.println("普通闰年");
            }else {
                System.out.println("不是闰年");
            }

        }



        /* int a = 10;
        if(a == 10) {

        }
        System.out.println("aaa");
        System.out.println("bbb");
        System.out.println("ccc");*/
    }
}
