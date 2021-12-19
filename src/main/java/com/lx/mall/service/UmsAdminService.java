package com.lx.mall.service;

import com.lx.mall.mbg.model.UmsAdmin;
import com.lx.mall.mbg.model.UmsPermission;

import java.util.List;

/**
 * 后台管理员接口类
 *
 * @author LiuXin
 * @date 2021/12/19 12:19
 **/
public interface UmsAdminService {
    /**
     * 根据用户名获取后台管理员
     * @author LiuXin
     * @date 2021/12/19 21:40
     * @param username
     * @return com.lx.mall.mbg.model.UmsAdmin
     */
    UmsAdmin getAdminByUsername(String username);
    
    /**
     * 注册功能
     * @author LiuXin
     * @date 2021/12/19 21:40
     * @param umsAdminParam 
     * @return com.lx.mall.mbg.model.UmsAdmin
     */
    UmsAdmin register(UmsAdmin umsAdminParam);
    
    /**
     * 登录
     * @author LiuXin
     * @date 2021/12/19 21:40
     * @param username 
     * @param password 
     * @return java.lang.String
     */
    String login(String username, String password);
    
    /**
     * 获取用户所有权限
     * @author LiuXin
     * @date 2021/12/19 21:40
     * @param adminId 
     * @return java.util.List<com.lx.mall.mbg.model.UmsPermission>
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
