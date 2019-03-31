package com.murdock.books.understanding.java7;

/**
 * @author weipeng2k 2016年10月30日 下午20:58:29
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class clazz = Init.class;
        System.out.println(clazz);
        clazz.getMethods();
        System.out.println("init");
        clazz.newInstance();
        Integer i = null;

        print(i);

    }

    public static void print(Integer i) {
        switch (i) {
            case 1:
                System.out.println("1");
                break;
            default:
                System.out.println("not 1");
                break;
        }
    }
}
