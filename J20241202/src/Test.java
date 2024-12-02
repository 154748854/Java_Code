import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //输入一个数字，顺序打印每一位
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n != 0) {
            System.out.println(n % 10);
            n /= 10;
        }
    }
    public static void main3(String[] args) {
        print(123);
    }
    public static void print(int n) {
        if(n < 10) {
            System.out.println(n%10);
            return;
        }
        print(n/10);
        System.out.println(n%10);
    }





    //求n的阶乘
    public static int fac(int n) {
        int ret = 1;
        for (int i = 1; i <= n; i++) {
            ret *= i;
        }
        return ret;
    }
    //求k的阶乘的和
    public static int facSum(int k) {
        int sum = 0;
        for (int i = 1; i <= k; i++) {
            sum +=fac(i);
        }
        return sum;
    }
    public static void main2(String[] args) {
        System.out.println(facSum(5));
        System.out.println(facSum(3));
    }
    public static void main1(String[] args) {
        int n  = 7;
        for (int i = 31; i >= 0; i-=2) {
            System.out.print(((n >>> i)&1)+" " );
        }
        System.out.println();
        for (int i = 30; i >= 0; i-=2) {
            System.out.print(((n >>> i)&1)+" " );
        }
    }
}
