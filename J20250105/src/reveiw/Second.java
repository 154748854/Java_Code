package reveiw;

import java.util.Random;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        //递归
        //递归求n的阶乘
        int p = 3;
        int ret = factor(p);
        System.out.println(ret);
    }

    public static int factor(int p) {
        if(p == 1) return 1;
        else return p *= factor(p-1);
    }
    //方法名必须相同，参数列表必须不同，与返回类型无关无关
    //方法签名，方法中变量不可以重名，但是方法名可以重复，原因是编译器修改后的最终方法名是方法名 参数列表 返回类型钩秤完整的方法名

    public static void main2(String[] args) {
        //形参和实参相当于传值调用，要想解决，传引用类型的参数
        int arr[] = new int[]{10, 20};
        swap(arr);
        System.out.println("arr[0] = "+arr[0]+"arr[1] = "+arr[1]);
        //方法中不能写方法，不可以嵌套方法
    }
    public static void swap(int arr[]) {
        int tem = arr[0];
        arr[0] = arr[1];
        arr[1] = tem;
    }



    public static void main3(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int toGuess = random.nextInt(100);
        while (true) {
            System.out.println("输入你猜的数字：");
            int num = scanner.nextInt();
            if(num < toGuess) {
                System.out.println("低了");
            }else if (num > toGuess) {
                System.out.println("高了");
            }else {
                System.out.println("猜对了");
                break;
            }
        }
        scanner.close();
    }
   /* public static void main(String[] args) {
        //continue
        int num = 100;
        while(num <= 200) {
            if(num % 3 != 0) {
                num++;
                continue;
            }
            System.out.println(num);
            num++;
        }
    }*/
        //break
       /* int num = 100;
        while (num <= 200) {
            if(num % 3 == 0) {
                System.out.println("找到了3的倍数，是"+num);
                break;
            }
            num++;
        }
    }*/
    public static void main1(String[] args) {
        //switch语句
        int day = 7;
        switch(day) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 6:
                System.out.println("周末");
            case 7:
                System.out.println("周末");
                break;
        }
        /*int a = 10;
        int b = 10;
        if(a == 20)
            if(b == 10)
                System.out.println("aaa");
        else System.out.println("bbb");*/
        //悬垂else问题
    }
}
