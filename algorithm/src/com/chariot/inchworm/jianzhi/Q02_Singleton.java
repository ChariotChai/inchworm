package com.chariot.inchworm.jianzhi;

/**
 * 题目02
 * 单例
 */
public class Q02_Singleton {

    /**
     * 单线程版本
     * 不好的实现（存在并发问题）
     */
    public static class SingletonSingleThread {

        /**
         * 构造函数私有化
         */
        private SingletonSingleThread() {
        }

        private static SingletonSingleThread instance = null;

        /**
         * “懒汉式”加载，仅在获取类实例时才会构造对象
         * 隐患：如果并发调用该方法，仍然可能创建多个实例
         * @return
         */
        public static SingletonSingleThread getInstance() {
            if (instance == null) {
                instance = new SingletonSingleThread();
            }
            return instance;
        }
    }

    /**
     * 支持并发的版本
     * 不好的实现（存在效率问题）
     */
    public static class SingletonConcurrent {

        private SingletonConcurrent() {
        }

        private static SingletonConcurrent instance = null;

        private final static Object lock = new Object();

        public static SingletonConcurrent getInstance() {
            //这个锁在创建对象后就没有存在的意义了
            synchronized (lock) {
                if (instance == null) {
                    instance = new SingletonConcurrent();
                }
            }
            return instance;
        }
    }

    /**
     * 双检锁版本
     */
    public static class SingletonDuelCheck {

        private SingletonDuelCheck() {
        }

        private static SingletonDuelCheck instance = null;

        private final static Object lock = new Object();

        public static SingletonDuelCheck getInstance() {
            //是上面那种低效版本的改良
            if (instance == null) {
                synchronized (lock) {
                    if (instance == null) {
                        instance = new SingletonDuelCheck();
                    }
                }
            }
            return instance;
        }
    }

    /**
     * 饿汉式加载版本
     * 不管用没用到都先初始化
     */
    public static class SingletonStatic {

        private SingletonStatic() {
        }

        private static final SingletonStatic instance = new SingletonStatic();

        public static SingletonStatic getInstance() {
            return instance;
        }
    }

    /**
     * 内部类版本
     * 加载该类后，未必会加载内部类（仅在调用方法时才会创建内部类），做到“按需创建”
     */
    public static class SingletonNested {

        private SingletonNested() {
        }

        private static class Nested {
            private static final SingletonNested instance = new SingletonNested();
        }

        public static SingletonNested getInstance() {
            return Nested.instance;
        }
    }

    /**
     * 枚举类版本
     */
    public enum SingletonEnum {

        instance,;

    }

}
