package basic_java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chaiyuze
 * @since 2018/10/8
 */
public class Concurrent {

    /**
     * 创建线程池的相关内容，包括：
     *
     * 线程池的增长策略和拒绝策略
     * 线程工厂
     */
    public static void threadPool() {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                //线程池维护线程的最少数量，即使线程池中的线程都处于空闲状态，也要创建足够的线程
                //如果线程数量等于 corePoolSize，但是 BlockingQueue 未满，则任务被放入缓冲队列
                //如果线程数量小于 maximumPoolSize，而所有线程的 BlockingQueue 都已满，则会创建新的线程来处理添加的任务
                1,
                2,

                //线程数量超过 corePoolSize 时，如果某线程的空闲时间超过 keepAliveTime，则线程会被终止
                10,
                TimeUnit.SECONDS,

                //用于存储任务的并发容器，必须为 BlockingQueue<Runnable>
                new LinkedBlockingQueue<>(100),

                //创建线程的工厂
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return null;
                    }
                },

                //任务拒绝策略：当线程数量达到 maximumPoolSize，而所有线程的 BlockingQueue 都已满，则在添加新任务时会执行以下方法
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

                    }
                }
        );

        /* juc中实现的任务拒绝策略 */
        //中断（抛出了异常）
        new ThreadPoolExecutor.AbortPolicy();
        //抛弃将要添加的任务（实现中，什么都不需要做）
        new ThreadPoolExecutor.DiscardPolicy();
        //抛弃最初始的任务（实现中，将队列头的任务剔除，再提交当前任务；
        // 然而这个任务有可能提交不进去，因为刚空出的位置可能会被抢占;
        // 同时注意剔除的是队列头的任务，而不是正在执行的任务）
        new ThreadPoolExecutor.DiscardOldestPolicy();
        //交由调用方执行（直接暴力执行了 Runnable.run() 方法）
        new ThreadPoolExecutor.CallerRunsPolicy();

        /* juc中实现的线程工厂类 */
        //todo
        Executors.defaultThreadFactory();
        Executors.privilegedThreadFactory();

    }


    public static void concurrentCollection() {

        //juc 中 synchronizedXXX 的祖宗之一
        //注意：这个类的【迭代器】以及【Stream】都是不支持并发操作的
        Collection c = Collections.synchronizedCollection(new HashSet<>());
    }

    /**
     * 并发juc--List容器
     */
    public static void concurrentList() {

        //
        CopyOnWriteArrayList cowL = new CopyOnWriteArrayList<>();

        //非常暴力膜的一款并发List容器，实际上就是对每个操作进行 mutex 同步
        List l = Collections.synchronizedList(new ArrayList<>());
    }

    public static void concurrentMap() {

    }

    public static void concurrentQueue() {

    }

}
