package com.dazhaung.family.base.server.service.impl;

import com.dazhaung.family.base.common.BoyThreadPoolExecutor;
import com.dazhaung.family.base.server.po.RequestTaskPO;
import com.dazhaung.family.base.server.service.WebServer;
import com.dazhaung.family.base.utils.PropertiesUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class WebServerImpl implements WebServer {
    public static int port = 8080;
    public void start() {
        //初始化serverSocket
        try {
            ServerSocket serverSocket = new ServerSocket(getPort());
            BoyThreadFactory threadFactory = new BoyThreadFactory();

            ExecutorService executorService = BoyThreadPoolExecutor.newThreadPool();
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

    public static int getPort() {
        String value  = PropertiesUtils.getStr("sever.port");
        if (StringUtils.isNotBlank(value)) {
            return Integer.valueOf(value);
        }
        return port;
    }
}
