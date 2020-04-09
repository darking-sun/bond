package com.dev.bond.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dev.bond.entity.Admin;
import com.dev.bond.result.Result;
import com.dev.bond.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wzj123
 * @since 2019-11-16
 */
@RestController
public class AdminController  {

    @Autowired
    private IAdminService adminService;

    @CrossOrigin
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@Valid @RequestBody Admin requestAdminName){
        String adminName = requestAdminName.getAdminName();
        String adminPassword = requestAdminName.getAdminPassword();
        Admin admin  = adminService.selectOne(new EntityWrapper<Admin>().eq("ADMIN_NAME", adminName));
        String password = admin.getAdminPassword();
        if(adminPassword.equals(password)){
            return  new Result(200,"登录成功");
        }else{
            return new Result(400,"账号或密码错误");
        }
    }

}

