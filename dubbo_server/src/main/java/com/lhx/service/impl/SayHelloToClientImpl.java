package com.lhx.service.impl;

import com.lhx.service.SayHelloToClient;

/**
 * Created by fengluo
 */
public class SayHelloToClientImpl implements SayHelloToClient{

    public String sayHello(String hello){
        System.out.println("我接收到了：" + hello);
        return hello + "你也好啊！！！" ;
    }

}
