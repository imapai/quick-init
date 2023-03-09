package top.amfun.quickinit.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author zhaoxg
 * @date 2023/2/23 17:20
 */
@Component
public class TestAsync {

    @Async
    public void go() {
        int sum = 0;
        System.out.println("当前线程" + Thread.currentThread().getName() + "，线程睡眠，当前时间：" + LocalDateTime.now());
        try {
//            for (int i = 0; i <1000000; i++) {
//                sum += i;
//            }
            Thread.sleep(500);
            System.out.println("当前线程" + Thread.currentThread().getName() + "，睡眠后的时间，当前时间：" + LocalDateTime.now());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
