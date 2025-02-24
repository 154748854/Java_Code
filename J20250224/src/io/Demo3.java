package io;

import java.io.File;

public class Demo3 {
    public static void main(String[] args) {
        File f = new File("d:/test.txt");
        boolean ret = f.delete();
        System.out.println(ret);
    }
}
