package com.lx.mall.service;

import com.lx.mall.mbg.model.PmsBrand;

import java.util.List;

/**
 * 品牌管理接口类
 *
 * @author LiuXin
 * @date 2021/12/19 12:19
 **/
public interface PmsBrandService {
    /**
     * 获取所有品牌
     * @author LiuXin
     * @date 2021/12/19 21:44
     * @return java.util.List<com.lx.mall.mbg.model.PmsBrand>
     */
    List<PmsBrand> listAllBrand();

    /**
     * 创建品牌
     * @author LiuXin
     * @date 2021/12/19 21:45
     * @param pmsBrand 
     * @return int
     */
    int createBrand(PmsBrand pmsBrand);

    /**
     * 更新品牌
     * @author LiuXin
     * @date 2021/12/19 21:45
     * @param id 
     * @param pmsBrand 
     * @return int
     */
    int updateBrand(Long id, PmsBrand pmsBrand);

    /**
     * 删除品牌
     * @author LiuXin
     * @date 2021/12/19 21:45
     * @param id 
     * @return int
     */
    int deleteBrand(Long id);

    /**
     * 获取指定页的品牌
     * @author LiuXin
     * @date 2021/12/19 21:45
     * @param pageNum 
     * @param pageSize 
     * @return java.util.List<com.lx.mall.mbg.model.PmsBrand>
     */
    List<PmsBrand> listBrand(int pageNum, int pageSize);

    /**
     * 根据主键获取品牌
     * @author LiuXin
     * @date 2021/12/19 21:45
     * @param id 
     * @return com.lx.mall.mbg.model.PmsBrand
     */
    PmsBrand getBrand(Long id);
}
