package com.dazhaung.family.base.common;

import com.dazhaung.family.base.utils.PropertiesUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BoyThreadPoolExecutor extends ThreadPoolExecutor {

    //默认核心线程数
    private static int boyCorePoolSize = 0;
    //默认最大工作线程数
    private static int boyMaximumPoolSize = Integer.MAX_VALUE;
    //空闲线程存活时间
    private static long boyKeepLiveTime = 60L;
    //默认时间单位
    private static TimeUnit boyTimeUnit = TimeUnit.SECONDS;
    //线程池等待队列最大队列数
    private static int boyCapacity = Integer.MAX_VALUE;

    public static int getBoyCorePoolSize() {
        String resourceCorePoolSize = PropertiesUtils.getStr("threadpool.corePoolSize");
        if (StringUtils.isNotBlank(resourceCorePoolSize)) {
            return Integer.valueOf(resourceCorePoolSize);
        }
        return boyCorePoolSize;
    }

    public static int getBoyMaximumPoolSize() {
        String resourceMaximumPoolSize = PropertiesUtils.getStr("threadpool.maximumPoolSize");
        if (StringUtils.isNotBlank(resourceMaximumPoolSize)) {
            return Integer.valueOf(resourceMaximumPoolSize);
        }
        return boyMaximumPoolSize;
    }

    public static long getBoyKeepLiveTime() {
        String resourceKeepLiveTime = PropertiesUtils.getStr("threadpool.keepLiveTime");
        if (StringUtils.isNotBlank(resourceKeepLiveTime)) {
            return Long.valueOf(resourceKeepLiveTime);
        }
        return boyKeepLiveTime;
    }

    public static int getBoyCapacity() {
        String resourceCapacity = PropertiesUtils.getStr("threadpool.workQueue.capacity");
        if (StringUtils.isNotBlank(resourceCapacity)) {
            return Integer.valueOf(resourceCapacity);
        }
        return boyCapacity;
    }

    public static void setBoyCapacity(int boyCapacity) {
        BoyThreadPoolExecutor.boyCapacity = boyCapacity;
    }

    public BoyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    //静态内部类实现单例模式
    private static class BoyThreadPoolExecutorSington {
        private final static BoyThreadPoolExecutor boyThreadPoolExecutor = new BoyThreadPoolExecutor(getBoyCorePoolSize(), getBoyMaximumPoolSize(), getBoyKeepLiveTime(), boyTimeUnit,
                new LinkedBlockingDeque<Runnable>(getBoyCapacity()));
    }

    public static BoyThreadPoolExecutor newThreadPool() {
        return BoyThreadPoolExecutorSington.boyThreadPoolExecutor;
    }
}
