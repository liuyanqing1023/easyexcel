package com.alibaba.easyexcel.test.util;

import java.io.File;
import java.io.InputStream;

public class TestFileUtil {


    public static InputStream getResourcesFileInputStream(String fileName) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream("" + fileName);
    }

    public static String getPath() {
        return TestFileUtil.class.getResource("/").getPath();
    }

    public static File createNewFile(String pathName) {
        File file = new File(getPath() + pathName);
        if (file.exists()) {
            file.delete();
        } else {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
        }
        return file;
    }

    public static File readFile(String pathName) {
        return new File(getPath() + pathName);
    }

    public static File readUserHomeFile(String pathName) {
        return new File(System.getProperty("user.home") + File.separator + pathName);
    }


    public static void main(String[] args) {
        String str = "aplus+%282%29%E5%A4%A7%E6%96%87%E4%BB%B6%E7%9A%84%E5%89%AF%E6%9C%AC.xlsx";
        System.out.println(str.lastIndexOf("."));
        System.out.println(str.substring(0,str.lastIndexOf(".")));
    }
}
