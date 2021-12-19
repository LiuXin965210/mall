package com.lx.mall.api;

import com.github.pagehelper.PageInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.val;
import org.springframework.data.domain.Page;
import lombok.Data;

import java.util.List;

/**
 * 分页数据封装类
 * @author LiuXin
 * @date 2021/12/12 22:15
 **/
@Getter
@Setter
public class CommonPage<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;

    /**
     * 将PageHelper分页后的list转为分页信息
     * @author LiuXin
     * @date 2021/12/12 22:34
     * @param list 
     * @return com.lx.mall.api.CommonPage<T>
     */
    public static <T> CommonPage<T> resetPage(List<T> list) {
        val commonPage = new CommonPage<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        commonPage.setTotalPage(pageInfo.getPages());
        commonPage.setPageNum(pageInfo.getPageNum());
        commonPage.setPageSize(pageInfo.getPageSize());
        commonPage.setTotal(pageInfo.getTotal());
        commonPage.setList(pageInfo.getList());
        return commonPage;
    }

    /**
     * 将SpringData分页后的list转为分页信息
     * @author LiuXin
     * @date 2021/12/12 22:34
     * @param page
     * @return com.lx.mall.api.CommonPage<T>
     */
    public static <T> CommonPage<T> resetPage(Page<T> page) {
        val commonPage = new CommonPage<T>();
        commonPage.setTotalPage(page.getTotalPages());
        commonPage.setPageNum(page.getNumber());
        commonPage.setPageSize(page.getSize());
        commonPage.setTotal(page.getTotalElements());
        commonPage.setList(page.getContent());
        return commonPage;
    }
}
