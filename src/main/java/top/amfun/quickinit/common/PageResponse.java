package top.amfun.quickinit.common;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageResponse<T> {
    private Integer page;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> items;

    public PageResponse() {}

    public PageResponse(List<T> items, Long total, Integer page, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalPage = Convert.toInt(total/pageSize + 1);
        this.total = total;
        this.items = items;
    }

    /**
     * 将MyBatis Plus 分页结果转化为通用结果
     */
    public static <T> PageResponse<T> restPage(Page<T> pageResult) {
        PageResponse<T> result = new PageResponse<>();
        result.setPage(Convert.toInt(pageResult.getCurrent()));
        result.setPageSize(Convert.toInt(pageResult.getSize()));
        result.setTotal(pageResult.getTotal());
        result.setTotalPage(Convert.toInt(pageResult.getTotal()/pageResult.getSize()+1));
        result.setItems(pageResult.getRecords());
        return result;
    }
}
