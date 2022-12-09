package com.example.codesystem;

import com.example.codesystem.util.RunnableThreadWebCount;
import com.example.codesystem.util.Timers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CodeSystemApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CodeSystemApplication.class, args);
        RunnableThreadWebCount runnableThreadWebCount = new RunnableThreadWebCount();
        runnableThreadWebCount.run();
        //计时器线程
        Timers timers = new Timers();
        timers.run();
    }

}
