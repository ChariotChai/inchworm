package java.concurrency.threads;

/**
 * @author chaiyuze
 * @since 2018/12/24
 */
public class Threads {

    void aboutThreadStates() {

        Thread.State.NEW.name();
        Thread.State.RUNNABLE.name();
        Thread.State.BLOCKED.name();
        Thread.State.WAITING.name();
        Thread.State.TIMED_WAITING.name();
        Thread.State.TERMINATED.name();

    }

}
