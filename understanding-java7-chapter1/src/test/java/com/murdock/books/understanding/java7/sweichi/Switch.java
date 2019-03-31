package com.murdock.books.understanding.java7.sweichi;

import org.junit.Test;

/**
 * @author weipeng2k 2016年11月24日 下午22:56:41
 */
public class Switch {

    @Test
    public void stringValue() {
        String s = "哈哈";

        switch (s) {
            case "男":
                System.out.println("男");
                break;
            case "女":
                System.out.println("女");
                break;
            case "哈哈":
                System.out.println("哈哈");
                break;
        }
    }
}
