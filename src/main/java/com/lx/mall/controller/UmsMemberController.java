package com.lx.mall.controller;

import com.lx.mall.api.CommonResult;
import com.lx.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 会员管理Controller
 *
 * @author LiuXin
 * @date 2021/12/19 19:14
 **/
@Controller
@RequestMapping("/sso")
@ResponseBody
@Api(tags = "UmsMemberController")
public class UmsMemberController {
    @Resource
    private UmsMemberService memberService;

    @GetMapping("/getAuthCode")
    @ApiOperation("获取验证码")
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @PostMapping("/verfiyAuthCode")
    @ApiOperation("校验验证码")
    public CommonResult updatePassword(@RequestParam String telephone, @RequestParam String authCode) {
        return memberService.verifyAuthCode(telephone, authCode);
    }
}
