package top.amfun.quickinit.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhaoxg
 * @date 2022/1/4 17:00
 */
@Getter
@Setter
public class PageRequest {
    private static final int DEFAULT_PAGE = 1;
    private static final int DEFAULT_SIZE = 10;

    private int page = DEFAULT_PAGE;
    private int pageSize = DEFAULT_SIZE;
}
