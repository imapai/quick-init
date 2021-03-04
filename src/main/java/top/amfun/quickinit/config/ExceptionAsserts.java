package top.amfun.quickinit.config;

import com.baomidou.mybatisplus.extension.exceptions.ApiException;

public class ExceptionAsserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }
}
