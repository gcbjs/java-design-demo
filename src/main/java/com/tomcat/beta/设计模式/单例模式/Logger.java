package com.tomcat.beta.设计模式.单例模式;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 处理资源访问冲突
 * 构造函数需要是 private 访问权限的，这样才能避免外部通过 new 创建实例;
 * 考虑对象创建时的线程安全问题;
 * 考虑是否支持延迟加载;
 * 考虑 getInstance() 性能是否高(是否加锁)。
 * Create by yuzhangbin on 2020/9/17
 */
public class Logger {
    private FileWriter writer;

    private static final Logger instance = new Logger();

    private Logger(){
        File file = new File("test.txt");
        try{
            writer = new FileWriter(file,true);
        }catch (IOException e) {
            System.out.println("系统异常");
        }
    }

    public static Logger getInstance() {
        return instance;
    }

    public void log(String message) {
        try{
            writer.write(message);
        }catch (IOException e) {
            System.out.println("系统异常");
        }finally {
            if (writer !=null) {
                try{
                    writer.close();
                }catch (IOException e) {

                }
            }
        }
    }
}
