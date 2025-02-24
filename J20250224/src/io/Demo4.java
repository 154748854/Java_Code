package io;

import java.io.File;
import java.util.Arrays;

public class Demo4 {
    public static void main(String[] args) {
        File file = new File("d:/");
        File[] ret = file.listFiles();
        System.out.println(Arrays.toString(ret));
    }
}
