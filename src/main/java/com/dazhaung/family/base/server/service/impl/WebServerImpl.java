package com.dazhaung.family.base.server.service.impl;

import com.dazhaung.family.base.server.po.RequestTaskPO;
import com.dazhaung.family.base.server.service.WebServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class WebServerImpl implements WebServer {
    public static int port = 8080;
    public static int corePoolSize = 0;
    public static int maximumPoolSize = Integer.MAX_VALUE;
    public static long keepLiveTime = 60L;
    public static TimeUnit timeUnit = TimeUnit.SECONDS;
    //线程池等待队列最大队列数
    public static int capacity = Integer.MAX_VALUE;


    public void start() {
        //初始化serverSocket
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            BoyThreadFactory threadFactory = new BoyThreadFactory();
            ExecutorService executorService = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepLiveTime, timeUnit, new LinkedBlockingDeque<Runnable>(capacity),threadFactory);
            while (true) {
                Socket socket = serverSocket.accept();
                RequestTaskPO requestTaskPO = new RequestTaskPO(socket);
                Thread thread = threadFactory.newThread(requestTaskPO, new BoyUncatchExceptionHandler());
                executorService.submit(thread);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class BoyThreadFactory implements ThreadFactory {
        Thread thread;
        @Override
        public Thread newThread(Runnable r) {
            this.thread = new  Thread(r);
            return thread;
        }

        public Thread newThread(Runnable r, BoyUncatchExceptionHandler uncaughtExceptionHandler) {
            this.thread = new Thread(r);
            this.thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            return thread;
        }
    }

    class BoyUncatchExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("异常处理方法调用");
            e.printStackTrace();
        }
    }



}
