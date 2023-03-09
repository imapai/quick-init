package top.amfun.quickinit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.amfun.quickinit.async.TestAsync;
import top.amfun.quickinit.common.RestResponse;

/**
 * @author zhaoxg
 * @date 2022/11/14 19:59
 */
@RestController
@RequestMapping("/noauth")
public class TestController {
    @Autowired
    private TestAsync testAsync;

    @GetMapping("/async")
    RestResponse testAsync() {
        //testAsync.go();
        try {
            Thread.sleep(23);
            System.out.println("打印当前线程名称：" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return RestResponse.success(1);
    }
}
