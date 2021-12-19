package com.lx.mall.dao;

import com.lx.mall.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色管理自定义Dao
 *
 * @author LiuXin
 * @date 2021/12/19 21:59
 **/
public interface UmsAdminRoleRelationDao {
    /**
     * 获取指定用户的所有权限
     * @author LiuXin
     * @date 2021/12/19 22:01
     * @param adminId 
     * @return java.util.List<com.lx.mall.mbg.model.UmsPermission>
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
