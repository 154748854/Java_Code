package io;

import java.io.File;

public class Demo5 {
    public static void main(String[] args) {
        File f = new File("d:/Java109");
        boolean ret = f.mkdir();
        System.out.println(ret);
    }
}
