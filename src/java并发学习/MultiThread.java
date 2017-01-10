package java并发学习;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by h on 17-1-8.
 */
public class MultiThread {
    public static void main(String[] args) {
        ThreadMXBean tm = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = tm.dumpAllThreads(false, false);
        for (ThreadInfo ti :
                threadInfos) {
            System.out.println(ti.getThreadId() + "   " + ti.getThreadName());
        }
    }
}
