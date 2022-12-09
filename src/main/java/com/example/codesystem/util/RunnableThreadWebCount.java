package com.example.codesystem.util;

import java.util.HashMap;

/**
 * @author cc
 * @date 2022年12月09日 18:03
 */
public class RunnableThreadWebCount implements  Runnable{
    private static HashMap<String, Integer> map = new HashMap<>();

    @Override
    public void run() {
        System.out.println("计数线程已经启动.....");
        map.put(new String("111"), 0);
    }
    public static void showthread(){
        // System.out.println("计数线程启动中.....");
    }

    public  static int addCount(String key){
        Integer count = map.get(key);
        if(count == null){
            return 0;
        }
        count++;
        map.put(key, count);
        System.out.println("网站访问人数：" + count);
        return count;
    }
}
