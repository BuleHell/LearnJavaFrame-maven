package com.cn;

import com.cn.Demo1.test1;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class test1Test {
    private test1 t;

    @Before
    public void setup() {
        System.out.println("初始化开始");
        t = new test1();
    }

    @Test
    public void addTest() {
        System.out.println("test add");
        int sum = t.add(3, 4);
        Assert.assertEquals(sum, 7);
    }

    @Test
    public void subTest() {
        System.out.println("test sub");
        int sum = t.sub(3, 4);
        Assert.assertEquals(sum, -1);
    }



    @After
    public void down() {
        System.out.println("运行已结束");
    }

}
