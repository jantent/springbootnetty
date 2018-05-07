package com;

import com.server.NettyTcpServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;

@SpringBootApplication
@ComponentScan
public class StartApplication {


    public static void main(String args[])throws Exception{
        SpringApplication.run(StartApplication.class,args);
    }

}
