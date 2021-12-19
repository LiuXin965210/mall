package com.lx.mall.service.impl;

import com.lx.mall.common.utils.JwtTokenUtil;
import com.lx.mall.dao.UmsAdminRoleRelationDao;
import com.lx.mall.mbg.mapper.UmsAdminMapper;
import com.lx.mall.mbg.model.UmsAdmin;
import com.lx.mall.mbg.model.UmsPermission;
import com.lx.mall.service.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 后台管理员业务类
 *
 * @author LiuXin
 * @date 2021/12/19 21:46
 **/
@Slf4j
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Resource
    private UmsAdminMapper adminMapper;
    @Resource
    private UmsAdminRoleRelationDao adminRoleRelationDao;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        return null;
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        return null;
    }

    @Override
    public String login(String username, String password) {
        return null;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return null;
    }
}
