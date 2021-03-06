package com.alibaba.dubbo.demo.consumer;

import com.alibaba.dubbo.demo.DemoService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ken.lj on 2017/7/31.
 */
public class Consumer {

    public static void main(String[] args) {
        System.setProperty("java.net.preferIPv4Stack", "true"); //防止无线网络自动返回IPv6地址
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-demo-consumer.xml"});
        context.start();

        DemoService demoService2 = (DemoService) context.getBean("demoService2"); // 获取远程服务代理
        DemoService demoService1 = (DemoService) context.getBean("demoService1"); // 获取远程服务代理
        String hello = demoService1.sayHello("world"); // 执行远程方法
        String hello2 = demoService2.sayHello("world"); // 执行远程方法

        System.out.println(hello); // 显示调用结果
    }
}
